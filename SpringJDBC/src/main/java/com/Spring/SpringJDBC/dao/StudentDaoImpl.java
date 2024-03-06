package com.Spring.SpringJDBC.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.Spring.SpringJDBC.entities.Student;



@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public int insert(Student student) {
		// insert query
		String query = "insert into student(id,name,city) values(?,?,?)";
		int r = this.jdbcTemplate.update(query,student.getId(),student.getName(), student.getCity());
		
		return r;
		
	}
	@Override
	public int change(Student student) {
		// Updating Data
		String query = "update student set name=?, city=? where id=?";
		int r = this.jdbcTemplate.update(query, student.getName(), student.getCity(),student.getId());
		return r;
	}
	@Override
	public int delete(int studentId) {
		// TODO Auto-generated method stub
		
		String query= "delete from student where id=?";
		int r=this.jdbcTemplate.update(query,studentId);
				
		return r;
	}
	
	@Override
	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		
		String query="select * from student where id=?";
		// for select query we always need an RowMapper which Transforms the data into Object form
		RowMapper<Student> rowMapper= new RawMapperImpl();
		Student student=this.jdbcTemplate.queryForObject(query,rowMapper, studentId);
		return student;
	}


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		
		String query="select * from student";
		List<Student> students = this.jdbcTemplate.query(query,new RawMapperImpl());
		return students;
	}






}
