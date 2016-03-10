package springboot.book.ex;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("SELECT x From Customer x ORDER BY x.firstName, x.lastName")
	List<Customer> findAllOrderByName();

	@Query("SELECT x From Customer x ORDER BY x.firstName, x.lastName")
	Page<Customer> findAllOrderByNameWithPaging(Pageable pageable);
}
