package com.srishti.authService.controllers;

import com.srishti.authService.entities.User;
import com.srishti.authService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> getUsers(){
        try{
            List<User> list = this.userService.getAllUsers();
            System.out.println("Reaching in service");
            return list;
        }
        catch(Exception e){
            return new ArrayList<>();
        }
    }


    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        try {
            User newUser = this.userService.addUser(user);
            System.out.println(user);
            return newUser;
        }
        catch(Exception e){
            return user;
        }

    }

    @PutMapping("/user/{id}")
    public void updateUserDB(@PathVariable("id") Integer id, @RequestBody User user) {
        try {
            this.userService.UpdateUser(id, user);
            return;
        } catch (Exception e) {
            System.out.println("error in controller");
            return;
        }
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Integer id){

        try{
            String userServiceResponse = this.userService.deleteById(id);
            return userServiceResponse;
        }
        catch(Exception e){
            System.out.println("Cannot Delete the user");
            return "";
        }

    }


}
