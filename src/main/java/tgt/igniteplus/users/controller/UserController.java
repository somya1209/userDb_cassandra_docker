package tgt.igniteplus.users.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tgt.igniteplus.users.entities.User;
import tgt.igniteplus.users.exceptions.UserNotFoundException;
import tgt.igniteplus.users.services.UserService;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //getAllUsers method
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //createUser method
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    //getUserById
    @GetMapping("/user/{id}")
    public Optional<User> getUserBYId(@NotNull @PathVariable("id") Long id){
        try {
            return userService.getUserById(id);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
    }

    //updateUserById
    @PutMapping("/users/{id}")
    public User updateUserById(@PathVariable Long id,@RequestBody User user){
        try {
            return userService.updateUserById(id,user);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    //deleteUserById
    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable("id") Long id)throws UserNotFoundException{
        userService.deleteUserByID(id);
    }
}
