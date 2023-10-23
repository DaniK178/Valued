package com.valuedbnta.demo.Services;


import com.valuedbnta.demo.Models.Chatbot;
import com.valuedbnta.demo.Models.Employee;
import com.valuedbnta.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    UserRepository userRepository;


    public Employee createEmployee() {
        Employee employee = new Employee();
        return userRepository.save(employee);
    }
}
