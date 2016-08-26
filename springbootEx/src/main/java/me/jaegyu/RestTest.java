package me.jaegyu;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTest {

	@RequestMapping(value = "/post/test", method = RequestMethod.POST)
	public Object test(@RequestParam("uid") String uid) {
		System.out.println("uid : " + uid);

		return "ok";
	}
}
