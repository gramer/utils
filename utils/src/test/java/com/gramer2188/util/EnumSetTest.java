package com.gramer2188.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.EnumSet;

import org.junit.Test;

public class EnumSetTest {

	private static enum Fruit {
		APPLE, ORANGE, BANANA, CHERRY, MANGO
	}
	
	private void doSomething(Fruit... fruits) {
		System.out.println(fruits);
	}

	@Test
	public void whatIsEnumSet() {
		EnumSet<Fruit> fruits = EnumSet.allOf(Fruit.class);
		
		doSomething(Fruit.APPLE, Fruit.ORANGE);
		assertThat(fruits.size(), is(5));
	}

	
}
