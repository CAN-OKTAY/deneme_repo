package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Servis.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "userAll")
    public List<User> getAllUser(){
        return userService.getUsers();
    }

    @GetMapping(path = "")
    public Optional<User> getUserById(@RequestParam(name = "id") int id){
        return  userService.findById(id);
    }

    @PostMapping
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @PutMapping(path = "updateUser")
    public void updateUserById(@RequestBody User user,@RequestParam(name = "id")int id){
        userService.updateUser(user,id);
    }
}
