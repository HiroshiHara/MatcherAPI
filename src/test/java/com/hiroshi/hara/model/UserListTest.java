package com.hiroshi.hara.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Test;

import com.hiroshi.hara.beans.User;

public class UserListTest {
	
	private UserList sut;

	@Test
	public void インスタンス化テスト() throws Exception {
		// Exercise
		UserList instance = new UserList();
		// Verify
		assertThat(instance.getUserList(), is(new LinkedHashMap<String, User>()));
	}
	
	@Before
	public void setUp() throws Exception {
		sut = new UserList();
		User user1 = new User("test1", "pass", 1);
		User user2 = new User("test2", "pass", 2);
		User user3 = new User("test3", "pass", 3);
		sut.addUser("001", user1);
		sut.addUser("002", user2);
		sut.addUser("003", user3);
	}
	
	@Test
	public void addUserでuserListにインスタンスが追加できるかどうか() throws Exception {
		// Exercise
		sut.addUser("004", new User("test4", "pass", 4));
		int actual = sut.getUserList().size();
		// Verify
		assertThat(actual, is(4));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void addUserの第二引数にnullを渡したときにIllegalArgumentExceptionが送出されるかどうか() throws Exception {
		// Verify
		sut.addUser("004", null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void addUserに既に追加されているユーザIDを渡したときにIllegalArgumentExceptionが送出されるかどうか() throws Exception {
		// Verify
		sut.addUser("001", new User("test", "pass", 1));
	}
	
	@Test
	public void isUserIdNullOrEmptyにnullを渡したときにtureが得られるかどうか() throws Exception {
		// SetUp
		Method method = UserList.class.getDeclaredMethod("isUserIdNullOrEmpty", String.class);
		method.setAccessible(true);
		String str = null;
		// Exercise
		Boolean actual = (Boolean) method.invoke(sut, str);
		// Verify
		assertThat(actual, is(true));
	}
	
	@Test
	public void isUserIdNullOrEmptyに空文字を渡したときにtrueが得られるかどうか() throws Exception {
		// SetUp
		Method method = UserList.class.getDeclaredMethod("isUserIdNullOrEmpty", String.class);
		method.setAccessible(true);
		String str = "";
		// Exercise
		Boolean actual = (Boolean) method.invoke(sut, str);
		// Verify
		assertThat(actual, is(true));
	}
	
	@Test
	public void isUserIdNullOrEmptyにnullと空文字以外の文字列を渡したときにfalseを得られるかどうか() throws Exception {
		// SetUp
		Method method = UserList.class.getDeclaredMethod("isUserIdNullOrEmpty", String.class);
		method.setAccessible(true);
		String str = "test";
		// Exercise
		Boolean actual = (Boolean) method.invoke(sut, str);
		// Verify
		assertThat(actual, is(false));
	}
	
	@Test
	public void hasUserでインスタンスが登録されている場合trueが得られるかどうか() throws Exception {
		// Exercise
		boolean actual = sut.hasUser("001");
		// Verify
		assertThat(actual, is(true));
	}
	
	@Test
	public void hasUserでインスタンスが登録されていない場合falseが得られるかどうか() throws Exception {
		// Exercise
		boolean actual = sut.hasUser("004");
		// Verify
		assertThat(actual, is(false));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void hasUserにnullを渡したときにIllegalArgumentExceptionが送出されるかどうか() throws Exception {
		// Verify
		sut.hasUser(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void hasUserに空文字を渡したときにIllegalArgumentExceptionが送出されるかどうか() throws Exception {
		// Verify
		sut.hasUser("");
	}
	
	@Test
	public void removeUserでuserListからインスタンスを削除することができるかどうか() throws Exception {
		// Exercise
		sut.removeUser("001");
		int actual = sut.getUserList().size();
		// Verify
		assertThat(actual, is(2));
	}
	
	@Test
	public void removeUserで存在しないユーザIDを渡しても何も起こらないかどうか() throws Exception {
		// Exercise
		sut.removeUser("004");
		int actual = sut.getUserList().size();
		// Verify
		assertThat(actual, is(3));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void removeUserにnullを渡したときにIllegalArgumentExceptionが送出されるかどうか() throws Exception {
		// Verify
		sut.removeUser(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void removeUserで空文字を渡したときにIllegalArgumentExceptionが送出されるかどうか() throws Exception {
		// Verify
		sut.removeUser("");
	}
	
	@Test
	public void iteratorでuserListの反復子が得られるかどうか() throws Exception {
		// SetUp
		String[] array = {"001", "002", "003"};
		int i = 0;
		// Exercise
		Iterator<String> actual = sut.iterator();
		// Verify
		while (actual.hasNext()) {
			String userId = actual.next();
			assertThat(userId, is(array[i]));
			i++;
		}
	}
	
	@Test
	public void toStringでインスタンスの文字列表現を得られるかどうか() throws Exception {
		// SetUp
		final String LINE_SEPARATOR = System.getProperty("line.separator");
		String expected = "氏名：test1" + LINE_SEPARATOR
								  + "年齢：1"       + LINE_SEPARATOR
								  + "氏名：test2" + LINE_SEPARATOR
								  + "年齢：2"       + LINE_SEPARATOR
								  + "氏名：test3" + LINE_SEPARATOR
								  + "年齢：3"       + LINE_SEPARATOR;
		// Exercise
		String actual = sut.toString();
		// Verify
		assertThat(actual, is(expected));
	}
	
	@Test
	public void displayUserListで期待された内容がコンソールに出力されるかどうか() throws Exception {
		// SetUp
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		final String LINE_SEPARATOR = System.getProperty("line.separator");
		String expected = "氏名：test1" + LINE_SEPARATOR
				                  + "年齢：1"       + LINE_SEPARATOR
				                  + "氏名：test2" + LINE_SEPARATOR
				                  + "年齢：2"       + LINE_SEPARATOR
				                  + "氏名：test3" + LINE_SEPARATOR
				                  + "年齢：3"       + LINE_SEPARATOR;
		// Exercise
		sut.displayUserList();
		// Verify
		assertThat(out.toString(), is(expected));
	}
}
