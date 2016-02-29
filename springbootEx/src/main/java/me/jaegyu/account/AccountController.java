package me.jaegyu.account;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@Autowired
	private AccountService service;

	// @Autowired
	// private AccountRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	@RequestMapping(value = "/accounts", method = RequestMethod.POST)
	public ResponseEntity createAccount(@RequestBody @Valid AccountDto.Create create, BindingResult result) {

		if (result.hasErrors()) {
			System.out.println("400에러 발생");

			// TODO 에러 응답 본문 추가하기
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}

		Account newAccount = service.createAccount(create);

		return new ResponseEntity(modelMapper.map(newAccount, AccountDto.Response.class), HttpStatus.CREATED);
	}

	@RequestMapping("/hello")
	public String hello() {
		return "Hello Spring Boot";
	}
}
