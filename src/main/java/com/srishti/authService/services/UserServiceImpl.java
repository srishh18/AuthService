package com.srishti.authService.services;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public String getAllUsers(){
        try{
            System.out.println("Reached in Services");
            return "";
        }
        catch(Exception e){
            System.out.println("Error in Services");
           return "User not found";
        }

    }

    @Override
    public String deleteById(){
        System.out.println("Deleted user");
        return "";
    }
}
