package me.jaegyu.english.study;

import org.springframework.data.jpa.repository.JpaRepository;

/*
 * db로 부터 문제들을 가져와 
 * 그중 랜덤하게 한문제를 뽑아 리턴한다.
 * */
public interface ProblemRepository extends JpaRepository<Problem, Long> {
	
}
