package com.application.phoneBook.Services;

import com.application.phoneBook.Controller.UsersController;
import com.application.phoneBook.Entity.PhoneItem;
import com.application.phoneBook.Entity.User;
import com.application.phoneBook.Exception.PhoneItemNotFound;
import com.application.phoneBook.Exception.UserNotFound;
import com.application.phoneBook.Model.UserModel;
import org.springframework.stereotype.Service;

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
}
