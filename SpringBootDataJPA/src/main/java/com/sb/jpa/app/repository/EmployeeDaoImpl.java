package com.sb.jpa.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.sb.jpa.app.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Employee customData(String ename) {
		Employee emp = new Employee();
		try {
			Object[] params = { ename };

			jdbcTemplate.query("SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP WHERE ENAME=?", params,
					new ResultSetExtractor<Employee>() {

						@Override
						public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
							while (rs.next()) {
								emp.setEmpNo(rs.getLong("EMPNO"));
								emp.setEname(rs.getString("ENAME"));
								emp.setJob(rs.getString("JOB"));
								emp.setHireDate(rs.getDate("HIREDATE"));
							}
							return emp;
						}
					}

			);

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return emp;
	}

}
