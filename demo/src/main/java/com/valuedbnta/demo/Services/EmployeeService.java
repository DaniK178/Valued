package com.valuedbnta.demo.Services;


import com.valuedbnta.demo.Models.Chatbot;
import com.valuedbnta.demo.Models.Employee;
import com.valuedbnta.demo.Models.SentPrompt;
import com.valuedbnta.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    UserRepository userRepository;


    public Employee createEmployee(Employee employee) {
        userRepository.save(employee);
        return employee;
    }

    public Employee getEmployeeById(Long employeeId){return userRepository.findById(employeeId).orElse(null);
    }

    public void saveEmployee(Employee employee){ userRepository.save(employee);}

    public List<Employee> getEmployees(){
        return userRepository.findAll();
    }
}
