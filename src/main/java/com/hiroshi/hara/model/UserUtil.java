package com.hiroshi.hara.model;

import com.hiroshi.hara.beans.User;

public final class UserUtil {
	
	private UserUtil() {
		
	}

	/**
	 * displayUserDataメソッド
	 * 引数で渡されたUserインスタンスの情報をコンソールに出力します。
	 * @param user Userクラスのインスタンス
	 * @throws IllegalArgumentException 引数がnullの場合
	 * @throws IllegalStateException インスタンスのpasswordフィールドがnullだった場合
	 */
	public static void displayUserData(User user) {
		if (user == null) {
			throw new IllegalArgumentException("ユーザ情報が設定されていません");
		}
		if (user.getPassword() == null) {
			throw new IllegalStateException("パスワードが設定されていません");
		}
		System.out.println(user.toString());
	}
	
}
