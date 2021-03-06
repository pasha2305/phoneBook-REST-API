package com.application.phoneBook.Controller;

import com.application.phoneBook.Entity.PhoneItem;
import com.application.phoneBook.Exception.PhoneItemNotFound;
import com.application.phoneBook.Exception.UserNotFound;
import com.application.phoneBook.Services.PhoneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/")
public class PhoneItemsController {
    PhoneService phoneService = new PhoneService();

    //получение списка записей из телефонной книжки пользователей
    @GetMapping("{id}/phones")
    public ResponseEntity getPhones(@PathVariable String id){
        try{
            return ResponseEntity.ok().body(phoneService.getPhones(id));
        }catch (UserNotFound f){
            return ResponseEntity.badRequest().body(f.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка.");
        }
    }

    //добавление записи в телефонную книжку пользователя
    @PostMapping("{id}/phones")
    public ResponseEntity addPhone(@PathVariable String id, @RequestBody PhoneItem phoneItem){
        try {
            return ResponseEntity.ok().body(phoneService.addPhoneItem(id, phoneItem));
        }catch (UserNotFound f){
            return ResponseEntity.badRequest().body(f.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка.");
        }
    }

    //получение записи из телефонной книжки по id
    @GetMapping("{id_user}/phones/id/{id_phone}")
    public ResponseEntity getPhoneItemById(@PathVariable String id_user, @PathVariable String id_phone) {
        try {
            return ResponseEntity.ok().body(phoneService.getPhoneItem(id_user, id_phone));
        }catch (UserNotFound f){
            return ResponseEntity.badRequest().body(f.getMessage());
        }catch (PhoneItemNotFound f1){
            return ResponseEntity.badRequest().body(f1.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка.");
        }
    }

    //удаление записи из телефонной книжки пользователя по id
    @DeleteMapping("{id_user}/phones/{id_phone}")
    public ResponseEntity deletePhoneItem(@PathVariable String id_user, @PathVariable String id_phone){
        try {
            return ResponseEntity.ok().body(phoneService.deletePhone(id_user, id_phone));
        }catch(UserNotFound f){
            return ResponseEntity.badRequest().body(f.getMessage());
        }catch (PhoneItemNotFound f1){
            return ResponseEntity.badRequest().body(f1.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    //обновление записи в телефонной книжке пользователя
    @PutMapping("{id_user}/phones/{id_phone}")
    public ResponseEntity updatePhoneItem(@PathVariable String id_user, @PathVariable String id_phone, @RequestBody PhoneItem phoneItem){
        try{
            return ResponseEntity.ok().body(phoneService.updateItem(id_user, id_phone, phoneItem));
        }catch (UserNotFound f){
            return ResponseEntity.badRequest().body(f.getMessage());
        }catch (PhoneItemNotFound f1){
            return ResponseEntity.badRequest().body(f1.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка.");
        }
    }


    //поиск записи в телефонной книжке по номеру телефона
    @GetMapping("{id_user}/phones/number/{number}")
    public ResponseEntity findByNumber(@PathVariable String id_user, @PathVariable String number){
        try{
            return ResponseEntity.ok().body(phoneService.findByNumber(id_user, number));
        }catch (UserNotFound f) {
            return ResponseEntity.badRequest().body(f.getMessage());
        }catch (PhoneItemNotFound f1) {
            return ResponseEntity.badRequest().body(f1.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка.");
        }
    }
}
