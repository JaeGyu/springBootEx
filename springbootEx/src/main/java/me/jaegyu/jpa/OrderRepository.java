package me.jaegyu.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	/*
	 * findBy뒤에 나오는 OrderName때문에
	 * Order 객체안에
	 * orderName 프로퍼티가 있어야 하고
	 * 두번째 파라매터로 User타입의 객체를 넣어주기 위해선
	 * 아래와 같이 메서드 명에 AndUser이라고 명시 해 주어야 한다.
	 * */
	Order findByOrderNameAndUser(String orderName, User user);
	
	Order findByPriceAndUser(Integer price, User user);
}
