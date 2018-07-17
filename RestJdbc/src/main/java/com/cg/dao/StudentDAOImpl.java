package com.cg.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cg.bean.Student;

@Repository
public class StudentDAOImpl implements IStudentDAO {
	
	 private JdbcTemplate jdbcTemplate;
	 
	 @Autowired
	 public void setDataSource(DataSource dataSource)
	 {
		 this.jdbcTemplate = new JdbcTemplate(dataSource);
				 
	 }

	public int createStudent(Student student) {
		
		int add = jdbcTemplate.update("insert into student_tbl(sid,sname,marks) values(?,?,?)", 
			new Object[] {student.getSid(),student.getSname(),student.getMarks()});
		return add;
	}

	public List<Student> viewAllStudent() {
		List<Student> student=null;
		student= jdbcTemplate.query("select * from student_tbl", new BeanPropertyRowMapper<Student>(Student.class));
		return student;
	}

	@Override
	public int delete(int sid) {
		
		return jdbcTemplate.update("DELETE from student_tbl WHERE sid = ?", new Object[] { sid });
	}
	@Override
	 public int updateStudent(Student student) {
		  int count = jdbcTemplate.update(
		    "UPDATE student_tbl set sname = ? , marks = ? where sid = ?", new Object[] {
		      student.getSname(),student.getMarks(),student.getSid()});
		  return count;
		 }

	@Override
	public Student getStudent(int sid) {
		
		 Student student = jdbcTemplate.queryForObject("SELECT * FROM student_tbl WHERE sid = ?",
			     new Object[] { sid }, new BeanPropertyRowMapper<Student>(Student.class));
		return student;
	}


}
