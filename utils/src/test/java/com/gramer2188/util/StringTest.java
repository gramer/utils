package com.gramer2188.util;

import org.junit.Test;

public class StringTest {

	@Test
	public void format() {
		String stringForFormat = "i'm a boy %n you are a girl!.";
		System.out.println(String.format(stringForFormat, ""));
	}

}
