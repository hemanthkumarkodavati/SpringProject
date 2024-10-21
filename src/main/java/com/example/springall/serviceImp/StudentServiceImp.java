package com.example.springall.serviceImp;

import com.example.springall.model.Student;
import com.example.springall.repository.StudentRepository;
import com.example.springall.service.LoggingService;
import com.example.springall.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class StudentServiceImp implements LoggingService, StudentService {

  private static final Logger logger = Logger.getLogger(StudentServiceImp.class.getName());

  @Autowired
  private StudentRepository repository;


  public Student save(Student student) {
    logOperation("Save Student: " + student.getName());
    return repository.save(student);
  }

  public List<Student> findAll() {
    List<Student> allStudents =repository.findAll();
    logOperation("Fetched all students, total count: " + allStudents.size());
    return allStudents;
  }

  public Optional<Student> findById(Long id) {
    logOperation("Fetched student with ID: " + id);
    return repository.findById(id);
  }

  public void delete(Long id) {
    logOperation("Attempting to delete student with ID: " + id);
    repository.deleteById(id);
    logOperation("Deleted student with ID: " + id);
  }

  @Override
  public void logOperation(String operation) {
    logger.info("Operation performed: " + operation);
  }
}
