package me.jaegyu.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner{
	
	@Autowired
	private MemberRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("JPA를 위한 APP입니다.");
		
		Member m1 = repository.save(new Member(null,"홍길동",36));
		Member m2 = repository.save(new Member(null,"김길동",22));
		System.out.println(m1);
		
		List<Member> findAll = repository.findAll();
		System.out.println(findAll);
		
	}
}
