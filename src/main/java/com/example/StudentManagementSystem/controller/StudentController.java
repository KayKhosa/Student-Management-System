package com.example.StudentManagementSystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.StudentManagementSystem.model.Student;
import com.example.StudentManagementSystem.services.StudentService;

@Controller
public class StudentController {
	
	private final StudentService studentService;
     
	@Autowired
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	
 // Handler Method to handle list students and return mode and view
       @GetMapping("/students")
       public String studentsList(Model model) {
	      
    	   model.addAttribute("students", studentService.getAllStudents());
    	   
	      return "students";
	  
        }
       
       @GetMapping("/students/new")
       public String createStudents(Model model) {
    	   
    	   //Create a student Object to Hold new students
    	   Student student = new Student();
    	   
    	   model.addAttribute("student",student);
    	   
    	   return "create_students";
       }
       
       @PostMapping("/students")
       public String saveStudents(@ModelAttribute("student") Student student) {
    	   
    	   studentService.saveStudents(student);
    	   
    	   return "redirect:/students";
       }
	
       @GetMapping("/students/edit/{id}")
       public String editStudents(@PathVariable Long id, Model model) {
    	   
    	   model.addAttribute("student", studentService.getStudentById(id));
    	   
    	   return "edit_student";
       }
       
       // Handler Method to handle the update
       
       @PostMapping("/students/{id}")
       public String updateStudents(@PathVariable Long id, @ModelAttribute("student")
       Student student, Model model) {
    	   
    	 // get Students from database by Id
    	   
    	   Student existingStudent = studentService.getStudentById(id);
    	   existingStudent.setId(id);
    	   existingStudent.setFirstName(student.getFirstName());
    	   existingStudent.setLastName(student.getLastName());
    	   existingStudent.setEmail(student.getEmail());
    	   
    	   // Save updated students
    	   studentService.saveStudents(existingStudent);
    	   
    	   return "redirect:/students";
       }
       
       // Handler method to delete student
       @GetMapping("/students/{id}")
       public String deleteStudents(@PathVariable Long id) {
    	   
    	   studentService.deleteStudentById(id);
    	   
    	   return "redirect:/students";
       }
       
       
       
       
       
       

}
