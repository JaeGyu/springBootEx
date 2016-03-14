package springboot.book.ex;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	/*
	 * @RequestMapping으로 매핑된 메서드보다 먼저 실행 된다.
	 * */
	@ModelAttribute
	CustomerForm setUpForm() {
		return new CustomerForm();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers", customers);
		return "customers/list";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@Validated CustomerForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return list(model);
		}

		Customer customer = new Customer();
		
		/*
		 * CustomerForm을 Customer에 복사함
		 * 필드 이름과 타입이 같을 때만 BeanUtils.copyProperties사용 가능함
		 * 더 유연한 Bean 변환을 구현하려면  Dozer이나 ModelMapper을 이용
		 * */
		BeanUtils.copyProperties(form, customer);
		customerService.create(customer);

		return "redirect:/customers";
	}
	
}