package com.example.demo.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepo er;
	public List<Employee> getAll() {
		List<Employee> lst = new ArrayList<Employee> ();
		er.findAll().forEach(emp -> lst.add(emp));
		return lst;
	}
	public Employee getPersonById(int id) {
        return er.findById(id).get();
    }

    public void saveOrUpdate(Employee e) {
        er.save(e);
    }

    public void delete(int id) {
        er.deleteById(id);
    }

}
