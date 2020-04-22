package com.sb.jpa.app.repository;

import org.springframework.stereotype.Repository;

import com.sb.jpa.app.model.Employee;

@Repository
public interface EmployeeDao {
	Employee customData(String ename);

}
