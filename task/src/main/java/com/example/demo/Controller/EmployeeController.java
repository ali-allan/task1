package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.example.demo.Repository.DepartmentRepositroy;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Exp.ResourceNotFound;
import com.example.demo.Model.*;


@RestController
@RequestMapping("api/v1/")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepositroy departmentRepositroy;
	@GetMapping("employees")
	public List<Emloyee> getAllEmployee(){
		return employeeRepository.findAll();
		
	}
	
	@GetMapping("employees/{id}")
	public ResponseEntity<Emloyee> getEmployeeById(@PathVariable(value="id")Long employeeID) 
		throws ResourceNotFound{
			Emloyee employee = employeeRepository.findById(employeeID)
					.orElseThrow(() -> new ResourceNotFound("Employee not found for this ID "+ employeeID));
					
					return ResponseEntity.ok().body(employee);
		}
	
	
	@PostMapping("employees")
	public Emloyee createEmployee(@RequestBody Emloyee employee) {
		
		return this.employeeRepository.save(employee);
	}
	
	@PutMapping("employees/{id}")
	public ResponseEntity<Emloyee> updateEmployeeById(@PathVariable(value="id")Long employeeID,
		 @RequestBody Emloyee employeeD )
	throws ResourceNotFound{
		Emloyee employee = employeeRepository.findById(employeeID)
				.orElseThrow(() -> new ResourceNotFound("Employee not found for this ID "+ employeeID));
	employee.setActive(employeeD.isActive());
	employee.setFname(employeeD.getFname());
	employee.setLname(employeeD.getLname());
	employee.setDep_id(employeeD.getDep_id());
	
	return ResponseEntity.ok(this.employeeRepository.save(employee));
	}
	
	
	@PutMapping("employees/{id}/dep/{depid}")
	public Emloyee  addDepartmentID(@PathVariable(value="id") long employeeID,@PathVariable(value="depid") long depid){
		Department department = departmentRepositroy.findById(depid).get();
		Emloyee employee =employeeRepository.findById(employeeID).get();
		employee.getDepartment(department);
		return employeeRepository.save(employee);
		
	}
	
	
	
	
	
	
}
