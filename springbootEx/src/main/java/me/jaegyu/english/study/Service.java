package me.jaegyu.english.study;

import org.springframework.beans.factory.annotation.Autowired;

public class Service {

	@Autowired
	private ProblemRepository repository;

	public Object getProblem() {
		return repository.getOneProblem();
	}

}
