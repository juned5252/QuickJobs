package com.Team4.example.QuickJobs.Service;

import com.Team4.example.QuickJobs.Entity.Job;
import com.Team4.example.QuickJobs.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobService {

    @Autowired
    public JobRepository jobRepository;

    public List<Job> getAllJob(){
        return jobRepository.findAll();
    }

    public Job getSingleJob(long id){
        return jobRepository.findById(id).orElse(null);
    }

    public void createJob(Job job){
        jobRepository.save(job);
    }

    //this implementation doesn't work for updating job. need to modify

//    public Job updateJob(Job job){
//        Job currentJob = jobRepository.findById(job.getJobId()).orElse(null);
//        currentJob.setDescription(job.getDescription());
//        currentJob.setwage(job.getwage());
//        currentJob.setLocation(job.getLocation());
//        currentJob.setCategory(job.getCategory());
//        currentJob.setStatus(job.getStatus());
//        return currentJob;
//    }


    public Job updateJob(Job job){
        return jobRepository.save(job);
    }

    //need implementation for these data to be auto generated
//    private Long jobId;
//    private Date date;

    public void deleteJob(long id){
        jobRepository.deleteById(id);
    }
}
