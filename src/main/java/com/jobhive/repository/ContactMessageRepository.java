package com.jobhive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobhive.model.Contact;

@Repository
public interface ContactMessageRepository extends JpaRepository<Contact, Long> {
}
