package ma.uber.uber2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.uber.uber2.entity.Employee;
import ma.uber.uber2.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
private EmployeeService employeeService;

// injection dao 
@Autowired
public EmployeeRestController(EmployeeService theEmployeeService) {

employeeService =theEmployeeService;

}

// expose "/employees" and return list of employees

@GetMapping("/employees")
public List <Employee> findAlll(){
	return employeeService.findAll();
	}
	// Get "/employees/{employeeId}" and return 	an  employee

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId){		
		Employee theEmployee = employeeService.fndById(employeeId);
		
		if (theEmployee == null) {
			throw new RuntimeException("Employer his id not foun je vais la pour tester  -" + employeeId);
		}
		return theEmployee;
		
	}
	
	// Post employees add a new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		 theEmployee.setId(0);
		 employeeService.save(theEmployee);
		 
	      return theEmployee;
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
	//add mapping for delete an exicting emplyee
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee (@PathVariable int employeeId) {
		Employee theEmployee = employeeService.fndById(employeeId);
		
		// if employee null
		if (theEmployee == null) {
			throw new RuntimeException("Employee his ggggggg   hhhhhhhhhhhhhhhhhhhh idEmpl not found "+ employeeId);
			 
		}
		employeeService.deleteById(employeeId);
		return "the employe was     deleted "+ employeeId;
		
	}
	
	
	
	
}