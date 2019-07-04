package com.santg.springboot.cruddemo.dao;

import java.util.List;

import com.santg.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save (Employee employee);
	
	public void deleteById(int id);
}
