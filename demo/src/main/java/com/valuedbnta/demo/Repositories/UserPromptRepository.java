package com.valuedbnta.demo.Repositories;

import com.valuedbnta.demo.Models.SentPrompt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPromptRepository extends JpaRepository<SentPrompt, Integer> {


}
