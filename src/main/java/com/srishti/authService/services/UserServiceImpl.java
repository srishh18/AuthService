package com.srishti.authService.services;

import com.srishti.authService.entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    List<User> mockUserDB;
    public UserServiceImpl() {

        mockUserDB = new ArrayList<>();

        mockUserDB.addAll(
                Arrays.asList(
                        new User[]{
                                new User("Sristi", "overthinker420", "srishtinegi1718@gmail.com", "hairaanAatma69"),
                                new User("Punit", "supersharma", "punit420@gmail.com", "hairaanAatma69")
                            }
                        )
        );
    }

    @Override
    public List<User> getAllUsers(){
        try{
            System.out.println("Reached in Services");
            return mockUserDB;
        }
        catch(Exception e){
            System.out.println("Error in Services");
           return new ArrayList<>();
        }

    }



    @Override
    public String deleteById(){
        System.out.println("Deleted user");
        return "";
    }

    @Override
    public void UpdateUser(Integer id, User userToBeChanged) {
        try {
            User userFromDB = findbyId(id);
            if(userFromDB == null) {
                System.out.println("id not found error");
               return;
            }
            updateById(userToBeChanged, userFromDB);

        } catch (Exception e) {
            System.out.println("error in user-service");
        }
    }

    public void updateById(User userToBeChanged, User userFromDB) {
        userFromDB.setEmail(userToBeChanged.getEmail());
        userFromDB.setPassword(userToBeChanged.getPassword());
        userFromDB.setName(userToBeChanged.getName());
        userFromDB.setUsername(userToBeChanged.getUsername());
        System.out.println("user updated");
    }

    public User findbyId(Integer id) {
        for(User u : mockUserDB) {
            if(u.getId() == id) return u;
        }
        return null;
    }
}
