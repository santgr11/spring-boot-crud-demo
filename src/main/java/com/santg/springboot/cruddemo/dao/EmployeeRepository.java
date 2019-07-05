package com.santg.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santg.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it
}
