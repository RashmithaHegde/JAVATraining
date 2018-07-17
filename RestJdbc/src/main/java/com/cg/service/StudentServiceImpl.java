package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bean.Student;
import com.cg.dao.IStudentDAO;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private IStudentDAO dao;

	public int createStudent(Student student) {
		
		return dao.createStudent(student);
	}

	public List<Student> viewAllStudent() {
	
		 List<Student> student = dao.viewAllStudent();
		  return student;
	}

	@Override
	public int delete(int sid) {
		// TODO Auto-generated method stub
		return dao.delete(sid);
	}

	@Override
	public int updateStudent(Student student) {
		// TODO Auto-generated method stub
		return dao.updateStudent(student);
	}

	@Override
	public Student getStudent(int sid) {
		// TODO Auto-generated method stub
		return dao.getStudent(sid);
	}

	

}
