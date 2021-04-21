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

    @GetMapping("{id_user}/phones/{id_phone}")
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
}
