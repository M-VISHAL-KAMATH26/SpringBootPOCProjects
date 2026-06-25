package com.poc.jobportal.repository;

import com.poc.jobportal.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicantRepository extends JpaRepository<Applicant,Long> {

    //Java persistence query language

    //jpql for find by email
    @Query("SELECT a from Applicant a WHERE a.email=:email")
    Applicant findApplicantByEmail(@Param("email") String email);

    //jpql for find applicants containing skills keyword
    @Query("SELECT a from Applicant a where a.skills LIKE %:keyword%")
    List<Applicant> findApplicanyContainingSkill(@Param("keyword") String keyword);

    //jpql for find applicants containing names keyword
    @Query("SELECT a from Applicant  a where a.name LIKE %:keyword%")
    List<Applicant>  findApplicantContainsName(@Param("keyword") String keyword);

    //jpql for total number of applicants
    @Query("SELECT COUNT(a) from Applicant a")
    int countApplicant();

    //jpql t give list of applicants ordered by name
    @Query("SELECT a from Applicant a ORDER BY a.name ASC ")
    List<Applicant> orderByName();



}
