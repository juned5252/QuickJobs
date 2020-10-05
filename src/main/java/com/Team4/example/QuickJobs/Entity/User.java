package com.Team4.example.QuickJobs.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String location;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Job> jobList;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Comment> commentList;
    private int jobsCompleted;
    private double rating;

    public User() {
    }

    public User(String phoneNumber, String firstName, String lastName, String location) {
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

//    public List<Job> getJobList() {
//        return jobList;
//    }
//
//    public void setJobList(List<Job> jobList) {
//        this.jobList = jobList;
//    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getJobsCompleted() {
        return jobsCompleted;
    }

    public void setJobsCompleted(int jobsCompleted) {
        this.jobsCompleted = jobsCompleted;
    }
}
