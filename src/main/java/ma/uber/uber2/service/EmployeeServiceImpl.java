package ma.uber.uber2.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ma.uber.uber2.entity.Employee;
import ma.uber.uber2.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee fndById(int theId) {

		Optional<Employee> result = employeeRepository.findById(theId);
		Employee theEmployee = null;

		if (result.isPresent()) {

			theEmployee = result.get();

		} else {
			throw new RuntimeException("did not find the employee id " + theId);
		}

		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);

	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}
