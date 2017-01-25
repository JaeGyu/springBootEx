package me.jaegyu.english.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

	@RequestMapping(value = "/study", method = RequestMethod.GET)
	public String index() {
		return "study/study";
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main() {
		return "study/main";
	}
}
