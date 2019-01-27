package com.hiroshi.hara.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import com.hiroshi.hara.beans.User;

/**
 * @author HiroshiHara
 * @version 1.0
 */

public class UserUtilTest {

	/*
	 * テスト対象クラスのアクセス修飾子がprivateなので、各テストメソッドの記述には以下を参考にすること
	 * 
	 */

	private static String CLASS_NAME = "com.hiroshi.hara.model.UserUtil";
	private static Object object;

	@Before
	public void setUp() throws Exception {
		try {
			Class<?> userUtilClass = Class.forName(CLASS_NAME);
			Constructor<?> userUtilConst = userUtilClass.getDeclaredConstructor();
			userUtilConst.setAccessible(true);
			object = userUtilConst.newInstance();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/*
	 * protected, privateメソッドのテスト実施…reflectionを用いる Sample sample = new Sample();
	 * Method method = Sample.class.getDeclaredMethod("<メソッド名>", 引数の型1, 引数の型2...);
	 * method.setAccessible(true); int actual =
	 * (戻り値の型)method.invoke(<インスタンス>,引数1,引数2...);
	 */

	@Test
	public void isNullThisUserでnullを渡したときにtrueが得られるかどうか() throws Exception {
		// SetUp
		User user = null;
		UserUtil sut = (UserUtil) object;
		Method method = UserUtil.class.getDeclaredMethod("isNullThisUser", User.class);
		method.setAccessible(true);
		// Exercise
		Boolean actual = (Boolean) method.invoke(sut, user);
		// Verify
		assertThat(actual, is(true));
	}
	
	@Test
	public void isNullThisUserでインスタンスを渡したときにfalseが得られるかどうか() throws Exception {
		// SetUp
		User user = new User("test", "pass", 1);
		UserUtil sut = (UserUtil) object;
		Method method = UserUtil.class.getDeclaredMethod("isNullThisUser", User.class);
		method.setAccessible(true);
		// Exercise
		Boolean actual = (Boolean) method.invoke(sut, user);
		// Verify
		assertThat(actual, is(false));
	}
	
	@Test
	public void isAdultでageが20以上のインスタンスを渡したときtrueが得られるかどうか() throws Exception {
		// SetUp
		User sut = new User("test ", "pass", 20);
		// Exercise
		boolean actual = UserUtil.isAdult(sut);
		// Verify
		assertThat(actual, is(true));
	}
	
	@Test
	public void isAdultでageが20未満のインスタンスを渡したときfalseが得られるかどうか() throws Exception {
		// SetUp
		User sut = new User("test", "pass", 19);
		// Exercise
		boolean actual = UserUtil.isAdult(sut);
		// Verify
		assertThat(actual, is(false));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void isAdultでnullを渡したときにIllegalArgumentExceptionが送出されるかどうか() throws Exception {
		// SetUp
		User sut = null;
		// Verify
		UserUtil.isAdult(sut);
	}
	
	@Test
	public void displayUserDataで期待された内容がコンソールに出力されるかどうか() throws Exception {
		// SetUp
		User sut = new User("test", "pass", 1);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		final String LINE_SEPARATOR = System.getProperty("line.separator");
		// Exercise
		UserUtil.displayUserData(sut);
		// Verify
		assertThat(out.toString(), is("氏名：test" + LINE_SEPARATOR + "年齢：1" + LINE_SEPARATOR));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void displayUserDataにnullを渡したときにIllegalArgumentExceptionが送出されるかどうか() throws Exception {
		// SetUp
		User sut = null;
		// Verify
		UserUtil.displayUserData(sut);
	}
	
	@Test(expected = IllegalStateException.class)
	public void displayUserDataにpasswordがnullのインスタンスを渡した場合IllegalStateExceptionが送出されるかどうか() throws Exception {
		// SetUp
		User sut = new User("test", null, 1);
		// Verify
		UserUtil.displayUserData(sut);
	}
	
	@Test(expected = IllegalStateException.class)
	public void displayUserDataにpasswordが空文字のインスタンスを渡した場合IllegalStateExceptionが送出されるかどうか() throws Exception {
		// SetUp
		User sut = new User("test", "", 1);
		// Verify
		UserUtil.displayUserData(sut);
	}
}
