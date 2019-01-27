package com.hiroshi.hara.model;

import com.hiroshi.hara.beans.User;

/**
 * @author HiroshiHara
 * @version 1.0
 */

public final class UserUtil {
	
	private UserUtil() {
		
	}
	
	/**
	 * 引数で指定されたインスタンスがnullであるかどうかを判定します。
	 * @param user Userインスタンス
	 * @return nullであればtrue
	 */
	private static boolean isNullThisUser(User user) {
		if (user == null) {
			return true;
		}
		return false;
	}
	
	/**
	 * 引数で指定されたUserが成人(20歳以上)であるかどうかを判定します
	 * @param user Userインスタンス
	 * @return 成人済みであればtrue
	 */
	public static boolean isAdult(User user) {
		if (isNullThisUser(user)) {
			throw new IllegalArgumentException("ユーザ情報が設定されていません");
		}
		if (user.getAge() >= 20) {
			return true;
		}
		return false;
	}
	/**
	 * displayUserDataメソッド
	 * 引数で渡されたUserインスタンスの情報をコンソールに出力します。
	 * @param user Userクラスのインスタンス
	 * @exception IllegalArgumentException 引数がnullの場合
	 * @exception IllegalStateException インスタンスのpasswordフィールドがnullだった場合
	 */
	public static void displayUserData(User user) {
		if (isNullThisUser(user)) {
			throw new IllegalArgumentException("ユーザ情報が設定されていません");
		}
		if (user.getPassword() == null || user.getPassword() == "") {
			throw new IllegalStateException("パスワードが設定されていません");
		}
		System.out.println(user.toString());
	}
	
}
