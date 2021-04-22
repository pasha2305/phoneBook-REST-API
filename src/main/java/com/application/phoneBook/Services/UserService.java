package com.application.phoneBook.Services;

import com.application.phoneBook.Entity.User;
import com.application.phoneBook.Exception.UserNotFound;
import com.application.phoneBook.Model.UserModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> userList = new ArrayList<>(); //Список пользователей

    //получение списка всех пользователей
    public List<UserModel> getUserList() {
        List<UserModel> userModelList = new ArrayList<>();
        for (User user : userList){
            userModelList.add(userToModel(user));
        }
        return userModelList;
    }

    //преобразование сущности пользователя в модель
    public UserModel userToModel(User user){
        return new UserModel(user.getId(), user.getName());
    }

    //добавление нового пользователя в список
    public void addUser(User user){
        userList.add(user);
    }

    //получение одного пользователя по id
    public User getOneUser(String id) throws UserNotFound {
        for (User u: userList){
            if (u.getId().equals(id)){
                return u;
            }
        }
        throw new UserNotFound("Пользователь не найден.");
    }

    //обновление данных пользователя
    public User update(String id, User user) throws UserNotFound {
        User u = getOneUser(id);
        u.setId(id);
        u.setName(user.getName());
        return u;
    }

    //удаление данных пользователя из списка
    public List<UserModel> delete(String id) throws UserNotFound {
        User user = getOneUser(id);
        userList.remove(user);
        return getUserList();
    }

    //поиск пользователя по имени или фрагменту имени
    public List<UserModel> findByName(String name){
        List<UserModel> findList = new ArrayList<>();
        for(User u : userList){
            if (u.getName().contains(name)){
                findList.add(userToModel(u));
            }
        }
        return findList;
    }

    //получение списка всех пользователей
    public List <User> getUsers(){
        return userList;
    }
}
