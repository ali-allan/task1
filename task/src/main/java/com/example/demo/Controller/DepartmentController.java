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
import java.util.List;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Exp.ResourceNotFound;
import com.example.demo.Model.*;

import com.example.demo.Repository.DepartmentRepositroy;



@RestController
@RequestMapping("api/v1/")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepositroy departmentRepositroy;
	
	
	@GetMapping("departments")
	public List<Department> getAllDepartment(){
		
		return departmentRepositroy.findAll();
	}
	
	@GetMapping("departments/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable (value="id")long departmentID)throws ResourceNotFound{
		Department department= departmentRepositroy.findById(departmentID).orElseThrow(() -> new ResourceNotFound("Department not found for this ID "+ departmentID));
		
		return ResponseEntity.ok().body(department);
		
	}
	
	@PostMapping("departments")
	public Department createDepartment(@RequestBody Department department) {
		
		return this.departmentRepositroy.save(department);
	}
	

}
