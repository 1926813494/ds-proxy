package com.yaoxun.ds.service.test;

import java.util.Random;

import org.junit.Test;

public class TestDataSource {
	
	private static Random random = new Random();
	
	@Test
	public void testRand() {
		for(int i=0;i<=20;i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int nextInt = random.nextInt(2);
					System.out.println(nextInt);
					
				}
			}).start();
		}
	}
	
}
