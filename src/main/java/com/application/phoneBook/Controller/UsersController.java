package com.application.phoneBook.Controller;

import com.application.phoneBook.Entity.User;
import com.application.phoneBook.Exception.UserNotFound;
import com.application.phoneBook.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    UserService userService = new UserService();

    @GetMapping
    public ResponseEntity getAll(){
        try{
            return ResponseEntity.ok().body(userService.getUserList());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка.");
        }
    }

    @PostMapping
    public ResponseEntity addUser(@RequestBody User user){
        try{
            userService.addUser(user);
            return ResponseEntity.ok().body("Пользователь успешно добавлен!");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка.");
        }
    }

    @GetMapping("{id}")
    public ResponseEntity getOne(@PathVariable String id){
        try {
            return ResponseEntity.ok().body(userService.userToModel(userService.getOneUser(id)));
        } catch (UserNotFound f){
            return ResponseEntity.badRequest().body(f.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка.");
        }
    }

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

//    @GetMapping
//    public ResponseEntity
}
