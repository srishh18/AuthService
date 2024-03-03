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
            List<User> userServiceResponse = this.userService.getAllUsers();
            return userServiceResponse;
        }
        catch(Exception e){
            return new ArrayList<>();
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
        String userServiceResponse = this.userService.deleteById();
        return userServiceResponse;

    }


}
