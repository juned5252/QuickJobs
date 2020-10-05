package com.Team4.example.QuickJobs.Utilities;


import com.Team4.example.QuickJobs.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class Common {

    @Autowired
    private UserRepository userRepository;

    public double calculateRating(Long Id, double rating){
        double currentRating = userRepository.findById(Id).get().getRating();
        int jobsCompleted = userRepository.findById(Id).get().getJobsCompleted();
        double newRating;
        if (jobsCompleted == 0){
            newRating = currentRating+rating;
            return newRating;
        }
        else {
            newRating = (currentRating+rating)/jobsCompleted;
            return newRating;
        }
    }
}
