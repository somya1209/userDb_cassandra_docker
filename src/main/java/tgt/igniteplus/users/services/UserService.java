package tgt.igniteplus.users.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tgt.igniteplus.users.entities.User;
import tgt.igniteplus.users.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    //getAllUsers
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //createUser
    public User createUser(User user){
        return userRepository.save(user);
    }

    //getUserByID
    public Optional<User> getUserById(Long id){

        Optional<User> user=userRepository.findById(id);
        return user;
    }

    //updateUserById
    public User updateUserById( Long id,User user){

        return userRepository.save(user);

    }
    //deleteUserById
    public void deleteUserByID(Long id){
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
        }
    }


}
