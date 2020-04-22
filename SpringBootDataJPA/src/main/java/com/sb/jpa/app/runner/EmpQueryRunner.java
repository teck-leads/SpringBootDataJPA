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
//@Component
public class EmpQueryRunner implements CommandLineRunner {
	@Autowired
	private EmployeeRepository repo;

	@Override
	public void run(String... args) throws Exception {
		List<Employee> findByEname = repo.findByEname("madhav");
		findByEname.forEach(System.out::println);
		
	}

}
