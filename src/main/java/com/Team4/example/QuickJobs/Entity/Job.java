package com.Team4.example.QuickJobs.Entity;

import javax.persistence.*;
import java.util.Date;

    @Entity
    public class Job {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long jobId;
        private String description;
        private double wage;
        private String location;
        private Date date;
        private String category;
        private String status;
        @ManyToOne()
        private User user;

        public Job() {
        }

        public Job(String description, double wage, String location, Date date, String category, String status, User user) {
            this.description = description;
            this.wage = wage;
            this.location = location;
            this.date = date;
            this.category = category;
            this.status = status;
            this.user = user;
        }

        public Long getJobId() {
            return jobId;
        }

        public void setJobId(Long jobId) {
            this.jobId = jobId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getwage() {
            return wage;
        }

        public void setwage(double wage) {
            this.wage = wage;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }