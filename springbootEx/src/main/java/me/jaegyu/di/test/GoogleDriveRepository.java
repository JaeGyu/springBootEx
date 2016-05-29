package me.jaegyu.di.test;

import org.springframework.stereotype.Component;

@Component
public class GoogleDriveRepository implements Repository {

	@Override
	public String store() {
		return "구글 드라이브 저장 입니다.";
	}

	@Override
	public String load() {
		return "구글 드라이브 로드 입니다.";
	}

}
