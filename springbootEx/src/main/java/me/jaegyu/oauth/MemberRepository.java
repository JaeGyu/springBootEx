package me.jaegyu.oauth;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface MemberRepository extends
		PagingAndSortingRepository<Member, Long> {

}
