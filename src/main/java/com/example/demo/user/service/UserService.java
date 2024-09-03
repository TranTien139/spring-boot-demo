package com.example.demo.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.user.model.User;
import com.example.demo.user.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public User creatUser(User user){
        return userRepository.save(user);
    }

    public User updaUser(Long id, User userDetails) {
        return userRepository.findById(id).map(user->{
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            return userRepository.save(user);
        }).orElseGet(()->{
            userDetails.setId(id);
            return userRepository.save(userDetails);
        });
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
