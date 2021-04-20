package com.application.phoneBook.Services;

import com.application.phoneBook.Entity.User;
import com.application.phoneBook.Exception.UserNotFound;
import com.application.phoneBook.Model.UserModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> userList = new ArrayList<>(){{
        add(new User("1","User1"));
        add(new User("2","User2"));
    }};

    public List<UserModel> getUserList() {
        List<UserModel> userModelList = new ArrayList<>();
        for (User user : userList){
            userModelList.add(userToModel(user));
        }
        return userModelList;
    }

    public UserModel userToModel(User user){
        return new UserModel(user.getId(), user.getName());
    }

    public void addUser(User user){
        userList.add(user);
    }

    public UserModel getOne(String id) throws UserNotFound {
        UserModel user = null;
        for (User u: userList){
            if (u.getId().equals(id)){
                user = userToModel(u);
                return user;
            }
        }
        if (user == null){
            throw new UserNotFound("Пользователь не найден.");
        }
        return user;
    }
}
