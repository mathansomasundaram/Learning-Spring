package com.spring.jdbctemplate.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.jdbctemplate.model.Employee;

@Component("employeedao")
public class EmployeeDao {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate template;
	
	public EmployeeDao(NamedParameterJdbcTemplate template) {  
        this.template = template;  
}  
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int insertEmployeeusingPreparedStatement(final Employee e) {
		
		List<Employee> employeeList=findemployee(e);
		String query="";
		if(employeeList.isEmpty()) {

			query="insert into employee (id,name,salary,department)"
					+ "values(?,?,?,?)";
		}else {
			System.out.println("employee available");
			return 0;
		}
		
		return jdbcTemplate.update(query, new PreparedStatementSetter() {
		    public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, e.getEmpId());
				ps.setString(2,e.getEmpName());
				ps.setDouble(3, e.getEmpSalary());
				ps.setString(4, e.getEmpDepartment());
			}
		});
	}

	@SuppressWarnings("unchecked")
	public int insertEmployeeUsingNamedParameter(Employee e) {
		List<Employee> employeeList=findemployee(e);
		String query="";
		if(employeeList.isEmpty()) {

			query="insert into employee values(:id,:name,:salary,:departement";
		}else {
			System.out.println("employee available");
			return 0;
		}
		Map<String,Object> map=new HashMap<>();
		map.put("id", e.getEmpId());
		map.put("name", e.getEmpName());
		map.put("salary", e.getEmpSalary());
		map.put("department", e.getEmpSalary());
		
		return template.execute(query,map, new PreparedStatementCallback() {  
		    @Override  
		    public Object doInPreparedStatement(PreparedStatement ps)  
		            throws SQLException, DataAccessException {  
		        return ps.executeUpdate();  
		    }  
		});  
	}
	public List<Employee> findemployee(Employee e) {

		String lsquery="select name from employee where id ="+e.getEmpId();
		
		RowMapper<Employee> mapper=new RowMapper<Employee>() {
			
			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

				Employee e=new Employee();
				
				e.setEmpName(rs.getString(1));
				return e;
			}
		};
		return jdbcTemplate.query(lsquery, mapper);
		
	}
	
}
