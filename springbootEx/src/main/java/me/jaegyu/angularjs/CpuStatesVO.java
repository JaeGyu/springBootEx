package me.jaegyu.angularjs;

import lombok.Data;

@Data
public class CpuStatesVO {

	private Float user;
	private Float nice;
	private Float stayem;
	private Float idle;
	private Float iowait;

	@Override
	public String toString() {
		return "CpuStatesVO [user=" + user + ", nice=" + nice + ", stayem=" + stayem + ", idle=" + idle + ", iowait="
				+ iowait + "]\n";
	}

}
