package com.srishti.authService.services;

import com.srishti.authService.entities.User;
import com.srishti.authService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

//    List<User> mockUserDB;
//    public UserServiceImpl() {
//
//        mockUserDB = new ArrayList<>();
//
//        mockUserDB.addAll(
//                Arrays.asList(
//                        new User[]{
//                                new User("Srishti", "overthinker420", "srishtinegi1718@gmail.com", "hairaanAatma69"),
//                                new User("Punit", "supersharma", "punit420@gmail.com", "hairaanAatma69")
//                            }
//                        )
//        );
//        mockUserDB.get(0).setId(1);
//        mockUserDB.get(1).setId(2);
//    }

    @Override
    public List<User> getAllUsers(){

        List<User> list = this.userRepository.findAll();
        return list;

    }

    @Override
    public User addUser(User user) {
        User newUser = userRepository.save(user);
        return newUser;
    }

    @Override
    public String deleteById(Integer id){

        userRepository.deleteById(id);
        return null;

    }

    @Override
    public void UpdateUser(Integer id, User userToBeChanged) {

        userToBeChanged.setId(id);
        userRepository.save(userToBeChanged);
    }

}
