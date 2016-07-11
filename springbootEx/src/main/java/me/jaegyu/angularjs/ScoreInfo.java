package me.jaegyu.angularjs;

import lombok.Data;

@Data
public class ScoreInfo {
	private String name;
	private Integer score;

	@Override
	public String toString() {
		return "ScoreInfo [name=" + name + ", score=" + score + "]\n";
	}

}
