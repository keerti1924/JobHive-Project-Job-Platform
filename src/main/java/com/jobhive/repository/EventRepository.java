package com.jobhive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jobhive.model.Event;
import com.jobhive.model.User;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
	
	@Query("SELECT COUNT(e) FROM Event e")
    long countEvents();
	List<Event> findByUser(User user);
	
}