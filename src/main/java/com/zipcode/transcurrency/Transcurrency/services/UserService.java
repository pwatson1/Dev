package com.zipcode.transcurrency.Transcurrency.services;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.zipcode.transcurrency.Transcurrency.models.User;
import com.zipcode.transcurrency.Transcurrency.repositories.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class UserService {
    private static final Logger logger = LogManager.getLogger(UserService.class);

    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(Long id){
        logger.info("Retrieved user by I.D.");
        return userRepository.findOne(id);
    }

    public User getUser(String name){
        logger.info("Retrieved user by name.");
        User user1 = userRepository.findAll()
                .stream()
                .filter(user -> name.equals(user.getName()))
                .findAny()
                .orElse(null);

        return user1;
    }

    public List<User> getAllUsers(){
        logger.info("Retrieved all users.");
        List<User> users = new ArrayList<>();
        userRepository.findAll()
                .forEach(users::add);
        return users;
    }

    public void addUser(User user){
        logger.info("Added user.");
        userRepository.save(user);
    }

    public boolean addUserWithVerification(User user){

        if(userRepository.equals(user)){
            logger.info("UserRepository not equal to user. No user added.");
            return false;
        }
        userRepository.save(user);
        logger.info("UserRepository equal to user. User added.");
        return true;
    }

    public void updateUser(Long id, User user){
        logger.info("User info modified.");
        userRepository.save(user);
    }

    public void deleteUser(Long id){
        logger.info("User deleted by I.D..");
        userRepository.delete(id);
    }

    public void deleteUser(String name){
        logger.info("User deleted by name.");

        List<User> userList = new ArrayList<>();
        userList = userRepository.findAll();

        for(User user: userList){
            if(user.getName().equals(name)){
                userRepository.delete(user.getId());
//                userList.remove(user);
                break;
            }
        }
        }
}
