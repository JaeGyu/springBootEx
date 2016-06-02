package me.jaegyu.jpa;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class MemberRepositoryTest {

	@Autowired
	private MemberRepository repository;

	@Test
	public void testCreate() throws Exception {
		repository.save(new Member(null, "홍길동", 33));
		repository.save(new Member(null, "김길동", 34));
		repository.save(new Member(null, "이길동", 35));
		repository.save(new Member(null, "박길동", 36));
		
		List<Member> mems = repository.findAll();
		System.out.println(mems);
		
//		Member one = repository.getOne(1);
//		one.setAge(100);
		
		repository.findAll().forEach(System.out::println);
	}
}
