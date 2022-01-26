package com.contact.apidemo.repository;

import com.contact.apidemo.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Contact, Long> {

}
