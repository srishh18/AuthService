package com.srishti.authService.services;

import com.srishti.authService.entities.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public String deleteById();

    public void UpdateUser(Integer id, User user);
}
