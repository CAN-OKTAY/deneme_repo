package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.servis.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/getList")
    public List<User> getUserWithPagination(@RequestParam(name = "page")int page){
        return userService.getUserWithPagination(page);
    }

    @GetMapping(path = "/get")
    public User getUserById(@RequestParam(name = "id") int id){
        return  userService.findById(id);
    }

    @PostMapping(path = "/addUser")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @PutMapping(path = "/updateUser")
    public void updateUserById(@RequestBody User user,@RequestParam(name = "id")int id){
        userService.updateUser(user,id);
    }

    @DeleteMapping(path = "/deleteUser")
    public void deleteUserById(@RequestParam(name = "id")int id){
        userService.deleteUser(id);
    }
}
