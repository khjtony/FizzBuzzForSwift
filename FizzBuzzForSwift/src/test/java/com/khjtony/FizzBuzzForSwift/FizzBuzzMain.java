package com.khjtony.FizzBuzzForSwift;

public class FizzBuzzMain {
	public static void main(String[] args){
		FizzBuzz fb= new FizzBuzz();
		System.out.println("fb(3)="+fb.doFizzBuzz(3));
		System.out.println("fb(51)="+fb.doFizzBuzz(51));
		
		System.out.println("fb(5)="+fb.doFizzBuzz(5));
		System.out.println("fb(9)="+fb.doFizzBuzz(9));
		System.out.println("fb(11)="+fb.doFizzBuzz(11));
		System.out.println("fb(1)="+fb.doFizzBuzz(1));
	}

}
