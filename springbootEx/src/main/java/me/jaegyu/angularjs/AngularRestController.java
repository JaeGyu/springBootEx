package me.jaegyu.angularjs;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AngularRestController {

	@RequestMapping(value="/cpu/states", method=RequestMethod.GET)
	public String getCpuStates(){
		return "";
	}
}
