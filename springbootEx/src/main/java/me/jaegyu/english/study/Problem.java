package me.jaegyu.english.study;


import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 문제를 표현 한다.
 * */
@Data
//@Entity
@NoArgsConstructor
public class Problem {
	
	private String kor;
	private String engs;
}
