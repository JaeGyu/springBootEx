package me.jaegyu.angularjs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "angularjs/index";
	}
	
	@RequestMapping(value="/random/json",method = RequestMethod.GET)
	public String randomJson(){
		return "angularjs/agGridRandomJson";
	}

}
