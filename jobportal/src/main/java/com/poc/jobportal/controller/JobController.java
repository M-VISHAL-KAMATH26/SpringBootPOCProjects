package com.poc.jobportal.controller;


import com.poc.jobportal.model.Job;
import com.poc.jobportal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    JobService jobService;

//health check
    @GetMapping("/")
    public String getHealthCheck(){
        return "welcome to the job portal";
    }

    //to create a job
    @PostMapping("/api/jobs")
    public Job createJob(@RequestBody Job job){
        return jobService.createJob(job);
    }
    //get all the jobs
    @GetMapping("/api/jobs")
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }
    //get the job by id
    @GetMapping("/api/jobs/{jobId}")
    public Job getJobById(@PathVariable long jobId){
        return jobService.getJobById(jobId);
    }

    //update the job
    @PutMapping("/api/jobs/{id}")
    public Job updateJob(@PathVariable long jobId,@RequestBody Job job){
        return jobService.updateJob(jobId,job);
    }

    //delete the job
    @DeleteMapping("/api/jobs/{jobId}")
    public void deleteJob(@PathVariable long jobId){
        jobService.deleteJob(jobId);
    }

}
