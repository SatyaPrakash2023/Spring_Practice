package com.jdbc.SpringFirstJDBCEx.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jdbc.SpringFirstJDBCEx.Model.Student;
import com.jdbc.SpringFirstJDBCEx.repo.StudentRepo;

@Component
public class StudentService {
	
	private StudentRepo studentrepo;
	
	public StudentRepo getStudentrepo() {
		return studentrepo;
	}


	@Autowired
	public void setStudentrepo(StudentRepo studentrepo) {
		this.studentrepo = studentrepo;
	}



	public void addStudent(Student st) {
		// TODO Auto-generated method stub
		System.out.println("Student added");
		studentrepo.Save(st);
		
	}


	public List<Student> GetStudent() {
		// TODO Auto-generated method stub
		return studentrepo.findAll();
	}


	public Student SearchStudent(int rollnumber) {
		// TODO Auto-generated method stub
		return studentrepo.getStudent(rollnumber);
	}


	public void UpdateStudent(int rollnumber,Student st) {
		// TODO Auto-generated method stub
		studentrepo.UpdateStudent(rollnumber,st);
		System.out.println("Student updated sucessfully...");
	}

}
