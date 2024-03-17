package com.srishti.authService.services;

import com.srishti.authService.entities.User;
import com.srishti.authService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
<<<<<<< HEAD
import java.util.Objects;
import java.util.stream.Collectors;
=======
import java.util.Optional;
>>>>>>> database-feature


@Service
public class UserServiceImpl implements UserService{

<<<<<<< HEAD
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
=======
    @Autowired
    private UserRepository userRepository;
>>>>>>> database-feature

    @Override
    public List<User> getAllUsers(){

        try{
<<<<<<< HEAD
            System.out.println("Reached in Services");
            return this.mockUserDB;
=======
            List<User> list = this.userRepository.findAll();
            return list;
>>>>>>> database-feature
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
<<<<<<< HEAD
    public User addUser(User newUser) {
        this.mockUserDB.add(newUser);
        return newUser;
=======
    public User addUser(User user) {
        try {
            User newUser = userRepository.save(user);
            return newUser;
        }
        catch(Exception e){
            System.out.println("The user cannot be added");
            return user;
        }

>>>>>>> database-feature
    }

    @Override
    public String deleteById(Integer id){
<<<<<<< HEAD
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
=======
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
>>>>>>> database-feature

        try{
            userRepository.save(userToBeChanged);
        }
<<<<<<< HEAD
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
=======
        catch(Exception e){
            System.out.println("Cannot update user");
>>>>>>> database-feature
        }
        return userToBeChanged;
    }

}