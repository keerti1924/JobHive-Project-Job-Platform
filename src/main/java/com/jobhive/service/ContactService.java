package com.jobhive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobhive.model.Contact;
import com.jobhive.repository.ContactMessageRepository;

@Service
public class ContactService {
	@Autowired
    private ContactMessageRepository contactMessageRepository;

    public void saveContactMessage(Contact contactMessage) {
        contactMessageRepository.save(contactMessage);
    }
}
