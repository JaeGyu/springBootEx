package me.jaegyu.account;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.jaegyu.account.AccountDto.Create;

@Service
@Transactional
public class AccountService {

	@Autowired
	private AccountRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;

	public Account createAccount(Create dto) {
		/*
		 * 아래 modelMapper로 인해 더이상 필요 없음
		 * */
//		Account account = new Account();
//		account.setUsername(dto.getUsername());
//		account.setPassword(dto.getPassword());
		
		/*
		 * dto에 있는 내용을 Account.class 타입의 인스턴스로 옮겨 달라
		 * */
		Account account = modelMapper.map(dto, Account.class);
		
//		Account account = new Account();
//		BeanUtils.copyProperties(dto, account);
		
		//TODO 유효한 username인지 판단
		//TODO password 해싱
		
		Date now = new Date();
		account.setJoined(now);
		account.setUpdated(now);
		
		//리파지토리에 저장이 되고 나서 Account객체를 새로만들어서 리턴해준다. 
		return repository.save(account);
	}
}
