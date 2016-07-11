package me.jaegyu.angularjs;

import java.util.List;

import lombok.Getter;

public class RandomInfo {

	@Getter
	private String groupName;

	@Getter
	private List<ScoreInfo> scoreInfos;

	public RandomInfo(String groupName, List<ScoreInfo> scoreInfos) {
		this.groupName = groupName;
		this.scoreInfos = scoreInfos;
	}
}
