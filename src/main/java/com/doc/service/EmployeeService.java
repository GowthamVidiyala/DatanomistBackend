package com.doc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doc.dao.EmployeeRepository;
import com.doc.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;
	
	public Employee saveEmployee(Employee employee)
	{
		return employeeRepo.save(employee);
	}

	public List<Employee> saveAllemployees(List<Employee> employees)
	{
		return employeeRepo.saveAll(employees);		
	}

	public List<Employee> getEmployees()
	{
		return employeeRepo.findAll();		
	}

	public Employee getEmployeessById(int id)
	{
		return employeeRepo.findById(id).orElse(null);		
	}

	
	public String delete(int id)
	{
		employeeRepo.deleteById(id);
		return "Removed "+id+" from Database";	
	}

	public void deleteAll()
	{
		employeeRepo.deleteAll();
	}

	public Employee updateEmployee(Employee employee)
	{
		Employee existingEmployee = employeeRepo.findById(employee.getId()).orElse(null);
		existingEmployee.setName(employee.getName());
		existingEmployee.setAge(employee.getAge());
		existingEmployee.setSalary(employee.getSalary());
		return employeeRepo.save(existingEmployee);
	}
	
}
