package com.srishti.authService.services;

import com.srishti.authService.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {


    public List<User> getAllUsers();


    public String deleteById(Integer id);

    public User UpdateUser(Integer id, User user);

    public User addUser(User u);

    public Optional<User> getUserById(Integer id);

}
