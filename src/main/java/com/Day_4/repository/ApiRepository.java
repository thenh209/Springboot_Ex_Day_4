package com.Day_4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Day_4.model.Student;

@Repository
public interface ApiRepository extends JpaRepository<Student, Integer>{
}
