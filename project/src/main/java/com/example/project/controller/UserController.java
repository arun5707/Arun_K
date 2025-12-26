package com.example.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.User;
import com.example.project.service.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        User createdUser=userService.addUser(user);
        if(createdUser!=null){
            return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        User createdUser = userService.addUser(user);
        if(createdUser!=null){
            return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user){
        User loggedInUser = userService.loginUser(user);
        if(loggedInUser!=null){
            return new ResponseEntity<>(loggedInUser,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user = userService.getUserById(id);
        if(user!=null){
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        User updateUser = userService.updateUser(id,user);
        if(updateUser!=null){
            return new ResponseEntity<>(updateUser,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id){
        User user = userService.getUserById(id);
        if(user!=null){
            userService.deleteUser(id);
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
    @GetMapping("/role/{role}")
    public ResponseEntity<?> getUsersByRole(@PathVariable String role){
        List<User> users=userService.getUsersByRole(role);
        if(users.isEmpty()){
            return new ResponseEntity<>("No users found with role: "+role,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    @GetMapping("/username/{username}/role/{role}")
    public ResponseEntity<List<User>> getUsersByUsernameAndRole(@PathVariable String username, @PathVariable String role){
        List<User> users=userService.getUsersByUsernameAndRole(username,role);
        if(users.isEmpty()){
            return new ResponseEntity<>(users,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
}