package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.entity.Student;
import com.example.repo.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	 private StudentRepo studentrepo;
	//get All Student 
	public List<Student>getAllStudent()
	{
		List<Student> list=(List<Student>)this.studentrepo.findAll();
		return list ;
	}
	
	//add Student
	public Student addStudent(Student s)
	{
		Student result= this.studentrepo.save(s);
		return result;
	}
	
	//delete method
	
	public void deleteStudent(int sid)
	{
		
       studentrepo.deleteById(sid);	
	}
		//update the book
		
		public void updateStudent(Student student,int studentId)
		{
		  student.setId(studentId);	
	      studentrepo.save(student);
	    
		}
}		
