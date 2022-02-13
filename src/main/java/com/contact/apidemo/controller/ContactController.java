package com.contact.apidemo.controller;

import com.contact.apidemo.model.Contact;
import com.contact.apidemo.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/api/user/{userId}")
public class ContactController {



    @Autowired
    private ContactService contactService;


    @PostMapping("/contact")
    public Contact createContact(@PathVariable(value = "userId") Long userId,
                                 @RequestBody Contact contact){
        System.out.println("calling create contact");
        return contactService.createContact(userId, contact);
    }


}
