package me.jaegyu.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import me.jaegyu.Application;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class AccountControllerTest {

	@Autowired
	WebApplicationContext wac;

	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	public void createAccount() throws JsonProcessingException, Exception{
		MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(wac)
				.build();
		
		AccountDto.Create createDto = new AccountDto.Create();
		createDto.setUsername("jaegyu");
		createDto.setPassword("123456");
		
		System.out.println(objectMapper.writeValueAsString(createDto));
		
		ResultActions result = mockMvc.perform(post("/accounts")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createDto)));
		
		result.andDo(MockMvcResultHandlers.print());
		result.andExpect(MockMvcResultMatchers.status().isCreated());
	}
}
