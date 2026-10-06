package com.example.employeemanagemement;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")

public class EmployeeController {

    private final EmployeeService service;
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

//    Create
    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employee newEmployee) {
        return service.addEmployee(newEmployee);
    }
//    Read
    @GetMapping("/Employees")
    public List<Employee> getAllEmployees() {
        return service.findAll();
    }
//    Delete
    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return service.deleteEmployee(id);
    }
//    Rename
    @PutMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee newEmployee) {
        return service.updateEmployee(id ,newEmployee);
    }

}
