package com.jobhive.repository;

import com.jobhive.model.Job;
import com.jobhive.model.JobApplication;
import com.jobhive.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
	boolean existsByJobAndUser(Job job, User user);
	
	@Query("SELECT COUNT(ja) FROM JobApplication ja WHERE ja.user.userId = :userId")
	long countJobsAppliedByUserId(@Param("userId") Long userId);
	 
	// Custom query method to find job applications by user ID
    List<JobApplication> findByUser_UserId(Long userId);
    
    @Query("SELECT ja FROM JobApplication ja WHERE ja.job.id = :jobId")
    List<JobApplication> findByJob_Id(@Param("jobId") Long jobId);
}