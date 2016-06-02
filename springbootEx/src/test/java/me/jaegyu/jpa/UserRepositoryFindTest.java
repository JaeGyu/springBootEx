package me.jaegyu.jpa;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppForUserOfJPA.class)
public class UserRepositoryFindTest {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	private User user;

	@Before
	public void setUp() throws Exception {
		user = new User("alice", "ai", "LA", new Date());

		for (int i = 0; i < 10; i++) {
			user.addOrder(new Order("order" + i, "test" + i, 100 + i, user));
		}
		userRepository.save(user);
		userRepository.flush();
	}

	@Test
	public void testFindAnd() throws Exception {
		Order o = getOrder();
		Order order = orderRepository.findByOrderNameAndUser(o.getOrderName(), user);
		assertEquals(o.getId(), order.getId());
	}
	
	@Test
	public void testFindPaging() throws Exception {
		Pageable pageable = new PageRequest(0, 5);
		Page<Order> orders = orderRepository.findAll(pageable);
		assertEquals(5, orders.getSize());
	}
	
	@Test
	public void testFindAndPrice() throws Exception{
		Order o = getOrder();
		Order order = orderRepository.findByPriceAndUser(o.getPrice(), user);
		
		assertEquals(o.getId(), order.getId());
	}

	private Order getOrder() {
		return user.getOrders().get(0);
	}

	@Test
	public void testContexts() throws Exception {
		assertNotNull(userRepository);
		assertNotNull(orderRepository);
	}

}
