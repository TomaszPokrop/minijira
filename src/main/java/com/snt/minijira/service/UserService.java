package com.snt.minijira.service;

import com.snt.minijira.exception.StatusNotFoundExeption;
import com.snt.minijira.model.User;
import com.snt.minijira.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new StatusNotFoundExeption("User by status" + id + "was not found"));
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.findById(id);
    }

}
