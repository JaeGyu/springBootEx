package me.jaegyu.di.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiTestService {

	@Autowired
	Repository repository;

	public void store() {
		System.out.println(repository.store());
	}

	public void load() {
		System.out.println(repository.load());
	}
}
