package me.jaegyu.oauth2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * https://login.microsoftonline.com/common/oauth2/v2.0/authorize?client_id=6731de76-14a6-49ae-97bc-6eba6914391e&response_type=code&redirect_uri=http%3A%2F%2Flocalhost%2Fmyapp%2F&response_mode=query&scope=openid%20offline_access%20https%3A%2F%2Fgraph.microsoft.com%2Fmail.read&state=12345
 * */

@RestController
public class GetAccessTokenController {

	@RequestMapping(value = "/myapp", method = RequestMethod.GET)
	public Object getAccessToken(@RequestParam("code") String code) {
		
		System.out.println("code : " + code);
		
		return null;
	}
}
