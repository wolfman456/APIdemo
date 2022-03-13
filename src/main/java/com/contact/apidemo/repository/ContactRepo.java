package com.contact.apidemo.repository;

import com.contact.apidemo.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepo extends JpaRepository<Contact, Long> {
    List<Contact> findContactByUser_Id (Long userId);

}
