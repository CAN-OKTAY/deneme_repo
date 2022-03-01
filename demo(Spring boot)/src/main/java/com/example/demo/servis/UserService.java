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
        User userByid=userFromDB.get();
        userByid.setUsername(user.getUsername());
        userByid.setPassword(user.getPassword());
        userRepository.save(userByid);
    }

    public List<User> getUserWithPagination(int beginPage){
        int skipRows=(beginPage-1)*2;//each page has to be only 2 json object(User).
        return userRepository.getUserWithPagination(skipRows);
    }


}
