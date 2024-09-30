package com.jobhive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jobhive.model.Notification;
import com.jobhive.model.User;
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
	List<Notification> findByUserOrderByTimestampDesc(User user);
	
	 @Query("SELECT COUNT(n) FROM Notification n WHERE n.user.id = :userId AND n.isRead = false")
	 int countUnreadNotificationsByUserId(@Param("userId") Long userId);
}
