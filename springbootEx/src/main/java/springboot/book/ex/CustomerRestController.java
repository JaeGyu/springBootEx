package springboot.book.ex;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/customers")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	/*
	 * @PageableDefault에 의해서 page정보가 안넘어오면
	 * 디폴트로 page=0, size=20을 지정 한다.
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public List<Customer> getCustomers(@PageableDefault Pageable pageable) {
		return customerService.findAll(pageable).getContent();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Customer getCustomer(@PathVariable Integer id) {
		return customerService.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
//	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> postCustomers(@RequestBody Customer customer, UriComponentsBuilder uriBuilder) {
		Customer created = customerService.create(customer);
		
		URI location = uriBuilder.path("api/customers/{id}")
				.buildAndExpand(created.getId()).toUri();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(location);
		
		return new ResponseEntity<>(created, headers, HttpStatus.CREATED); 
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Customer putCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
		customer.setId(id);
		return customerService.update(customer);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable Integer id) {
		customerService.delete(id);
	}
}
