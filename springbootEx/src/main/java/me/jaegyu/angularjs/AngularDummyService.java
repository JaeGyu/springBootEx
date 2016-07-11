package me.jaegyu.angularjs;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
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
	
	
	public List<RandomInfo> getRandomInfos(){
		
		ScoreInfo s1 = new ScoreInfo();
		s1.setName("alice");
		s1.setScore(10);
		
		ScoreInfo s2 = new ScoreInfo();
		s2.setName("bob");
		s2.setScore(34);
		
		ScoreInfo[] sArr = { s1, s2 };
		
		Random random = new Random();
		int randomNum = random.nextInt(2)+1;
		
		return null;
	}

}
