package com.csv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csv.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>  {

}
