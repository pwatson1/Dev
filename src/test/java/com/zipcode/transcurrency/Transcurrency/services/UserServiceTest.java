package com.zipcode.transcurrency.Transcurrency.services;

import com.zipcode.transcurrency.Transcurrency.models.User;
import com.zipcode.transcurrency.Transcurrency.repositories.IUserRepository;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    private UserService userService;

    @Mock
    private IUserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userRepository);
    }

    @Test
    public void getAllUsersTest() throws Exception {

        User user1 = new User();
        List<User> userData = new ArrayList<>();
        userData.add(user1);

        when(userService.getAllUsers()).thenReturn(userData);
        List<User> users = userService.getAllUsers();

        assertEquals(users.size(), 1);
    }

    @Test(expected = RuntimeException.class)
    public void addUserTest() throws Exception {

        when(userRepository.save(any(User.class))).thenThrow(RuntimeException.class);

        User usertest = new User();

        userService.addUser(usertest);

    }

    @Test
    public void addUserWithVerificationTest() throws Exception{

        when(userRepository.save(any(User.class))).thenReturn(new User());
        User user1 = new User();

        //assertThat(userService.addUserWithVerification(user1), is(notNullValue()));
    }

    @Test
    public void deleteUserById() throws Exception {
    }

}