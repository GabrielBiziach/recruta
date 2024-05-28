package com.desafio.recruta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.desafio.recruta.entity.ApplicationJob;

public interface ApplicationJobRepository extends JpaRepository<ApplicationJob, Long>{

}
