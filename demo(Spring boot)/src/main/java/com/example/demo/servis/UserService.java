package com.example.demo.servis;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(int id){
        return userRepository.findById(id).get();
    }

    public List<User> getUserWithPagination(int page){
        return userRepository.findAll((Pageable) PageRequest.of(page-1,2,Sort.by("username"))).getContent();
    }

    public void addUser(User newUser){
        userRepository.save(newUser);
    }

    public void updateUser(@NotNull User user, int id){
        Optional<User> userFromDB=userRepository.findById(id);
        if(userFromDB.isPresent()) {
            User userUpdate = userFromDB.get();
            userUpdate.setUsername(user.getUsername());
            userUpdate.setPassword(user.getPassword());
            userRepository.save(userUpdate);
        }
        else{
           throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,"User-ID which is wanted to update not found.");
        }
    }
}
