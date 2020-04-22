package com.sb.jpa.app.runner;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sb.jpa.app.repository.EmployeeRepository;
@Component
public class EmpFindByRunner implements CommandLineRunner {
	@Autowired
	private EmployeeRepository repo;

	@Override
	public void run(String... args) throws Exception {
		//refer https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details
		//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
		//https://spring.io/projects/spring-data-jpa#samples
//		List<Employee> findByEname = repo.findByEname("madhav");
//		findByEname.forEach(System.out::println);
		
//		repo.findByJob("MANAGER").forEach(System.out::println);
		
//		repo.findByJobLike("%AL%").forEach(System.out::println);
		
//		repo.findByJobNotLike("SA%").forEach(System.out::println);
		
//		repo.findByCommissionIsNull().forEach(System.out::println);
		
//		repo.findByCommissionIsNotNull().forEach(System.out::println);
		
//		repo.findByCommissionIsNotNullAndCommissionGreaterThan(0D).forEach(System.out::println);
		
//		repo.findByDeptnoOrderByEnameDesc(10L).forEach(System.out::println);
		
//		System.out.println(repo.findByEnameIgnoreCase("scott"));
		
//		repo.findByHireDateBefore(yesterday()).forEach(System.out::println);
		
//		repo.findByHireDateAfter(yesterday()).forEach(System.out::println);
//		repo.findByHireDateBefore(nYearsAgo(39)).forEach(System.out::println);
		
		repo.findByEnameContaining("ej").forEach(System.out::println);
		
		
	}
	
	private static Date yesterday() {
	    final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -1);
	    return cal.getTime();
	}
	
	private static Date nYearsAgo(int year) {
	    final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.YEAR, -year);
	    return cal.getTime();
	}

}
