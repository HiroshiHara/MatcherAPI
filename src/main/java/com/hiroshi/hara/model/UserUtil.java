package com.hiroshi.hara.model;

import com.hiroshi.hara.beans.User;

public final class UserUtil {
	
	private UserUtil() {
		
	}

	public static void displayUserData(User user) {
		if (user == null) {
			throw new IllegalArgumentException("ユーザ情報が設定されていません");
		}
		if (user.getPassword() == null) {
			throw new IllegalStateException("パスワードが設定されていません");
		}
		System.out.println(user.toString());
	}
	
	public static void main(String[] args) {
		User user = new User("HiroshiHara", "mrbob403", 27);
		UserUtil.displayUserData(user);
	}
}
