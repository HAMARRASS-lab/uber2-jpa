package ma.uber.uber2.service;

import java.util.List;

import ma.uber.uber2.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	public Employee fndById(int theId);
	public void save(Employee theEmployee);
	public void  deleteById(int theId);
}
