package com.jobhive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobhive.model.Education;
import com.jobhive.repository.EducationRepository;

@Service
public class EducationService {
    @Autowired
    private EducationRepository educationRepository;
    
    public void saveEducation(Education education) {
    	educationRepository.save(education);
    }

    public List<Education> getEducationsByUserId(Long userId) {
        return educationRepository.findByUser_UserId(userId);
    }

    
 // Add method to get Education by ID
    public Education getEducationById(Long id) {
        return educationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Education not found with id: " + id));
    }

    // Add method to delete Education by ID
    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }
}
