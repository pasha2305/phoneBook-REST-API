package com.application.phoneBook.Controller;

import com.application.phoneBook.Entity.User;
import com.application.phoneBook.Exception.UserNotFound;
import com.application.phoneBook.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UsersController {
    static private UserService userService = new UserService();

    //получение списка всех пользователей
    @GetMapping
    public ResponseEntity getAll(){
        try{
            return ResponseEntity.ok().body(userService.getUserList());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка.");
        }
    }

    //добавление нового пользователя
    @PostMapping
    public ResponseEntity addUser(@RequestBody User user){
        try{
            userService.addUser(user);
            return ResponseEntity.ok().body("Пользователь успешно добавлен!");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка.");
        }
    }

    //получение пользователя по id
    @GetMapping("/id/{id}")
    public ResponseEntity getOne(@PathVariable String id){
        try {
            return ResponseEntity.ok().body(userService.userToModel(userService.getOneUser(id)));
        } catch (UserNotFound f){
            return ResponseEntity.badRequest().body(f.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка.");
        }
    }

    //обновление пользователя
    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable String id, @RequestBody User user){
        try{
            return ResponseEntity.ok().body(userService.userToModel(userService.update(id, user)));
        }catch (UserNotFound f){
            return ResponseEntity.badRequest().body(f.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка.");
        }
    }

    //удаление пользователя
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable String id){
        try{
            return ResponseEntity.ok().body(userService.delete(id));
        }catch (UserNotFound f){
            return ResponseEntity.badRequest().body(f.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка.");
        }
    }

    //поиск пользователя по имени
    @GetMapping("/name/{name}")
    public ResponseEntity findUsersByName(@PathVariable String name){
        try{
            return ResponseEntity.ok().body(userService.findByName(name));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка.");
        }
    }

    static public UserService getUserService() {
        return userService;
    }
}
