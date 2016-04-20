package me.jaegyu.sbmvcsample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@RequestMapping(value = "/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {

		model.addAttribute("name", name);

		/*
		 * greeting.html은 반드시 src/main/resources/templates/
		 * 에 위치 해야 한다.
		 */
		return "mvctest/greeting";
	}
}
