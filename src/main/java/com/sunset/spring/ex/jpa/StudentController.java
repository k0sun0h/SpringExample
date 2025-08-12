package com.sunset.spring.ex.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunset.spring.ex.jpa.domain.Student;
import com.sunset.spring.ex.jpa.repository.StudentRepository;
import com.sunset.spring.ex.jpa.service.StudentService;

@RequestMapping("/jpa/student")
@Controller
public class StudentController {
	
	@GetMapping("/test")
	@ResponseBody
	public Student lombokTest() {
		
//		Student student = new Student(5, "김인규", "010-1234-5678", "lecture@hagulu.com", "개발자", null, null);
//		student.setName("김인규");
//		student.setDreamJob("개발자");
//		student.setPhoneNumber("010-1234-5678");
//		student.setEmail("lecture@hagulu.com");
		
		// builder 패턴 
		Student student = Student.builder()
								.name("김인규")
								.dreamJob("개발자")
								.phoneNumber("010-1234-5678")
								.email("lecture@hagulu.com")
								.build();
		
		return student;
	}
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/create")
	@ResponseBody
	public Student createStudent() {
		// 김인규, 010-1234-5678, lecture@hagulu.com, 개발자
		Student student = studentService.addStudent("김인규", "010-1234-5678", "lecture@hagulu.com", "개발자");
		
		return student;
	}
	
	@GetMapping("/update")
	@ResponseBody
	public Student updateStudent() {
		// id가 3인 학생정보의 장래희망을 강사로 변경
		Student student = studentService.updateStudent(3, "강사");
		
		return student;
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public String deleteStudent() {
		// id가 3인 학생 정보 삭제
		studentService.deleteStudent(3);
		return "삭제 성공";
	}
	
	
	// Controller에서는 Repository 객체 사용 금지
	// 편의를 위해 잠시 사용
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/select")
	@ResponseBody
	public List<Student> selectStudent() {
		
		// 모든행 조회 
//		List<Student> studentList = studentRepository.findAll();
		
//		List<Student> studentList = studentRepository.findAllByOrderByIdDesc();
		
//		List<Student> studentList = studentRepository.findTop3ByOrderByIdDesc();
		
//		List<Student> studentList = studentRepository.findByName("조세호");
		
//		List<String> nameList = new ArrayList<>();
//		nameList.add("유재석");
//		nameList.add("김인규");
//		
//		List<Student> studentList = studentRepository.findByNameIn(nameList);
		
//		List<Student> studentList = studentRepository.findByEmailContaining("gmail");
		
		List<Student> studentList = studentRepository.findByDreamJobQuery("모델");
		
		return studentList;
		
	}

}