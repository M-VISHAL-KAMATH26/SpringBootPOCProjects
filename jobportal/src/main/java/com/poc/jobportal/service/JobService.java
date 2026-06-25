package com.poc.jobportal.service;


import com.poc.jobportal.model.Job;
import com.poc.jobportal.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    JobRepository jobrepo;

    public Job createJob(Job job){
        return jobrepo.save(job);
    }

    public List<Job> getAllJobs(){
        return jobrepo.findAll();
    }

    public Job getJobById(long jobId){
        return jobrepo.findById(jobId).orElse(new Job());
    }

        public Job updateJob(long jobId, Job job) {
            Job existing = jobrepo.findById(jobId)
                    .orElseThrow(() -> new RuntimeException("Job not found"));
            existing.setTitle(job.getTitle());
            existing.setCompany(job.getCompany());
            existing.setLocation(job.getLocation());
            existing.setSalary(job.getSalary());
            existing.setStatus(job.getStatus());
            return jobrepo.save(existing);
        }


    public void deleteJob(long jobId){
        jobrepo.deleteById(jobId);
    }
}
