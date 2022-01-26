package com.contact.apidemo.repository;

import com.contact.apidemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    User findUserByEmail(String email);
}
