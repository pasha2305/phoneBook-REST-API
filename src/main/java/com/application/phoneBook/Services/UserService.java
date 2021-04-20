package com.application.phoneBook.Services;

import com.application.phoneBook.Entity.User;
import com.application.phoneBook.Model.UserModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> userList = new ArrayList<>(){{
        add(new User(1l,"User1"));
        add(new User(2l,"User2"));
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
}
