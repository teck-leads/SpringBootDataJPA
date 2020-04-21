package com.sb.jpa.app.runner;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sb.jpa.app.model.Employee;
import com.sb.jpa.app.repository.EmployeeRepository;
@Component
public class EmpSaveRunner implements CommandLineRunner {
	@Autowired
	private EmployeeRepository repo;

	@Override
	public void run(String... args) throws Exception {
		
		
		Employee emp=new Employee();
		
//		emp.setEmpNo(101L);
//		emp.setEname("madhav");
//		emp.setJob("MANAGER");
//		emp.setManager(7566L);
//		emp.setHireDate(new Date());
//		emp.setSalary(900.5);
//		emp.setCommission(300.5);
//		emp.setDeptno(20L);
		
		emp.setEmpNo(102L);
		emp.setEname("teja");
		emp.setJob("MANAGER");
		emp.setManager(7566L);
		emp.setHireDate(new Date());
		emp.setSalary(1000.5);
		emp.setCommission(500.5);
		emp.setDeptno(20L);
		
		Employee savedEmp = repo.save(emp);
		System.out.println(savedEmp);
	}

}
