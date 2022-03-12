package com.contact.apidemo.service.ServiceImpl;

import com.contact.apidemo.exception.InformationNotFoundException;
import com.contact.apidemo.model.Contact;
import com.contact.apidemo.model.User;
import com.contact.apidemo.repository.ContactRepo;
import com.contact.apidemo.repository.UserRepo;
import com.contact.apidemo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    ContactRepo contactRepo;

    @Override
    public Contact createContact(Long userId, Contact contact) {
        Contact contactObject= new Contact();
        User user = userRepo.findUserById(userId);
        if(user == null){
            throw new InformationNotFoundException("no user is userId: " + userId + " found.");
        }else{

            contactObject.setUser(user);
            contactObject.setEmail(contact.getEmail());
            contactObject.setName(contactObject.getEmail());
            contactObject.setPhone(contact.getPhone());
        }
        return contactRepo.save(contactObject);
    }

    @Override
    public List<Contact> getAllContacts(Long userId) {
        User user = userRepo.findUserById(userId);
        if (user != null) {
            return user.getContacts();
        }else {
            throw new RuntimeException("No user with " + userId + " found.");
        }
    }

    @Override
    public Contact getSingleContact(Long userId, Long contactId) {
        return null;
    }

    @Override
    public Contact updateContact(Long userId, Long contactId, Contact contactObject) {
        return null;
    }

    @Override
    public String deleteContact(Long userId, Long ContactId) {
        return null;
    }
}
