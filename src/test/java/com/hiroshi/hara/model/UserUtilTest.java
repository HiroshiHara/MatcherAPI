package com.hiroshi.hara.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

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
}
