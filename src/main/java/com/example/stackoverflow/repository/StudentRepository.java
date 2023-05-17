package com.example.stackoverflow.repository;

import com.example.stackoverflow.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByEmailLike(String email);
}
