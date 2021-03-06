package com.khjtony.FizzBuzzForSwift;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzTest {
	// 1 1 2 3 5 8 13 21 34 55 89 144
	private FizzBuzz fb= new FizzBuzz();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(fb.doFizzBuzz(1),"1");
		assertEquals(fb.doFizzBuzz(3),"2");
		assertEquals(fb.doFizzBuzz(4),"Buzz");
		assertEquals(fb.doFizzBuzz(51),"20365011074");
		assertEquals(fb.doFizzBuzz(9),"34");
		assertEquals(fb.doFizzBuzz(10),"Fizz");
	}

}
