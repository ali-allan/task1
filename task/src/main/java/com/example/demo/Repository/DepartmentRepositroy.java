package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.*;

public interface DepartmentRepositroy extends JpaRepository<Department, Long> {

}
