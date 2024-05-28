package com.desafio.recruta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.recruta.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long>{
}
