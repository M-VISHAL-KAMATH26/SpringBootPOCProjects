package com.poc.jobportal.exception;

public class JobNotFoundException extends RuntimeException{
    public JobNotFoundException(long jobId){
        super("job not found with the jobId:"+jobId);
    }
}
