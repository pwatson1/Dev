package com.zipcode.transcurrency.Transcurrency.services;

import com.zipcode.transcurrency.Transcurrency.models.User;
import com.zipcode.transcurrency.Transcurrency.repositories.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(Long id){
        return userRepository.findOne(id);
    }

    public User getUser(String name){
        User user1 = userRepository.findAll()
                .stream()
                .filter(user -> name.equals(user.getName()))
                .findAny()
                .orElse(null);
        return user1;
    }

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll()
                .forEach(users::add);
        return users;
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public boolean addUserWithVerification(User user){
        if(userRepository.equals(user)){
            return false;
        }
        userRepository.save(user);
        return true;
    }

    public void updateUser(Long id, User user){
        userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.delete(id);
    }

    public void deleteUser(String name){

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
