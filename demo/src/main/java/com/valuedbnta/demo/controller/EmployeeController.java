package com.valuedbnta.demo.controller;

import com.valuedbnta.demo.Models.Employee;
import com.valuedbnta.demo.Services.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostConstruct
    public void initializeDefaultEmployees() {
        Employee employee1 = new Employee("Fatma A", "FatmaS@gmail.com", "MySecretPassword8","Brian Anderson","Software Engineer");
        Employee employee2 = new Employee("Hamza B", "HamzaBe@yahoo.co.uk", "you'llneverGuess","Chris Stone","Business Analyst");

        employeeService.saveEmployee(employee1);
        employeeService.saveEmployee(employee2);
    }

    @PostMapping("/new")
    public ResponseEntity<Employee> addNewEmployee (@RequestBody Employee employee){

        Employee newEmployee = new Employee();
        newEmployee.setName(employee.getName());
        newEmployee.setEmail(employee.getEmail());
        newEmployee.setPassword(employee.getPassword());
        newEmployee.setManager(employee.getManager());

        newEmployee =  employeeService.createEmployee(newEmployee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
//      Request Body:
//            {
//                    "name": "John Doe",
//                    "email": "john.doe@example.com",
//                    "password": "password123",
//                    "manager": "Manager Name"
//            }
    }

    @GetMapping ("/all")
    public ResponseEntity<List<Employee>> viewEmployees(){
       List employees = employeeService.getEmployees();
       if (employees.isEmpty()){
           return new ResponseEntity<>(employees,HttpStatus.NO_CONTENT);
       }
        return new ResponseEntity<>(employees,HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/{id}/password")
    public ResponseEntity<String> updatePassword(@PathVariable Long id, @RequestBody Employee employee) {
        Employee existingEmployee = employeeService.getEmployeeById(id);

        if (existingEmployee == null) {
            return ResponseEntity.notFound().build();
        }
        existingEmployee.setPassword(employee.getPassword());
        employeeService.saveEmployee(existingEmployee);

        return ResponseEntity.ok("Your password has been updated successfully");
        //      RequestBody
//            {
//                "password": "newPassword123"
//            }
    }
}


