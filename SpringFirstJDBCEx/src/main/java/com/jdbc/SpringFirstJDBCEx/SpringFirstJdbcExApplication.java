package com.jdbc.SpringFirstJDBCEx;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jdbc.SpringFirstJDBCEx.Model.Student;
import com.jdbc.SpringFirstJDBCEx.Service.StudentService;

@SpringBootApplication
public class SpringFirstJdbcExApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringFirstJdbcExApplication.class, args);
		Student st=context.getBean(Student.class);
//		st.setRollNo(111);
//		st.setName("Subhra");
//		st.setMarks(89);
		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter your Roll No");
//		st.setRollNo(sc.nextInt());
//		System.out.println("Enter your mark");
//		st.setMarks(sc.nextDouble());
//		System.out.println("Enter your Name");
//		st.setName(sc.next());
		
		StudentService service=context.getBean(StudentService.class);
		
		//service.addStudent(st);
		
		//List<Student> studentList=service.GetStudent();
		//System.out.println(studentList);
		System.out.println("Enter roll number");
		int rollnumber=sc.nextInt();
		Student student=service.SearchStudent(rollnumber);
		System.out.println(student);
		System.out.println("Enter your Roll No");
		st.setRollNo(sc.nextInt());
		System.out.println("Enter your mark");
		st.setMarks(sc.nextDouble());
		System.out.println("Enter your Name");
		st.setName(sc.next());
		service.UpdateStudent(rollnumber,st);
		
	}

}
