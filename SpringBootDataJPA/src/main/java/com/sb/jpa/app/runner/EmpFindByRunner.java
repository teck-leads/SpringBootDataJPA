package com.sb.jpa.app.runner;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sb.jpa.app.model.Employee;
import com.sb.jpa.app.repository.EmployeeDao;
import com.sb.jpa.app.repository.EmployeeRepository;
@Component
public class EmpFindByRunner implements CommandLineRunner {
	@Autowired
	private EmployeeRepository repo;
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void run(String... args) throws Exception {
		//refer https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details
		//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
		//https://spring.io/projects/spring-data-jpa#samples
//		List<Employee> findByEname = repo.findByEname("madhav");
//		findByEname.forEach(System.out::println);
		
//		repo.findByJob("MANAGER").forEach(System.out::println);
		
		repo.findByJobLike("%AL%").forEach(System.out::println);
		
//		repo.findByJobNotLike("SA%").forEach(System.out::println);
		
//		repo.findByCommissionIsNull().forEach(System.out::println);
		
//		repo.findByCommissionIsNotNull().forEach(System.out::println);
		
//		repo.findByCommissionIsNotNullAndCommissionGreaterThan(0D).forEach(System.out::println);
		
//		repo.findByDeptnoOrderByEnameDesc(10L).forEach(System.out::println);
		
//		System.out.println(repo.findByEnameIgnoreCase("scott"));
		
//		repo.findByHireDateBefore(yesterday()).forEach(System.out::println);
		
//		repo.findByHireDateAfter(yesterday()).forEach(System.out::println);
//		repo.findByHireDateBefore(nYearsAgo(39)).forEach(System.out::println);
		
//		repo.findByEnameContaining("ej").forEach(System.out::println);
	
		
		//repo.findByHireDateBetween(customDateSet(1981,0,3), customDateSet(1987,5,3)).
//		repo.findByHireDateBetween(customDateSet(1987,4,3), new Date()).
//		stream().
//		sorted(Comparator.comparing(Employee::getHireDate)).
		
		//TODO need to work on (not working single coulumn)
//		System.out.println(repo.customeColumns("teja"));
//		Object[] customeColumns = (Object[])repo.customeColumns("teja");
//		System.out.println(customeColumns[0]);
//		for (int i = 0; i < customeColumns.length; i++) {
//			System.out.println(customeColumns[i]);
//		}
		
		
//		repo.salary(1000D).
//		stream().
//		sorted(Comparator.comparing(Employee::getSalary)).
//		forEach(System.out::println);
		
		Employee customData = employeeDao.customData("teja");
		System.out.println("JDBC Template below");
		System.out.println(customData);
		
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
	
	private static Date customDateSet(int year,int month, int day) {
		final Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, month);//0 JAN, 1 FEB
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.DATE, day);
		return cal.getTime();
		
	}

}
