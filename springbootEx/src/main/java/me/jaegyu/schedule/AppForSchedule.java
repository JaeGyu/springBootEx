package me.jaegyu.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AppForSchedule {

	public static void main(String[] args) {
		SpringApplication.run(AppForSchedule.class, args);
	}
}
