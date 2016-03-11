package springboot.book.ex;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> findAll() {
		return customerRepository.findAllOrderByName();
	}

	public Customer findOne(Integer id) {
		return customerRepository.findOne(id);
	}

	public Customer create(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer update(Customer customer) {
		return customerRepository.save(customer);
	}

	public void delete(Integer id) {
		customerRepository.delete(id);
	}

}
