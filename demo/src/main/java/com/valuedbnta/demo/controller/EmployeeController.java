package com.valuedbnta.demo.controller;

import com.valuedbnta.demo.Models.Employee;
import com.valuedbnta.demo.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

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
//                "name": "John Doe",
//                    "email": "john.doe@example.com",
//                    "password": "password123",
//                    "manager": "Manager Name"
//            }
    }


//    @PostMapping
//    public ResponseEntity<User> addNewUser(@RequestBody User user){
//        User newUser = userService.addUser(user);
//        return new ResponseEntity<>(user, HttpStatus.CREATED);
//    }

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


