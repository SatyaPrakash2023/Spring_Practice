package com.springJpa.SpringDataJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springJpa.SpringDataJPA.Model.Student;
import com.springJpa.SpringDataJPA.Repository.StudentRepo;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringDataJpaApplication.class, args);
		StudentRepo repo=context.getBean(StudentRepo.class);
		
		Student s1=context.getBean(Student.class);
		Student s2=context.getBean(Student.class);
		Student s3=context.getBean(Student.class);
		Student s4=context.getBean(Student.class);
		
		s1.setRollNo(100);
		s1.setName("Satya");
		s1.setMarks(97);
		
		s4.setRollNo(109);
		s4.setName("Satya_");
		s4.setMarks(97.8);
//		
		
//		
//		s2.setRollNo(101);
//		s2.setName("Prakash");
//		s2.setMarks(98);
//		
//		
//		s3.setRollNo(103);
//		s3.setName("Satya Prakash");
//		s3.setMarks(96);
//		
//		repo.save(s1);
//		repo.save(s2);
//		repo.save(s3);
//		System.out.println(repo.findAll());
		
		System.out.println(repo.findById(101));
//		repo.save(s4);
		repo.delete(s4);
	}

}
