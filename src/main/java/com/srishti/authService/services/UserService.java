package com.srishti.authService.services;

import com.srishti.authService.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    public List<User> getAllUsers();

    public String deleteById(Integer id);

    public void UpdateUser(Integer id, User user);

    public User addUser(User u);

}
