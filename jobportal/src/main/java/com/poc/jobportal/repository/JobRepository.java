package com.poc.jobportal.repository;

import com.poc.jobportal.model.Job;
import com.poc.jobportal.model.JobStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job,Long> {

    List<Job> findByStatus(JobStatus status);

    List<Job> findByCompany(String company);

    List<Job> findBySalaryGreaterThan(Double salary);

    List<Job> findByTitleContaining(String title);

    List<Job> findByLocationContaining(String location);

    List<Job> findByCompanyAndStatus(String company, JobStatus status);

    List<Job> findTop3ByOrderBySalaryDesc();

}
