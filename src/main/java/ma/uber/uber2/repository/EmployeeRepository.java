package ma.uber.uber2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.uber.uber2.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> { 

}
