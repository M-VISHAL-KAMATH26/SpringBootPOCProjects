package com.poc.jobportal.repository;

import com.poc.jobportal.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant,Long> {

}
