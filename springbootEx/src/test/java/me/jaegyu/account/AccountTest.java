package me.jaegyu.account;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class AccountTest {

	@Test
	public void getterSetter() {
		Account account = new Account();
		account.setUsername("jaegyu");
		account.setPassword("1234");

		assertThat(account.getUsername(), is("jaegyu"));
	}
}
