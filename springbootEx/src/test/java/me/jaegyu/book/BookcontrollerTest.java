package me.jaegyu.book;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BookApplication.class)
@WebAppConfiguration
public class BookcontrollerTest {

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void createBook() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		
		BookDto.Create createDto = new BookDto.Create();
		createDto.setName("Thinking in java");
		createDto.setAuthor("bruku");
		createDto.setPrice(43000l);
		
		System.out.println(objectMapper.writeValueAsString(createDto));
		
		ResultActions result = mockMvc.perform(post("/books")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createDto)));
		
		result.andDo(print());
		result.andExpect(status().isCreated());
	}
	
	@Test
	public void getBooks() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

		ResultActions result = mockMvc.perform(get("/books"));

		result.andDo(print());
		result.andExpect(status().isOk());
	}

}
