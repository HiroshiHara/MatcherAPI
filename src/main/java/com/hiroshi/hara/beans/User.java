package com.hiroshi.hara.beans;

/**
 * @author HiroshiHara
 * @version 1.0
 */

public class User {
	
	private String userName;
	private String password;
	private int age;
	
	public User(String userName, String password, int age) {
		this.userName = userName;
		this.password = password;
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * このインスタンスの文字列表現を返します。<br>
	 * <br>
	 * 出力例<br>
	 * 氏名：HiroshiHara<br>
	 * 年齢：27
	 * @return Userインスタンスの文字列表現
	 */
	@Override
	public String toString() {
		final String LINE_SEPARATOR = System.getProperty("line.separator");
		return "氏名：" + userName + LINE_SEPARATOR +
				   "年齢：" + age;
	}
	
}
