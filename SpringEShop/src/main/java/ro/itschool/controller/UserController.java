package ro.itschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.itschool.entity.User;
import ro.itschool.service.UserService;


import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping(path = "/all")
    public List<User> getUser(){
        return userService.getUsers();
    }

    @PostMapping(path = "/post")
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }

    @PutMapping(path = "/{id}" )
    public void updateUser(@PathVariable Integer id, @RequestBody User user){
        userService.updateUser(id, user);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }

}







