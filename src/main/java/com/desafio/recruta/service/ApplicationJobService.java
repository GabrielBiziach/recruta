package com.desafio.recruta.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.recruta.entity.ApplicationJob;
import com.desafio.recruta.entity.Job;
import com.desafio.recruta.entity.User;
import com.desafio.recruta.enums.ApplicationJobStatus;
import com.desafio.recruta.repository.ApplicationJobRepository;
import com.desafio.recruta.repository.JobRepository;
import com.desafio.recruta.repository.UserRepository;

@Service
public class ApplicationJobService {

    @Autowired
    private ApplicationJobRepository applicationJobRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private UserRepository userRepository;

    public List<ApplicationJob> getAll(){
        return applicationJobRepository.findAll();
    }

    public Optional<ApplicationJob> findById(Long id) {
        return applicationJobRepository.findById(id);
    }

    public ApplicationJob createApplication(ApplicationJob applicationJob) {
        Job job = jobRepository.findById(applicationJob.getJob().getId()).orElseThrow();
        User user = userRepository.findById(applicationJob.getUser().getId()).orElseThrow();

        applicationJob.setJob(job);
        applicationJob.setUser(user);
        applicationJob.setApplicationDate(LocalDate.now());
        applicationJob.setStatus(ApplicationJobStatus.PENDENTE);

        return applicationJobRepository.save(applicationJob);
    }

    public ApplicationJob updateApplication(Long id, ApplicationJob applicationDetails) {
        ApplicationJob application = applicationJobRepository.findById(id).orElseThrow();
        Job job = jobRepository.findById(applicationDetails.getJob().getId()).orElseThrow();
        User user = userRepository.findById(applicationDetails.getUser().getId()).orElseThrow();

        application.setUser(user);
        application.setJob(job);
        application.setApplicationDate(applicationDetails.getApplicationDate());
        application.setStatus(applicationDetails.getStatus());
        application.setFeedback(applicationDetails.getFeedback());
        
        return applicationJobRepository.save(application);
    }

    public void deleteApplication(Long id) {
        ApplicationJob application = applicationJobRepository.findById(id).orElseThrow();
        applicationJobRepository.delete(application);
    }

}
