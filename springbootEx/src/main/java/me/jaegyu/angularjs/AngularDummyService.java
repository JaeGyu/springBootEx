package me.jaegyu.angularjs;

import java.text.DecimalFormat;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class AngularDummyService {

	public CpuStatesVO getCpuStatesOne() {

		DecimalFormat df = new DecimalFormat("0.00");
		Random random = new Random();

		CpuStatesVO cpuStatesVO = new CpuStatesVO();
		cpuStatesVO.setUser(Float.parseFloat(df.format(random.nextFloat() * 100)));
		cpuStatesVO.setNice(Float.parseFloat(df.format(random.nextFloat() * 100)));
		cpuStatesVO.setSystem(Float.parseFloat(df.format(random.nextFloat() * 100)));
		cpuStatesVO.setIdle(Float.parseFloat(df.format(random.nextFloat() * 100)));
		cpuStatesVO.setIowait(Float.parseFloat(df.format(random.nextFloat() * 100)));

		return cpuStatesVO;
	}

}
