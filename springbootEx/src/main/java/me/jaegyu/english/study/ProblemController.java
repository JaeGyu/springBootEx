package me.jaegyu.english.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProblemController {

	@Autowired
	private ProblemService service;

	@RequestMapping(value = "/next_problem", method = RequestMethod.GET)
	public Object nextProblem() {
		return service.getProblem();
	}
}
