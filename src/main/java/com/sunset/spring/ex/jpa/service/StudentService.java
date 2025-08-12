package com.sunset.spring.ex.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunset.spring.ex.jpa.domain.Student;
import com.sunset.spring.ex.jpa.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public Student addStudent(String name, String phoneNumber, String email, String dreamJob) {
		
		Student student = Student.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.build();
		
		student = studentRepository.save(student);
		
		return student;
	}
	
	public Student updateStudent(int id, String dreamJob) {
		// update 대상을 조회
		// 조회된 객체에서 수정사항을 적용
		// 해당 객체를 저장
		
		// Optional : null 일 수도 있는 객체를 리턴할때 쓰이는 클래스
		// null을 통해서 발생될 수 있는 NullPointerException 위험을 줄이기 위한 용도
		// null일 수도 있는 객체를 return하는 메소드에서 return type으로 활용
		// (내가 리턴할 객체가 널일 수도 있으니 좀 신경써서 처리해라)
		Optional<Student> optionalStudent = studentRepository.findById(id);
		
		// orElse : Optional 객체가 값(Optional 내부 값, 즉 null이 아님)을 가지고 있으면 그 값을 반환하고, 
		// Optional이 비어있으면(isEmpty) 지정한 기본값을 반환하는 역할
		Student student = optionalStudent.orElse(null);
		
		student = student.toBuilder().dreamJob(dreamJob).build();
		
		student = studentRepository.save(student);
		
		return student;
	}
	
	public void deleteStudent(int id) {
		// 삭제 대상 행을 조회
		// 조회된 객체를 통해 삭제 
		Optional<Student> optionalStudent = studentRepository.findById(id);
		Student student = optionalStudent.orElse(null);
		
		studentRepository.delete(student);
		
	}
}