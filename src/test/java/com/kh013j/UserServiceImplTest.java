//package com.kh013j;
//
//import com.kh013j.model.domain.*;
//import com.kh013j.model.service.interfaces.UserService;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.*;
//
//import static org.hamcrest.core.Is.is;
//import static org.hamcrest.core.IsEqual.equalTo;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNull;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//
//public class UserServiceImplTest {
//    @Autowired
//    private UserService userService;
//
//    private Role adminRole = new Role(1, "Administrator");
//    private Role cookRole = new Role(2, "Cook");
//    private Role waiterRole = new Role(3, "Waiter");
//    private Role userRole = new Role(4, "User");
//
//    private List<User> users = new ArrayList<>();
//
//
//    @Test
//    public void create() {
//        User user = new User();
//        // creating a user without id
//        user.setEmail("nordik@i.ua");
//        user.setPassword("111111");
//        user.setName("Alex");
//        user.setEnabled(false);
//
//        // valid insert
//        User createdUser = userService.create(user);
//        Assert.assertThat(createdUser.getName(), is(equalTo(user.getName())));
//    }
//
//    @Test(expected = Exception.class)
//    public void tryToCreate() {
//        userService.create(new User());
//    }
//
//    @Test
//    public void findById() {
//        User user = new User();
//        user.setEmail("foros@i.ua");
//        user.setPassword("222222");
//        user.setName("Miho");
//        user.setConfirmationtoken("token123321");
//        user.setEnabled(false);
//        user.setRole(adminRole);
//        User createdUser = userService.create(user);
//        //search user by id of a created user
//        User foundUser = userService.findById(createdUser.getId());
//
//        assertEquals(user, foundUser);
//    }
//    public void tryToFindById() {
//        assertNull(userService.findById(-1));
//    }
//
//    @Test
//    public void delete(){
//        User lastUser = new User(users.size()+1, "mamba@i.ua", "123456", "Mumbai",
//                "token1234", false, adminRole);
//        User createdUser = userService.create(lastUser);
//        User deletedUser = userService.delete(createdUser.getId());
//        Assert.assertNull(userService.findById(deletedUser.getId()));
//    }
//
//    @Test(expected = Exception.class)
//    public void tryToDelete() {
//        userService.delete(-1);
//    }
//
//    @Test
//    public void findAll() {
//        Assert.assertFalse(userService.findAll().isEmpty());
//    }
//
//    @Test
//    public void update(){
//        String name = "SuperAdmin";
//
//        User updatedUser = userService.findById(1L);
//        User user = new User(updatedUser);
//        user.setName(name);
//        updatedUser = userService.update(user);
//        Assert.assertThat(updatedUser.getName(), is(equalTo(name)));
//    }
//
//    @Test(expected = Exception.class)
//    public void tryToUpdate() {
//        User updatedUser = userService.findById(3L);
//        updatedUser.setId(-1L);
//        userService.update(updatedUser);
//    }
//
//    @Test
//    public void findByEmail() {
//        User user = new User();
//        user.setEmail("sirius@i.ua");
//        user.setPassword("333333333");
//        user.setName("Mars");
//        user.setConfirmationtoken("token6354984");
//        user.setEnabled(false);
//        user.setRole(waiterRole);
//        User createdUser = userService.create(user);
//        //search user by mail of a created user
//        User foundUser = userService.findByEmail(createdUser.getEmail());
//        assertEquals(user, foundUser);
//    }
//    public void tryToFindByEmail() {
//        assertNull(userService.findByEmail("wrong@mail.ua"));
//    }
//
//    @Test
//    public void findByConfirmationToken() {
//        User user = new User();
//        user.setEmail("sirius@i.ua");
//        user.setPassword("444444444444");
//        user.setName("Mars");
//        user.setConfirmationtoken("token24859658745");
//        user.setEnabled(false);
//        user.setRole(userRole);
//        User createdUser = userService.create(user);
//        User foundUser = userService.findByConfirmationtoken(createdUser.getConfirmationtoken());
//        assertEquals(user, foundUser);
//    }
//
//    public void tryToFindByConfirmationtoken() {
//        assertNull(userService.findByConfirmationtoken("44444444"));
//    }
//}