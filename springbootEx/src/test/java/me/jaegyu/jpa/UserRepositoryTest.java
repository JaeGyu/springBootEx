package me.jaegyu.jpa;

import static org.junit.Assert.*;
import java.util.Date;

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
		// System.out.println(findUser); // 양방향으로 매핑 되어 있는 경우 ValueObject를
		// println으로 출력하면 안됨
		System.out.println(findUser.getAddress());

		assertEquals(user.getId(), findUser.getId());
	}

	@Test
	public void testUpdate() throws Exception {
		user.setAddress("update address");
		userRepository.saveAndFlush(user);

		User updateUser = userRepository.findOne(user.getId());
		assertEquals(user.getAddress(), updateUser.getAddress());
	}
	
	@Test
	public void testDelete() throws Exception{
		userRepository.delete(user);
		userRepository.flush();
		
		User deleteUser = userRepository.findOne(user.getId());
		assertNull(deleteUser);
	}
	
	@Test
	public void testContexts() throws Exception{
		assertNotNull(userRepository);
	}
	
}
