package com.application.phoneBook.Services;

import com.application.phoneBook.Entity.User;
import com.application.phoneBook.Exception.UserNotFound;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService = new UserService();
    @Test
    public void addUser() throws UserNotFound {
        User user = new User("1", "User1");
        userService.addUser(user);
        assertNotNull(userService.getOneUser("1"));
    }

    @Test
    public void updateUser() throws UserNotFound {
        User user = new User("1", "User1");
        userService.addUser(user);
        User user1 = new User("1", "User1Upd");
        userService.update("1",user1);
        assertTrue(userService.getOneUser("1").getName().equals("User1Upd"));
    }

    @Test
    public void deleteUser() throws UserNotFound {
        userService.addUser(new User("1", "User1"));
        userService.addUser(new User("2", "User2"));
        assertTrue(userService.getUserList().size() == 2);
        userService.delete("1");
        assertTrue(userService.getUserList().size() == 1);
        userService.delete("2");
        assertTrue(userService.getUserList().size() == 0);
    }

    @Test
     public void findUserByNameOrFragment(){
        userService.addUser(new User("1", "User1 1 1"));
        assertTrue(userService.findByName("User1").get(0).getName().equals("User1 1 1"));
        assertTrue(userService.findByName("User1 1 1").get(0).getName().equals("User1 1 1"));
        assertTrue(userService.findByName("1").get(0).getName().equals("User1 1 1"));
     }
}