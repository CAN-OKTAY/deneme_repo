package com.example.demo.servis;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

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

    public List<User> getUserWithPagination(int beginPage){
        beginPage=beginPage-1 ; //decreased  by 1 because
        int skipRows=beginPage*2;//each page has 2 json field.
        return userRepository.getUserWithPagination(skipRows);
    }


}
