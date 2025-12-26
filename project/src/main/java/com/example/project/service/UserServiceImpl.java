package com.example.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.model.User;
import com.example.project.repository.UserRepo;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;
    @Override
    public User addUser(User user){
        return userRepo.save(user);
    }
    @Override
    public User loginUser(User user){
        User existingUser=userRepo.findByEmail(user.getEmail());
        if(existingUser!=null && existingUser.getPassword().equals(user.getPassword())){
            return existingUser;
        }
        return null;
    }
    @Override
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
    @Override
    public User getUserById(Long id){
        return userRepo.findById(id).orElse(null);
    }
    @Override
    public User updateUser(Long id, User user){
        if(userRepo.existsById(id)){
            user.setId(id);
            return userRepo.save(user);
        }
        return null;
    }
    @Override
    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }
    @Override
    public List<User> getUsersByRole(String role){
        return userRepo.findByRole(role);
    }
    @Override
    public List<User> getUsersByUsernameAndRole(String username, String role){
        return userRepo.findByUsernameAndRole(username,role);
    }
}
