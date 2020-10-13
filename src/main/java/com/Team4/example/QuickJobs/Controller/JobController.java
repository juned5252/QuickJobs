package com.Team4.example.QuickJobs.Controller;

import com.Team4.example.QuickJobs.Entity.Job;
import com.Team4.example.QuickJobs.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class JobController {

    @Autowired
    public JobService jobService;

    @GetMapping("/get-job")
    public List<Job> retrieveAllJobs(){
        return jobService.getAllJob();
    }

    @GetMapping("/get-job/{id}")
    public Job retrieveSingleJob(@PathVariable long id){
        return jobService.getSingleJob(id);
    }

    @PostMapping("/post-job")
    public ResponseEntity<Job> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update-job")
    public ResponseEntity<Job> updateJob(@RequestBody Job currentJob){
        Optional<Job> jobToUpdate = jobService.jobRepository.findById(currentJob.getJobId());
        if(jobToUpdate==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        jobService.updateJob(currentJob);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete-job/{id}")
    public ResponseEntity<Job> deleteSingleJob(@PathVariable long id){
        try {
            jobService.deleteJob(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
