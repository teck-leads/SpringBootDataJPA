package com.sb.jpa.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Component;

import com.sb.jpa.app.repository.EmployeeRepository;
//@Component
public class EmpSelectRunner implements CommandLineRunner {
	@Autowired
	private EmployeeRepository repo;

	@Override
	public void run(String... args) throws Exception {
		//repo.findAll().forEach(System.out::println);
		repo.findAll(Sort.by(Order.asc("ename"))).forEach(System.out::println);
	}

}
