package com.poc.jobportal.service;


import com.poc.jobportal.exception.JobNotFoundException;
import com.poc.jobportal.model.Job;
import com.poc.jobportal.model.JobStatus;
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

        return jobrepo.findById(jobId).orElseThrow(()->new JobNotFoundException(jobId));
    }

        public Job updateJob(long jobId, Job job) {
            Job existing = jobrepo.findById(jobId)
                    .orElseThrow(()->new JobNotFoundException(jobId));
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

    //Derived Queries example
    public List<Job> findJobByStatus(JobStatus status){
        return jobrepo.findByStatus(status);
    }

    public List<Job> findJobBySalaryGreaterThan(Double salary){
        return jobrepo.findBySalaryGreaterThan(salary);
    }

    public List<Job> findJobByTitleContaining(String title){
        return  jobrepo.findByTitleContaining(title);
    }

    public List<Job> findTopThreeJob(){
        return jobrepo.findTop3ByOrderBySalaryDesc();
    }
}
