package me.jaegyu.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	Order findByOrderNameAndUser(String orderName, User user);

}
