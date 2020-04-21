package com.sb.jpa.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EMP")
@Entity
public class Employee {
	@Id
	@Column(name = "EMPNO")
	private Long empNo;
	@Column(name = "ENAME")
	private String ename;
	@Column(name = "JOB")
	private String job;
	@Column(name = "MGR")
	private Long manager;
	@Column(name = "HIREDATE")
	private Date hireDate;
	@Column(name = "SAL")
	private Double salary;
	@Column(name = "COMM")
	private Double commission;
	@Column(name = "DEPTNO")
	private Long deptno;

}


