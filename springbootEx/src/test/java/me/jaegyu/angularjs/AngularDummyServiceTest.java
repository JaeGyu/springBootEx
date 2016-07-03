package me.jaegyu.angularjs;

import static org.junit.Assert.*;

import java.text.DecimalFormat;
import java.util.Random;

import org.junit.Test;

public class AngularDummyServiceTest {

	@Test
	public void testRandomNumberCreate() throws Exception {
		Random r = new Random();
		
		DecimalFormat df = new DecimalFormat("0.00");
		
		for(int i=0;i<100;i++) System.out.println(df.format(r.nextFloat()*100));
	}
}
