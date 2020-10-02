package com.Team4.example.QuickJobs.Controller;

import com.Team4.example.QuickJobs.Entity.User;
import com.Team4.example.QuickJobs.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("user")
public class UserController {

        @Autowired
        private UserService userService;

        @PostMapping("/add")
        public User addUser(@RequestBody User  user){
            return userService.createUser(user);
        }

        @PostMapping("/addUsers")
        public List<User> addUsers(@RequestBody List<User> userList){
            return userService.createUsers(userList);
        }

        @GetMapping("/getAll")
        public List<User> getAllUsers(){
            return userService.getAllUsers();
        }

        @GetMapping("/getUser/{id}")
        public User findUserById(@PathVariable int id){
            return userService.getUser(id);
        }

        @PutMapping("/updateUser")
        public User updateUser(@RequestBody User  user){
            return userService.updateUser(user);
        }

        @DeleteMapping("/deleteUser/{id}")
        public String deleteUser(@PathVariable int id){
            return userService.deleteUser(id);
        }

}
