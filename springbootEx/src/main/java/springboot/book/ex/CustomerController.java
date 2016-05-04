package springboot.book.ex;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	/*
	 * @RequestMapping으로 매핑된 메서드보다 먼저 실행 된다.
	 * 즉 클라이언트 쪽에서 보낸 파라매터를 매핑 하기 전에 객체를 준비 한다.  
	 * 그리고 생성되어서 리턴 되는 객체는 Model 객체에 자동으로 등록 된다. 
	 * list메서드와 create메서드가 실행되기전 먼저 실행 된다. 
	 * */
	@ModelAttribute
	CustomerForm setUpForm() {
		return new CustomerForm();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		List<Customer> customers = customerService.findAll();
		
		model.addAttribute("customers", customers);

		Map<String, Object> asMap = model.asMap();

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
	
	@RequestMapping(value = "edit", params = "form", method = RequestMethod.GET)
	public String editForm(@RequestParam Integer id, CustomerForm form) {
		
		Customer customer = customerService.findOne(id);
		BeanUtils.copyProperties(customer, form);
		
		return "customers/edit";
	}
	
	@RequestMapping(value = "edit", params = "goToTop")
	public String goToTop() {
		
		return "redirect:/customers";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(@RequestParam Integer id, @Validated CustomerForm form, BindingResult result) {
		
		if (result.hasErrors()) {
			return editForm(id, form);
		}

		Customer customer = new Customer();
		BeanUtils.copyProperties(form, customer);
		customer.setId(id);
		customerService.update(customer);

		return "redirect:/customers";
	}
	
	
}
