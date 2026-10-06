package com.example.employeemanagemement;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository repo;

    public EmployeeService (EmployeeRepository repo) {
       this.repo = repo;
    }

//    write methds and logic

//    Create
    public String addEmployee(Employee e){
        repo.save(e);
        return "Employee added successfully";
    }
//    Read
    public List<Employee> findAll(){
        return repo.findAll();
    }
//    Update
    public String updateEmployee(int id, Employee newEmployee){
        Employee e = repo.findById(id).orElse(null);

        if (e != null){
            e.setName(newEmployee.getName());
            e.setSalary(newEmployee.getSalary());
            e.setDepartment(newEmployee.getDepartment());
            repo.save(e);
            return "Employee updated successfully";
        }
        return "Employee not found";

    }
//    Delete
    public String deleteEmployee(int id){
        repo.deleteById(id);
        return "Employee deleted successfully";

    }

}
