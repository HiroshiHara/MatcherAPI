package com.hiroshi.hara.beans;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void インスタンス化テスト() throws Exception {
		// Exercise
		User instance = new User("Hiroshi", "403", 27);
		// Verify
		assertThat(instance.getUserName(), is("Hiroshi"));
		assertThat(instance.getPassword(), is("403"));
		assertThat(instance.getAge(), is(27));
	}
	
	@Test
	public void toStringで指定した文字列表現が得られるかどうか() throws Exception {
		// SetUp
		User sut = new User("Hiroshi", "403", 27);
		// Exercise
		String actual = sut.toString();
		// Verify
		String expected = "氏名：Hiroshi" + System.getProperty("line.separator") + "年齢：" + 27;
		assertThat(actual, is(expected));
	}

}
