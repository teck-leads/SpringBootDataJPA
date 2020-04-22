package com.sb.jpa.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sb.jpa.app.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	List<Employee> findByEname(String ename);
	List<Employee> findByJob(String job);
	List<Employee> findByJobLike(String job);
	List<Employee> findByJobNotLike(String job);
	List<Employee> findByCommissionIsNull();
	List<Employee> findByCommissionIsNotNull();
	List<Employee> findByCommissionIsNotNullAndCommissionGreaterThan(Double comm);
	List<Employee> findByDeptnoOrderByEnameDesc(Long deptno);
	Employee findByEnameIgnoreCase(String ename);
	List<Employee> findByHireDateBefore(Date date);
	List<Employee> findByHireDateAfter(Date date);
	List<Employee> findByEnameContaining(String name);
	List<Employee> findByHireDateBetween(Date startDate, Date endDate);
	
	@Query("SELECT empNo, ename, job FROM Employee WHERE ename =?1 ")
	Object[] customeColumns(String ename);
	@Query(" FROM Employee WHERE salary > ?1 ")
	List<Employee> salary(Double salary);
	
	
	
	
	 
}
