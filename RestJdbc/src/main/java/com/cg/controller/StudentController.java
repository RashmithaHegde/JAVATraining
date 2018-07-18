package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bean.Student;
import com.cg.service.IStudentService;

@RestController
public class StudentController {

	@Autowired
	private IStudentService studentService;

	@RequestMapping(value = "/student", method = RequestMethod.POST, produces = "application/json")
	public void create(@RequestBody Student student) {
		Student stu1 =null;
		int sid= student.getSid();
		try {
			stu1 = studentService.getStudent(sid);
	}catch (Exception e) {
		e.printStackTrace();
	}

		if(stu1!=null)
		{
			throw new StudentNotFoundException("student already exists with id - " + student.getSid());
		}
		else
		studentService.createStudent(student);
		
		
	}

	@RequestMapping(value = "/student", method = RequestMethod.GET, produces = "application/json")
	public List<Student> allStudents() {
		List<Student> student = studentService.viewAllStudent();
		return student;
	}

	@RequestMapping(value = "/student/{sid}", method = RequestMethod.GET, produces = "application/json")
	public Student get(@PathVariable int sid) {

		Student student = null;
		try {
				student = studentService.getStudent(sid);
		}catch (Exception e) {
			e.printStackTrace();
		}

		if (student == null) {
			
			throw new StudentNotFoundException("student id not found - " + sid);
		}
		return student;
	}

	@RequestMapping(value = "/student/{sid}", method = RequestMethod.DELETE, produces = "application/json")
	public void delete(@PathVariable int sid) {
		Student student = null;
		try {
			student = studentService.getStudent(sid);
		}catch (Exception e) {
			e.printStackTrace();
		}

		if (student == null) {
			
			throw new StudentNotFoundException("student id not found - " + sid);
		} else {
			studentService.delete(sid);
		}
	}

	@RequestMapping(value = "/student/{sid}", method = RequestMethod.PUT, produces = "application/json")
	public void update(@PathVariable int sid, @RequestBody Student student) {
			studentService.updateStudent(student);

	}
}
