package com.hiroshi.hara.beans;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author HiroshiHara
 * @version 1.0
 */

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
	
	/*
	 * 以下はMatcher APIの基本機能を記したメモ
	 */
	@Test
	public void testGetUserName() throws Exception {
		// SetUp
		User sut = new User("Hiroshi", "403", 27);
		// Exercise
		String actual = sut.getUserName();
		// Verify
		
		// isメソッド
		assertThat(actual, is("Hiroshi"));
		// notメソッド
		assertThat(actual, is(not("Bob")));
		// notNullValueメソッド
		assertThat(actual, is(notNullValue()));
		// sameInstanceメソッド(オブジェクトの同一性の比較(=＝))
		assertThat(actual, is(not(sameInstance(new String("Hiroshi")))));
		// instanceOfメソッド(実測値が期待するクラスと互換性を持つ方であるかどうかを比較する)
		assertThat(actual, is(instanceOf(String.class)));
		
	}
	
	@Ignore
	public void testSetUserName() throws Exception {
		
	}
	
	@Ignore
	public void testGetPassword() throws Exception {
		
	}
	
	@Ignore
	public void testSetPassword() throws Exception {
		
	}
	
	@Ignore
	public void testGetAge() throws Exception {
		
	}
	
	@Ignore
	public void testSetAge() throws Exception {
		
	}

}
