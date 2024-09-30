package com.jobhive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobhive.model.Event;
import com.jobhive.model.User;
import com.jobhive.repository.EventRepository;
import com.jobhive.repository.UserRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;
    
    @Autowired
    private UserRepository userRepository;

    public Event createEvent(Event event) {
    	 Event createdEvent = eventRepository.save(event);
         return createdEvent;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }
    
    public long getEventCount() {
        return eventRepository.countEvents();
    }
    
 // Fetch events created by a specific user
    public List<Event> getEventsByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow();
        return eventRepository.findByUser(user);
    }

    
}
