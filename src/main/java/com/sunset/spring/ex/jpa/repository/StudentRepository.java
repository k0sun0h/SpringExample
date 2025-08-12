package com.sunset.spring.ex.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sunset.spring.ex.jpa.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	// 모든행을 id 기반으로 내림차순 조회
    // ORDER BY `id` DESC;
    public List<Student> findAllByOrderByIdDesc();

    // id 기반으로 내림차순 2개만 조회
    // ORDER BY `id` DESC LIMIT 2
    public List<Student> findTop2ByOrderByIdDesc();

    // 전달 받은 이름과 일치하는 행 조회
    // WHERE `name` = #{};
    public List<Student> findByName(String name);
    
    // 전달 받은 이름들과 일치하는 행 조회
    // WHERE `name` IN (#{}, #{})
    public List<Student> findByNameIn(List<String> names);
    
    // 전달 받은 키워드가 포함된 email 컬럼을 가진 행 조회
    // WHERE `email` LIKE % '%#{}%'
    public List<Student> findByEmailContaining(String email);
    
    // 쿼리 직접 작성
    // dreamJob이 전달받은 값과 일치하는 행 조회 
    @Query(value="SELECT * FROM `new_student` WHERE `dreamJob` = :dreamJob", nativeQuery=true)
    public List<Student> findByDreamJobQuery(@Param("dreamJob") String dreamJob);
    
}