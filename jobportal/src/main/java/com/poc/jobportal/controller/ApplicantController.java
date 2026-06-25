package com.poc.jobportal.controller;

import com.poc.jobportal.model.Applicant;
import com.poc.jobportal.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

    @Autowired
    ApplicantService applicantService;

    //create applicant
    @PostMapping
    public Applicant addApplicant(@RequestBody  Applicant applicant){
        return applicantService.createApplicant(applicant);
    }

    //get the applicants
    @GetMapping
    public List<Applicant> getApplicants(){
        return applicantService.getAllApplicant();
    }

    //get the applicants by id
    @GetMapping("/{applicantId}")
    public Applicant getApplicantById(@PathVariable long applicantId){
        return applicantService.getApplicantById(applicantId);
    }

    //update the applicant record
    @PutMapping("/{applicantId}")
    public Applicant updateApplicant(@PathVariable long applicantId,@RequestBody Applicant applicant){
        return applicantService.updateApplicant(applicantId,applicant);
    }

    //delete the applicant record
    @DeleteMapping("/{applicantId}")
    public String deleteApplicant(@PathVariable long applicantId){
        applicantService.deleteApplicant(applicantId);
        return "deleted successfully";
    }

}
