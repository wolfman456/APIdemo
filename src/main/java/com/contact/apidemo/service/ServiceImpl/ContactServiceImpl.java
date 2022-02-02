package com.contact.apidemo.service.ServiceImpl;

import com.contact.apidemo.repository.ContactRepo;
import com.contact.apidemo.repository.UserRepo;
import com.contact.apidemo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    ContactRepo contactRepo;
}
