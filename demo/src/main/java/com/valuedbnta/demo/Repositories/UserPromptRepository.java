package com.valuedbnta.demo.Repositories;

import com.valuedbnta.demo.Models.SentPrompt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPromptRepository extends JpaRepository<SentPrompt, Long> {

    @Query("SELECT * FROM prompts WHERE employee = 1")
    List<SentPrompt> getAllPromptsByUserID();

    List<SentPrompt> getAllPrompts();

    //2 - things
    //list of conversation history -

    //list of all user prompts
}

