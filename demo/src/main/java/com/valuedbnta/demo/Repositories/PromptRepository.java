package com.valuedbnta.demo.Repositories;

import com.valuedbnta.demo.Models.SentPrompt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromptRepository extends JpaRepository<SentPrompt, Long> {

    List<SentPrompt> findByEmployeeId(Long employeeId);

}

