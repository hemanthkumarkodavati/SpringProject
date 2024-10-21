package com.example.springall.service;

import com.example.springall.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
  public Student save(Student student);
  public List<Student> findAll();
  public Optional<Student> findById(Long id);
  public void delete(Long id);

}
