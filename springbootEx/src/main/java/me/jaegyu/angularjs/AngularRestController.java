package me.jaegyu.angularjs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AngularRestController {

	@Autowired
	private AngularDummyService service;
	
	@RequestMapping(value="/cpu/states", method=RequestMethod.GET)
	public CpuStatesVO getCpuStates(){
		return service.getCpuStatesOne();
	}
}
