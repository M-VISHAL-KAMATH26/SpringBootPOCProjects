package com.poc.jobportal.service;


import com.poc.jobportal.exception.ApplicantNotFound;
import com.poc.jobportal.model.Applicant;
import com.poc.jobportal.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {

    @Autowired
    ApplicantRepository applicantRepo;

    public Applicant createApplicant(Applicant applicant){
        return applicantRepo.save(applicant);
    }

    public List<Applicant> getAllApplicant(){
        return applicantRepo.findAll();
    }

    public Applicant getApplicantById(long applicantId){
        return applicantRepo.findById(applicantId).orElseThrow(()->new ApplicantNotFound(applicantId));
    }

    public Applicant updateApplicant(long applicantId,Applicant applicant){
        Applicant existing=applicantRepo.findById(applicantId).orElseThrow(()->new ApplicantNotFound(applicantId));
        existing.setName(applicant.getName());
        existing.setSkills(applicant.getSkills());
        existing.setEmail(applicant.getEmail());
        return applicantRepo.save(existing);
    }

    public void deleteApplicant(long applicantId){
        applicantRepo.deleteById(applicantId);
    }


    //java persistence query language usage

    public List<Applicant> findBySkill(String keyword){
        return applicantRepo.findApplicanyContainingSkill(keyword);
    }
    public List<Applicant> findByName(String keyword){
        return applicantRepo.findApplicantContainsName(keyword);
    }
    public int getCount(){
        return applicantRepo.countApplicant();
    }


}
