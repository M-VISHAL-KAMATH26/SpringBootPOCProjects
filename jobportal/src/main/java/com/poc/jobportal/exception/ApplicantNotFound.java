package com.poc.jobportal.exception;

public class ApplicantNotFound extends RuntimeException {
    public ApplicantNotFound(long applicantId){
        super("Applicant with id not found: "+applicantId);
    }
}
