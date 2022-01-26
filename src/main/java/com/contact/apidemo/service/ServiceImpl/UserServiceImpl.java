package com.contact.apidemo.service.ServiceImpl;

import com.contact.apidemo.exception.InformationExistException;
import com.contact.apidemo.model.User;
import com.contact.apidemo.repository.UserRepo;
import com.contact.apidemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    @Override
    public User createUser(User userObject) {
        System.out.println("calling user service create user ====");
        if (!userRepo.existsByEmail(userObject.getEmail())) {
            userObject.setEmail(userObject.getEmail());
            userObject.setName(userObject.getName());
            userObject.setPhone(userObject.getPhone());
            return userRepo.save(userObject);
        } else {
            throw new InformationExistException("user with email " + userObject +
                    " Already exists.");
        }

    }
}
