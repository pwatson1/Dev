package com.zipcode.transcurrency.Transcurrency.controllers;

import com.zipcode.transcurrency.Transcurrency.models.User;
import com.zipcode.transcurrency.Transcurrency.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(userController)
                .build();
    }

    @Test
    public void getAllUsers() throws Exception {

        User user1 = new User("Tom", "superTom");
        user1.setId(1L);
        User user2 = new User("Jane", "superJane");
        user2.setId(2L);

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        when(userService.getAllUsers()).thenReturn(userList);

        Long id_1 = 1L;

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("S[0].id", is(1L)))
                .andExpect(jsonPath("$[0].name", is("Tom")))
                .andExpect(jsonPath("$[0].username", is("superTom")));

        verify(userService, times(1)).getAllUsers();
    }

    @Test
    public void getUserById() throws Exception{
        User user1 = new User("Tom", "superTom");
        Long id = 1L;
        user1.setId(id);
        when(userService.getUser(user1.getId())).thenReturn(user1);
        mockMvc.perform(get("/users/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Tom")))
                .andExpect(jsonPath("$.username", is("superTom")));
        verify(userService, times(1)).getUser(id);
    }

    @Test
    public void addUserTest() {
        User user1 = new User("Tom", "superTom");
        Long id = 1L;
        user1.setId(id);

    }
}