package com.valuedbnta.demo.Repositories;

import com.valuedbnta.demo.Models.Chatbot;
import com.valuedbnta.demo.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Employee, Long> {

}
