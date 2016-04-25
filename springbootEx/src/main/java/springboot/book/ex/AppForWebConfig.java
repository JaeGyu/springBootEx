package springboot.book.ex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
public class AppForWebConfig {

	@Order(Ordered.HIGHEST_PRECEDENCE)
	@Bean
	CharacterEncodingFilter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
//		filter.setEncoding("UTF-8");
		
		/*
		 * setForceEncoding가 true이면 강제로 UTF-8로 request,response의 encoding를 세팅한 값으로
		 * 변환 한다. 
		 * false이면 getCharacterEncoding()값이 null일 경우에만 세팅한다.
		 * */
//		filter.setForceEncoding(false);
		System.out.println("필터 적용 중 입니다.!!!");
		return filter;
	}
}
