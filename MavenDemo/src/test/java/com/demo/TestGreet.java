package com.demo;

import org.junit.Test;

public class TestGreet {

	@Test
	public void sayHelloShouldSayHello(){
		new Greet().sayHello("Puneet");
	}
}
