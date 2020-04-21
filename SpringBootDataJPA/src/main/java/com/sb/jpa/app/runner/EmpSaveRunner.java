package com.sb.jpa.app.runner;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sb.jpa.app.model.Employee;
import com.sb.jpa.app.repository.EmployeeRepository;
//@Component
public class EmpSaveRunner implements CommandLineRunner {
	@Autowired
	private EmployeeRepository repo;

	@Override
	public void run(String... args) throws Exception {
		
		
		Employee emp1=new Employee();
		Employee emp2=new Employee();
		setEmpValues(emp1, emp2);
		
		//Single Save
//		Employee empSaved1 = repo.save(emp1);
//		System.out.println(empSaved1);
//		Employee empSaved2=repo.save(emp2);
//		System.out.println(empSaved2);
		//Batch save
		repo.saveAll(Arrays.asList(emp1,emp2)).forEach(System.out::println);
		
	}

	private void setEmpValues(Employee emp1, Employee emp2) {
		emp1.setEmpNo(101L);
		emp1.setEname("madhav");
		emp1.setJob("MANAGER");
		emp1.setManager(7566L);
		emp1.setHireDate(new Date());
		emp1.setSalary(900.5);
		emp1.setCommission(300.5);
		emp1.setDeptno(20L);
		emp2.setEmpNo(102L);
		emp2.setEname("teja");
		emp2.setJob("MANAGER");
		emp2.setManager(7566L);
		emp2.setHireDate(new Date());
		emp2.setSalary(1000.5);
		emp2.setCommission(500.5);
		emp2.setDeptno(20L);
	}

}
