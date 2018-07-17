package com.cg.service;

import java.util.List;

import com.cg.bean.Student;

public interface IStudentService {

	public int createStudent(Student student);

	public List<Student> viewAllStudent();

	public int delete(int sid);

	 public int updateStudent(Student student);
	 
	 public Student getStudent(int sid);
}
