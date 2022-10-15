package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Studentinformation")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int StudentRoll;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, int studentRoll, String studentname, String email, String password, String mobile) {
		super();
		this.id = id;
		StudentRoll = studentRoll;
		Studentname = studentname;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", StudentRoll=" + StudentRoll + ", Studentname=" + Studentname + ", email="
				+ email + ", password=" + password + ", mobile=" + mobile + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentRoll() {
		return StudentRoll;
	}
	public void setStudentRoll(int studentRoll) {
		StudentRoll = studentRoll;
	}
	public String getStudentname() {
		return Studentname;
	}
	public void setStudentname(String studentname) {
		Studentname = studentname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	private String Studentname;
	private String email;
	private String password;
	private String mobile;

}
