package com.contact.apidemo.service;

import com.contact.apidemo.model.Contact;

public interface ContactService {

    public Contact createContact(Long userId, Contact contact);

}
