package com.Team4.example.QuickJobs.Service;

import com.Team4.example.QuickJobs.Entity.User;
import com.Team4.example.QuickJobs.Repository.JobRepository;
import com.Team4.example.QuickJobs.Repository.UserRepository;
import com.Team4.example.QuickJobs.Utilities.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    Common common = new Common();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobRepository jobRepository;

    public User createUser(User user){
        user.setRating(0.0);
        user.setJobsCompleted(0);
        return userRepository.save(user);
    }

    public User updateUser(User user){
        User currentUser = userRepository.findById(user.getUserId()).orElse(null);
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setLocation(user.getLocation());
        currentUser.setUserId(user.getUserId());
        currentUser.setPhoneNumber(user.getPhoneNumber());
        return userRepository.save(currentUser);
    }

    public User getUser(long Id){
        return userRepository.findById(Id).orElse(null);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public String deleteUser(long Id){
        userRepository.deleteById(Id);
        return "user with Id: "+Id+"has been removed from DB";
    }
}
