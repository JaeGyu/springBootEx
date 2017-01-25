package me.jaegyu.next.step.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GoTest {

	List<String> list = new ArrayList<String>();
	
	@Test
	public void test1() throws Exception {
		list.add("1");
		System.out.println(list);
	}
	
	@Test
	public void test2() throws Exception {
		list.add("2");
		System.out.println(list);
	}
}
