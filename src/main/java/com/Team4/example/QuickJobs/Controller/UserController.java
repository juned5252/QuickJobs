package com.Team4.example.QuickJobs.Controller;

import com.Team4.example.QuickJobs.Entity.User;
import com.Team4.example.QuickJobs.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

        @Autowired
        private UserService userService;

        @PostMapping("/addUser")
        public ResponseEntity<User> addUser(@RequestBody User  user){
            return ResponseEntity.ok().body(userService.createUser(user));
        }

        @GetMapping("/getUsers")
        public ResponseEntity<List<User>> getAllUsers(){
            return ResponseEntity.ok().body(userService.getAllUsers());
        }

        @GetMapping("/getUser/{id}")
        public ResponseEntity<User> findUserById(@PathVariable long id){
            return ResponseEntity.ok(userService.getUser(id));
        }

        @PutMapping("/updateUser")
        public ResponseEntity<User> updateUser(@RequestBody User  user){
            return ResponseEntity.ok().body(userService.updateUser(user));
        }

        @DeleteMapping("/deleteUser/{id}")
        public String deleteUser(@PathVariable long id){
            return userService.deleteUser(id);
        }

}
