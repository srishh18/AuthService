package com.srishti.authService.services;

import com.srishti.authService.entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService{

    List<User> mockUserDB;
    public UserServiceImpl() {

        this.mockUserDB = new ArrayList<>();

        this.mockUserDB.addAll(
                Arrays.asList(
                        new User[]{
                                new User("Srishti", "overthinker420", "srishtinegi1718@gmail.com", "hairaanAatma69"),
                                new User("Punit", "supersharma", "punit420@gmail.com", "hairaanAatma69")
                            }
                        )
        );
        this.mockUserDB.get(0).setId(1);
        this.mockUserDB.get(1).setId(2);
    }

    @Override
    public List<User> getAllUsers(){
        try{
            System.out.println("Reached in Services");
            return this.mockUserDB;
        }
        catch(Exception e){
            System.out.println("Error in Services");
           return new ArrayList<>();
        }
    }

    @Override
    public User addUser(User newUser) {
        this.mockUserDB.add(newUser);
        return newUser;
    }

    @Override
    public String deleteById(Integer id){
        this.mockUserDB = this.mockUserDB.stream()
                .filter(user -> Objects.equals(user.getId(), id))
                .collect(Collectors.toList());
        return "Updated list";
    }

    @Override
    public void UpdateUser(Integer id, User userToBeChanged) {
        try {
            User userFromDB = findById(id);
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

    //getting single user by id
    public User findById(Integer id) {
        for(User u : this.mockUserDB) {
            if(Objects.equals(u.getId(), id)) return u;
        }
        return null;
    }

}