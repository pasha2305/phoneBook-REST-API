package com.application.phoneBook.Services;

import com.application.phoneBook.Entity.PhoneItem;
import com.application.phoneBook.Entity.User;
import com.application.phoneBook.Exception.PhoneItemNotFound;
import com.application.phoneBook.Exception.UserNotFound;
import org.junit.Test;

import static org.junit.Assert.*;

public class PhoneServiceTest {
    PhoneService phoneService = new PhoneService();

    @Test
    public void addPhoneItem() throws UserNotFound {
        phoneService.getUserService().addUser(new User("1", "User1"));
        PhoneItem phoneItem = new PhoneItem("1", "User111", "+79465784930");
        phoneService.addPhoneItem("1", phoneItem);
        assertNotNull(phoneService.getPhones("1"));
    }

    @Test
    public void updatePhone() throws UserNotFound, PhoneItemNotFound {
        phoneService.getUserService().addUser(new User("1", "User1"));
        PhoneItem phoneItem = new PhoneItem("1", "User111", "+79465784930");
        phoneService.addPhoneItem("1", phoneItem);
        PhoneItem phoneItem1 = new PhoneItem("1", "User1Upd", "+74238432345");
        phoneService.updateItem("1","1", phoneItem1);
        assertTrue(phoneService.getUserService().getOneUser("1").getPhoneItemList().get(0).getContactName().equals("User1Upd"));
        assertTrue(phoneService.getUserService().getOneUser("1").getPhoneItemList().get(0).getNumber().equals("+74238432345"));
    }

    @Test
    public void deletePhoneItem() throws UserNotFound, PhoneItemNotFound {
        phoneService.getUserService().addUser(new User("2", "User2"));
        phoneService.addPhoneItem("2", new PhoneItem("1", "User111", "+79465784930"));
        phoneService.addPhoneItem("2", new PhoneItem("2", "User1Upd", "+74238432345"));
        System.out.println(phoneService.getUserService().getOneUser("2").getPhoneItemList().size());
        assertTrue(phoneService.getUserService().getOneUser("2").getPhoneItemList().size() == 2);
        phoneService.deletePhone("2", "1");
        assertTrue(phoneService.getUserService().getOneUser("2").getPhoneItemList().size() == 1);
        phoneService.deletePhone("2", "2");
        assertTrue(phoneService.getUserService().getOneUser("2").getPhoneItemList().size() == 0);
    }

    @Test
    public void findUserByNameOrFragment() throws UserNotFound, PhoneItemNotFound {
        phoneService.getUserService().addUser(new User("3", "User123"));
        PhoneItem phoneItem = new PhoneItem("1", "User111", "+79465784930");
        PhoneItem phoneItem1 = new PhoneItem("2", "User1Upd", "+74238432345");
        phoneService.addPhoneItem("3", phoneItem);
        phoneService.addPhoneItem("3", phoneItem1);
        assertTrue(phoneService.findByNumber("3", "+79465784930").equals(phoneItem));
        assertTrue(phoneService.findByNumber("3", "+74238432345").equals(phoneItem1));
    }
}