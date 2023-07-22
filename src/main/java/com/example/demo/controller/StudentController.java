package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.entity.Student;
import com.example.demo.domain.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

	private final StudentService service;

	
	@GetMapping("/{id}")
	public Optional<Student> get(@PathVariable Long id) {
		return service.getStudentById(id);
	}

	@GetMapping("/all")
	public List<Student> getAll() {
		return service.getStudents();
	}

	@PostMapping
    public Student create(@RequestBody Student student) {
        return service.createStudent(student);
    }
}