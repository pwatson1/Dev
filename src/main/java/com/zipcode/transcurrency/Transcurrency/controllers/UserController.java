package com.zipcode.transcurrency.Transcurrency.controllers;

import com.zipcode.transcurrency.Transcurrency.models.User;
import com.zipcode.transcurrency.Transcurrency.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final Logger LOG = LoggerFactory.getLogger(CreditCardController.class);

    private UserService userService;

    public UserController(){}

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/users")
    public List<User> getAllUsers(){

        LOG.info("");
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{id:[0-9]+}")
    public User getUser (@PathVariable("id") Long id)

        {LOG.info("getUser by id");
        return userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{name:[a-zA-Z]+}")
    public User getUser (@PathVariable("name") String name){

        LOG.info("getUser by name");
        return userService.getUser(name);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void addUser(@RequestBody User user){

        LOG.info("addUser");
        userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user){

        LOG.info("updateUser by id");
        userService.updateUser(id, user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id:[0-9]+}")
    public void deleteUser(@PathVariable("id") Long id){

        LOG.info("deleteUser by id");
        userService.deleteUser(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{name:[a-zA-Z]+}")
    public void deleteUser(@PathVariable("name") String name){

        LOG.info("deleteUser by name");
        userService.deleteUser(name);
    }

}
