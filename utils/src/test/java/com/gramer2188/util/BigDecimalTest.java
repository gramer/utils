package com.gramer2188.util;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

public class BigDecimalTest {

	@Test
	public void create_»ý¼ºÀÚ() {
		BigDecimal num1 = new BigDecimal(0.451);
		assertThat(num1.scale(), is(54));
		assertThat(num1.compareTo(BigDecimal.valueOf(0.451)), is(not(0)));		
		assertThat(num1, is(not(BigDecimal.valueOf(0.451))));
	}
	
	@Test
	public void create_valueOf() {
		BigDecimal num1 = BigDecimal.valueOf(0.451);
		assertThat(num1.scale(), is(3));
	}
	
	@Test
	public void test_null_value() {
		Object a = null;
		Object b = null;
		assertTrue(a == b);
	}
	
	

}
