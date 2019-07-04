package com.santg.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.santg.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	// define field for entitymanager
	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {

		// create a query
		Query query = entityManager.createQuery("from Employee");
		
		// execute query and get result list
		List<Employee> employees = query.getResultList();
		
		// return the result
		return employees;
	}

	@Override
	public Employee findById(int id) {
	
		// get the employee
		Employee employee = entityManager.find(Employee.class, id);
		
		// return the employee
		return employee;
	}

	@Override
	public void save(Employee employee) {

		// save the employee
		Employee tempEmployee = entityManager.merge(employee);
		
		employee.setId(tempEmployee.getId());
	}

	@Override
	public void deleteById(int id) {

		// delete object with primary key
		Query query = entityManager.createQuery(
				"delete from Employee where id=:employeeId");
		
		query.setParameter("employeeId", id);
		
		query.executeUpdate();
		
	}

}
