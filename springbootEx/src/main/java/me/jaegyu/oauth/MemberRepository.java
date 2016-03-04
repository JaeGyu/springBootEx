package me.jaegyu.oauth;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/*
 * 아래와 같은 @RepositoryRestResource를 붙여주면
 * Member레포지토리 인터페이스의 주 도메인 클래스 명에 해당하는
 * rest API를 자동으로 생성해 준다.
 * 
 * ex) /{repository}/{id}/{property},methods=GET
 * 위의 {repository} 에는 Member에서 맨 앞의 M을 소문자 m으로 하고
 * 복수형인 끝에 s를 붙여 members가 된다.
 * 
 * 아래에 @RepositoryRestResource로 인해 생성되는 API는 oAuth인증을 통해 보호를 하려는 API이다.  
 * */
@RepositoryRestResource
public interface MemberRepository extends
		PagingAndSortingRepository<Member, Long> {
}
