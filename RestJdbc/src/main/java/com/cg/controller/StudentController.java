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
	
	
	@RequestMapping(value = "/student", method = RequestMethod.POST,produces = "application/json")
	public void create(@RequestBody Student student) {
		studentService.createStudent(student); 
	}
	
	 
	 
	 @RequestMapping(value = "/student", method = RequestMethod.GET, produces = "application/json")
	 public List<Student> allStudents() {
	  List<Student> student = studentService.viewAllStudent();
	   return student;
	 }
	 
	 

		
		@RequestMapping(value = "/student/{sid}", method = RequestMethod.DELETE,produces = "application/json")
		public void delete(@PathVariable int sid) {
			studentService.delete(sid);
		}
		

		@RequestMapping(value = "/student/{sid}", method = RequestMethod.PUT,produces = "application/json")
		public void update(@PathVariable int sid,@RequestBody Student student) {
			studentService.updateStudent(student);
		}
	 

}
