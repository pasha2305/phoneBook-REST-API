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
    //создание объекта класса UserService
    private static UserService userService = UsersController.getUserService();

    //получение списка всех записей телефонной книжки пользователя с указанным id
    public List<PhoneItem> getPhones(String id) throws UserNotFound {
        return userService.getOneUser(id).getPhoneItemList();
    }

    //добавление записи в телефонную книжку пользователя
    public PhoneItem addPhoneItem(String id, PhoneItem phoneItem) throws UserNotFound {
        userService.getOneUser(id).getPhoneItemList().add(phoneItem);
        return phoneItem;
    }

    //получение одной записи из телефонной книжки пользователя по id
    public PhoneItem getPhoneItem(String idUser, String idPhoneItem) throws PhoneItemNotFound, UserNotFound {
        for(PhoneItem phoneItem : userService.getOneUser(idUser).getPhoneItemList()){
            if (phoneItem.getId().equals(idPhoneItem)){
                return phoneItem;
            }
        }
        throw new PhoneItemNotFound("Записи с указанным id не найдено.");
    }

    //удаление записи из телефонной книжки пользователя
    public List<PhoneItem> deletePhone(String idUser, String idPhoneItem) throws UserNotFound, PhoneItemNotFound {
        userService.getOneUser(idUser).getPhoneItemList().remove(getPhoneItem(idUser, idPhoneItem));
        return userService.getOneUser(idUser).getPhoneItemList();
    }

    //обновление записи в телефонной книжке пользователя
    public PhoneItem updateItem(String idUser, String idPhoneItem, PhoneItem phoneItem) throws UserNotFound, PhoneItemNotFound {
        PhoneItem phoneItem1 = getPhoneItem(idUser, idPhoneItem);
        phoneItem1.setId(idPhoneItem);
        phoneItem1.setContactName(phoneItem.getContactName());
        phoneItem1.setNumber(phoneItem.getNumber());
        return phoneItem1;
    }

    //поиск записи в телефонной книжке по номеру телефона
    public PhoneItem findByNumber(String idUser, String number) throws UserNotFound, PhoneItemNotFound {
        for(PhoneItem phoneItem : userService.getOneUser(idUser).getPhoneItemList()){
            if (phoneItem.getNumber().equals(number)){
                return phoneItem;
            }
        }
        throw new PhoneItemNotFound("Записи с указанным номером не найдено.");
    }

    //ссылка на объект userService
    public static UserService getUserService() {
        return userService;
    }
}
