package me.jaegyu.english.study;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 문제를 표현 한다.
 * */
@Data
@Entity
@NoArgsConstructor
public class Problem {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String kor;
	
	@Column(nullable = false)
	private String engs;

	public Problem(String kor, String engs) {
		this.kor = kor;
		this.engs = engs;
	}
	
	
}
