package me.jaegyu.di.test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DiTestService {

	@Qualifier("googledrive")
	Repository repository;

	public void store() {
		System.out.println(repository.store());
	}

	public void load() {
		System.out.println(repository.load());
	}
}
