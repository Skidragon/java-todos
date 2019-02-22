package com.lambdaschool.todos.controllers;

import com.lambdaschool.todos.models.User;
import com.lambdaschool.todos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path={"/users"}, produces= MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    UserRepository userRepo;

    @GetMapping("")
    public List<User> allUsers() {
        return userRepo.findAll();
    }

    @GetMapping("userid/{userid}")
    public User getUserById(@PathVariable long userid) {
        var user = userRepo.findById(userid);

        if(user.isPresent()) {
            return user.get();
        }
        return null;
    }
}
