package com.springboot.utils;

public class Test {
	public static void main(String[] args) {
		int x = 9, y = 0;
		
		try {
			int result = x/y;
			throw new ArithmeticException();
		} catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("finish");
		
		if((x & 1) != 0) {
			System.out.println("X là số lẻ");
		}
	}
}
