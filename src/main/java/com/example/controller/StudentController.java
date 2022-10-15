package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentservice;

	@GetMapping("/student")
	public ResponseEntity<List<Student>> getStudent()
	{   
		List<Student> list=studentservice.getAllStudent();
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
		
	}
	

	//add book handler
	
	@PostMapping("/addstudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student)
	{   
		Student s=null;
		try {
		 s=this.studentservice.addStudent(student);
		System.out.println(student);
		return ResponseEntity.of(Optional.of(s));
		}catch(Exception e) {
			
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	//delete handler
		@DeleteMapping("/student/{Id}")
		public ResponseEntity<Void> deleteBook(@PathVariable("Id") int Id)
		{   
			try {
			 this.studentservice.deleteStudent(Id);
			 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}catch(Exception e) {
				
		    e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
		
		//update Book handler
		
		@PutMapping("/student/{studentId}")
		public ResponseEntity<Student> updateBook(@RequestBody Student student,@PathVariable("studentId") int studentId)
		{
		try {
			this.studentservice.updateStudent(student, studentId);
			return ResponseEntity.ok().body(student);
		}catch(Exception e) 
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	
		}
}
