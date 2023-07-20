package com.example.StudentManagementSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentManagementSystem.model.Student;
import com.example.StudentManagementSystem.repository.StudentRepository;

@Service
public class StudentService {

private final StudentRepository studentRepository;

@Autowired
public StudentService(StudentRepository studentRepository) {
	super();
	this.studentRepository = studentRepository;
}

public List<Student> getAllStudents() {
	// TODO Auto-generated method stub
	return studentRepository.findAll();
}

public Student saveStudents(Student student) {
	
	return studentRepository.save(student);
}

public Student getStudentById(Long id) {
	
	return studentRepository.findById(id).get();
}

public Student updateStudents(Student student) {
	
	return studentRepository.save(student);
}

public void deleteStudentById(Long id) {
	// TODO Auto-generated method stub
	studentRepository.deleteById(id);
}

	
}
