package com.jdbc.SpringFirstJDBCEx.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jdbc.SpringFirstJDBCEx.Model.Student;

@Repository
public class StudentRepo {
	
	private JdbcTemplate jdbc;
	

	public JdbcTemplate getJdbc() {
		return jdbc;
	}
	@Autowired
	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public void Save(Student st) {
		// TODO Auto-generated method stub
		System.out.println("Repo added..");
		String sql="insert into Student(rollNo,Name,Marks) values(?,?,?)";
		int rows=jdbc.update(sql,st.getRollNo(),st.getName(),st.getMarks());
		System.out.println("Number of row effected is"+rows);
		
	}

	public List<Student> findAll() {
		String sql="select*from Student";
		RowMapper<Student> mapper=new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student obj=new Student();
				obj.setRollNo(rs.getInt("rollNo"));
				obj.setName(rs.getString("name"));
				obj.setMarks(rs.getDouble("marks"));
				return obj;
			}
		};
		return jdbc.query(sql, mapper);
		
	}
	public Student getStudent(int rollnumber) {
		// TODO Auto-generated method stub
		String sql="select*from Student where rollNo ="+ rollnumber;
		RowMapper<Student> mapper=new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student obj=new Student();
				obj.setRollNo(rs.getInt("rollNo"));
				obj.setName(rs.getString("name"));
				obj.setMarks(rs.getDouble("marks"));
				return obj;
			}
		};
		return (Student) jdbc.queryForObject(sql, mapper);
	}
	public void UpdateStudent(int rollnumber,Student st) {
		// TODO Auto-generated method stub
		String sql="select*from Student where rollNo ="+ rollnumber;
		RowMapper<Student> mapper=new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student obj=new Student();
				obj.setRollNo(rs.getInt("rollNo"));
				obj.setName(rs.getString("name"));
				obj.setMarks(rs.getDouble("marks"));
				return obj;
			}
		};
		Student student= (Student) jdbc.queryForObject(sql, mapper);
		System.out.println(student);
		String sql1="Update Student set rollNo=?,Name=?,Marks=? where rollNo="+rollnumber;
		int rows=jdbc.update(sql1,st.getRollNo(),st.getName(),st.getMarks());
		
	}

}
