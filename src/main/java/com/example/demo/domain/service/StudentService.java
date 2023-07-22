package com.example.demo.domain.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Student;
import com.example.demo.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

	// フィールドインジェクション
	// @Autowired
	//private StudentRepository respository;

	// コンストラクタインジェクション
	private final StudentRepository respository;

	// ID から検索
	public Optional<Student> getStudentById(Long id) {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/api", "root", "05Ryuta59mosare");
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			System.out.println("MySQLに接続できませんでした。");
		}
        System.out.println("MySQLに接続できました。");
		
		return respository.findById(id);
	}

	// 全件検索
	public List<Student> getStudents() {
		return respository.findAll();
	}

	// Student 登録
	public Student createStudent(Student student) {
		return respository.save(student);
	}
}