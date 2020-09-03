package com.example.demo.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class EmployeeController {
	@Autowired
	EmployeeService es;
	@RequestMapping("/emp")
	public List<Employee> getemp() {
		return es.getAll();
	}
	@GetMapping("/emp/{id}")
	public Employee getEmployee(int id) {
		return es.getPersonById(id);
	}
	@DeleteMapping("/emp/{id}")
    private void deletePerson(@PathVariable("id") int id) {
        es.delete(id);
    }

    @PostMapping("/emp")
    private int savePerson(@RequestBody Employee e) {
        es.saveOrUpdate(e);
        return e.getId();
    }
}
