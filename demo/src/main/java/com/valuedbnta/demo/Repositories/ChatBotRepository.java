package com.valuedbnta.demo.Repositories;

import com.valuedbnta.demo.Models.Chatbot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatBotRepository extends JpaRepository<Chatbot, Long> {
}
