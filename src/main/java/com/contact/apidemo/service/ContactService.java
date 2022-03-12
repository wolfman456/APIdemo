package com.contact.apidemo.service;

import com.contact.apidemo.model.Contact;

import java.util.List;

public interface ContactService {

    public Contact createContact(Long userId, Contact contact);
    public List<Contact> getAllContacts(Long userId);
    public Contact getSingleContact (Long userId, Long contactId);
    public Contact updateContact(Long userId, Long contactId, Contact contactObject);
    public String deleteContact(Long userId, Long ContactId);

}
