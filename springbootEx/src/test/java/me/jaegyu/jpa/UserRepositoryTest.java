package me.jaegyu.jpa;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Hibernate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppForUserOfJPA.class)
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	private User user;

	@Before
	public void setUp() throws Exception {
		user = new User("홍길동", "길동", "서울시", new Date());
		user.addOrder(new Order("주문1", "빨리요~", 100, user));
		user.addOrder(new Order("주문2", "어서요", 1000, user));

		userRepository.save(user);
		userRepository.flush();
	}

	@Test
	public void testFind() throws Exception {
		User findUser = userRepository.findOne(user.getId());
		
		System.out.println(findUser);
//		assertEquals(user.getId(), findUser.getId());
	}
}
