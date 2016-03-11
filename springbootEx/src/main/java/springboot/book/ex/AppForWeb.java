package springboot.book.ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class AppForWeb {
	public static void main(String[] args) {
		SpringApplication.run(AppForWeb.class, args);
	}
}
