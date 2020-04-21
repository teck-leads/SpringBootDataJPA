package com.sb.jpa.app.runner;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Component;

import com.sb.jpa.app.model.Employee;
import com.sb.jpa.app.repository.EmployeeRepository;
import java.util.List;
@Component
public class EmpSelectRunner implements CommandLineRunner {
	@Autowired
	private EmployeeRepository repo;

	@Override
	public void run(String... args) throws Exception {
		Employee emp1=new Employee();
		Employee emp2=new Employee();
		setEmpValues(emp1, emp2);
		repo.saveAll(Arrays.asList(emp1,emp2));
		//1. DISPLAY AS IT IS INSERTED
		//repo.findAll().forEach(System.out::println);
		
		//2. ORDER BY ENAME
		//repo.findAll(Sort.by(Order.asc("ename"))).forEach(System.out::println);
		//repo.findAll(Sort.by(Order.desc("ename"))).forEach(System.out::println);
		
		//3. FIND BY LIST OF PRIMARY KEYS
		// where empno in (? , ? , ?)
		//repo.findAllById(List.of(102L,101L,7566L)).forEach(System.out::println);
		
		//4. SELECT ROWS BASED ON WHERE CONDITION 
//		Employee em=new Employee();
//		Long mgrId=7566L;
//		em.setJob("MANAGER");
//		em.setManager(mgrId); // where JOB=? AND MGR=?
//		Example<Employee> whereClause=Example.of(em);
//		repo.findAll(whereClause).forEach(System.out::println);
		
		//5 Select rows Page wise
		//Pageable pageRequest = PageRequest.of(0, 3);
		Pageable pageRequest =PageRequest.of(0, 10, Direction.DESC, "ename");
		repo.findAll(pageRequest).forEach(System.out::println);
		pageRequest= pageRequest.next();
		System.out.println("Net page");
		repo.findAll(pageRequest).forEach(System.out::println);
		System.out.println("First or previous");
		pageRequest=pageRequest.previousOrFirst();
		repo.findAll(pageRequest).forEach(System.out::println);
		
		
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
