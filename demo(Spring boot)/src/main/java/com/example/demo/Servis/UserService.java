package com.example.demo.Servis;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(){
        return  userRepository.findAll();
    }

    public Optional<User> findById(int id){
        return userRepository.findById(id);
    }

    public void addUser(User newUser){
        userRepository.save(newUser);
    }

    public void updateUser(@NotNull User user, int id){
        Optional<User> userFromDB=userRepository.findById(id);

        userFromDB.get().setUsername(user.getUsername());
        userFromDB.get().setPassword(user.getPassword());

        userRepository.save(userFromDB.get());
    }


}
