package com.application.phoneBook.Services;

import com.application.phoneBook.Controller.UsersController;
import com.application.phoneBook.Entity.PhoneItem;
import com.application.phoneBook.Exception.PhoneItemNotFound;
import com.application.phoneBook.Exception.UserNotFound;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneService {
    private static UserService userService = UsersController.getUserService();

    public List<PhoneItem> getPhones(String id) throws UserNotFound {
        return userService.getOneUser(id).getPhoneItemList();
    }

    public PhoneItem addPhoneItem(String id, PhoneItem phoneItem) throws UserNotFound {
        userService.getOneUser(id).getPhoneItemList().add(phoneItem);
        return phoneItem;
    }

    public PhoneItem getPhoneItem(String idUser, String idPhoneItem) throws PhoneItemNotFound, UserNotFound {
        for(PhoneItem phoneItem : userService.getOneUser(idUser).getPhoneItemList()){
            if (phoneItem.getId().equals(idPhoneItem)){
                return phoneItem;
            }
        }
        throw new PhoneItemNotFound("Записи с указанным id не найдено.");
    }

    public List<PhoneItem> deletePhone(String idUser, String idPhoneItem) throws UserNotFound, PhoneItemNotFound {
        userService.getOneUser(idUser).getPhoneItemList().remove(getPhoneItem(idUser, idPhoneItem));
        return userService.getOneUser(idUser).getPhoneItemList();
    }

    public PhoneItem updateItem(String idUser, String idPhoneItem, PhoneItem phoneItem) throws UserNotFound, PhoneItemNotFound {
        PhoneItem phoneItem1 = getPhoneItem(idUser, idPhoneItem);
        phoneItem1.setId(idPhoneItem);
        phoneItem1.setContactName(phoneItem.getContactName());
        phoneItem1.setNumber(phoneItem.getNumber());
        return phoneItem1;
    }

    public PhoneItem findByNumber(String idUser, String number) throws UserNotFound, PhoneItemNotFound {
        for(PhoneItem phoneItem : userService.getOneUser(idUser).getPhoneItemList()){
            if (phoneItem.getNumber().equals(number)){
                return phoneItem;
            }
        }
        throw new PhoneItemNotFound("Записи с указанным номером не найдено.");
    }

    public static UserService getUserService() {
        return userService;
    }
}
