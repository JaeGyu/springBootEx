package me.jaegyu.di.test;

import org.springframework.stereotype.Component;

@Component("dropbox")
public class DropboxRepository implements Repository {

	@Override
	public String store() {
		return "드롭박스 저장 입니다.";
	}

	@Override
	public String load() {
		return "드롭박스 로드 입니다.";
	}

}
