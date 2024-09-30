package com.jobhive.repository;

import com.jobhive.model.Job;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
	 List<Job> findTop6ByOrderByPostedDateDesc();
	 
	 List<Job> findByUser_UserId(Long userId);
}