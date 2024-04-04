package com.springJpa.SpringDataJPA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springJpa.SpringDataJPA.Model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
