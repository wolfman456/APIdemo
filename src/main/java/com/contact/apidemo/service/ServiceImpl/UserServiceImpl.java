package com.contact.apidemo.service.ServiceImpl;

import com.contact.apidemo.exception.InformationExistException;
import com.contact.apidemo.exception.InformationNotFoundException;
import com.contact.apidemo.model.User;
import com.contact.apidemo.repository.UserRepo;
import com.contact.apidemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getSingleUser(Long userId) {
        System.out.println("all get single user");
       if(!userRepo.existsById(userId)){
           throw new InformationNotFoundException("No User is " + userId + " found");
       }else{
           return userRepo.getById(userId);
       }
    }

    @Override
    public User updateUser(Long userId, User user) {
        User userObject = userRepo.findUserById(userId);
        if(userObject == null){
            throw new InformationNotFoundException("no user with iD " + userId + " found");
        }else {
            userObject.setEmail(user.getEmail());
            userObject.setPhone(user.getPhone());
            userObject.setName(userObject.getName());
            return userRepo.save(userObject);
        }



    }

    @Override
    public String deleteUser(Long userId) {
        User user = userRepo.findUserById(userId);
        if(user == null){
            throw new InformationNotFoundException("No user with ID " + userId + " found");
        }else {
            userRepo.delete(user);
            return " User " + user.getName() + " has been deleted";
        }
    }


}
