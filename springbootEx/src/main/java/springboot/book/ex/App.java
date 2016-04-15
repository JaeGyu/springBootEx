package springboot.book.ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@EnableAutoConfiguration
@ComponentScan
public class App implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void run(String... arg0) throws Exception {
		Customer created3 = customerRepository.save(new Customer(null, "taekyong", "seo"));
		Customer created2 = customerRepository.save(new Customer(null, "hojin", "kim"));
		Customer created  = customerRepository.save(new Customer(null, "Jaegyu", "Han"));

		// System.out.println(created + "is created!");

		customerRepository.findAll().forEach(System.out::println);

		System.out.println("order by--------------------");

		customerRepository.findAllOrderByName().forEach(System.out::println);

		System.out.println("paging   -------------------");

		Pageable pageable = new PageRequest(1, 2);
		customerRepository.findAllOrderByNameWithPaging(pageable).forEach(System.out::println);
		customerRepository.findAll(pageable).forEach(System.out::println);

	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
