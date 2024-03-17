package com.srishti.authService.services;

import com.srishti.authService.entities.User;
import com.srishti.authService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers(){

        try{
            List<User> list = this.userRepository.findAll();
            return list;
        }
        catch(Exception e){
            System.out.println("Cannot get all users");
            return null;
        }

    }

    public Optional<User> getUserById(Integer id){

        try {
            Optional<User> user = this.userRepository.findById(id);
            return user;
        }
        catch(Exception e){
            System.out.println("The user you requested does not exist!");
            return null;
        }
    }

    @Override
    public User addUser(User user) {
        try {
            User newUser = userRepository.save(user);
            return newUser;
        }
        catch(Exception e){
            System.out.println("The user cannot be added");
            return user;
        }

    }

    @Override
    public String deleteById(Integer id){
        try {
            userRepository.deleteById(id);
        }
        catch(Exception e){
            System.out.println("User cannot be deleted");
        }
        return null;

    }

    @Override
    public User UpdateUser(Integer id, User userToBeChanged) {
        userToBeChanged.setId(id);

        try{
            userRepository.save(userToBeChanged);
        }
        catch(Exception e){
            System.out.println("Cannot update user");
        }
        return userToBeChanged;
    }

}
