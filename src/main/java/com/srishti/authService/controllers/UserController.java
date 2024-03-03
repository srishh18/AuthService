package com.srishti.authService.controllers;

import com.srishti.authService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String getUsers(){
        try{
            String userServiceResponse = this.userService.getAllUsers();
            return userServiceResponse;

        }
        catch(Exception e){
            return "Error";

        }
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        String userServiceResponse = this.userService.deleteById();
        return userServiceResponse;

    }


}
