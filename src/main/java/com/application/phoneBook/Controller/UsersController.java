package com.application.phoneBook.Controller;


import com.application.phoneBook.Entity.User;
import com.application.phoneBook.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    UserService userService = new UserService();

    @GetMapping
    public ResponseEntity getAll(){
        try{
            return ResponseEntity.ok().body(userService.getUserList());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка.");
        }
    }

//    @GetMapping
//    public ResponseEntity
}
