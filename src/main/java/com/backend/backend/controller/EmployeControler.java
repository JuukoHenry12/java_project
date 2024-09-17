package com.backend.backend.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.entity.Employee;
import com.backend.backend.service.EmployeService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeControler {
    
    private final EmployeService employeService;

    @PostMapping("/addemployee")
    public Employee postEmployee(@RequestBody Employee employee){
        return employeService.postEmpoyee(employee);
    }

    @PutMapping("/updatemployee/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeService.updatEmployee(id,employee);
    }
    
    @DeleteMapping("/delet/{id}")
    public String deletEmployee(@PathVariable Long id,@RequestBody Employee employee){
        return employeService.deleteEmployee(id, employee);
    }

    @GetMapping("/getemployee")
    public List<Employee> getEmployees(){
        return employeService.getEmployee();
    }
}
