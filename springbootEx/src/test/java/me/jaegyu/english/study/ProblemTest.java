package me.jaegyu.english.study;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class ProblemTest {
	
	@Autowired
	private ProblemRepository repository;
	
	@Before
	public void setUp() throws Exception{
		String kor = "나는 일한다.";
		String eng = "I work";
		Problem p = new Problem(kor, eng);
		
		repository.save(p);
	}
	
	@Test
	public void test_하나의_문제를_가져온다() throws Exception {
		System.out.println(repository.findAll());
	}
	
}
