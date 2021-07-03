package com.springboot.utils;

public class Test {
	public static void main(String[] args) {
		int x = 10, y = 0;
		
		try {
			int result = x/y;
			throw new ArithmeticException();
		} catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("finish");
	}
}
