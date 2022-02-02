package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;
import com.example.demo.Model.Emloyee;

@Repository
public interface EmployeeRepository extends JpaRepository<Emloyee, Long>{
	

}
