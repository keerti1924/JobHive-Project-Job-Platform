package com.jobhive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobhive.model.User;
import com.jobhive.model.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    VerificationToken findByToken(String token);
    VerificationToken findByUser(User user);
}
