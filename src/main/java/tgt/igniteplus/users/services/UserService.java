package tgt.igniteplus.users.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tgt.igniteplus.users.entities.User;
import tgt.igniteplus.users.exceptions.UserNotFoundException;
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
    public Optional<User> getUserById(Long id) throws UserNotFoundException {

        Optional<User> user=userRepository.findById(id);
        if(!user.isPresent())
            throw new UserNotFoundException("user not found");
        return user;
    }

    //updateUserById
    public User updateUserById( Long id,User user)throws UserNotFoundException{

        if(!userRepository.findById(id).isPresent()) {
            throw new UserNotFoundException("employee not found");
        }
        return userRepository.save(user);

    }
    //deleteUserById
    public void deleteUserByID(Long id){
        Optional<User> user=userRepository.findById(id);
        if(!user.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"employee not found in repo,enter correct details");
        }

        userRepository.deleteById(id);
    }


}
