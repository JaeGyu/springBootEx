package me.jaegyu.angularjs;

import lombok.Data;

@Data
public class CpuStatesVO {

	private Float user;
	private Float nice;
	private Float system;
	private Float idle;
	private Float iowait;

	@Override
	public String toString() {
		return "CpuStatesVO [user=" + user + ", nice=" + nice + ", system=" + system + ", idle=" + idle + ", iowait="
				+ iowait + "]\n";
	}

}
