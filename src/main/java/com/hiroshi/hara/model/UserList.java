package com.hiroshi.hara.model;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import com.hiroshi.hara.beans.User;

/**
 * @author HiroshiHara
 * @version 1.0
 */

public class UserList implements Iterable<String>{
	
	private LinkedHashMap<String, User> userList;

	public UserList() {
		userList = new LinkedHashMap<String, User>();
	}
	
	/**
	 * このクラスが持つuserListフィールドに指定されたIDをキーとしてUserインスタンスを追加します。
	 * @param userId ユーザID
	 * @param user　Userクラスのインスタンス
	 * @throws IllegalArgumentException 指定されたUserインスタンスがnullだった場合
	 * @throws IllegalArgumentException 指定されたUserインスタンスが既に追加されていた場合
	 */
	public void addUser(String userId, User user) {
		if (user == null) {
			throw new IllegalArgumentException("追加するユーザ情報に誤りがあります");
		}
		if (hasUser(userId)) {
			throw new IllegalArgumentException("指定されたユーザ情報はすでに登録されています");
		}
		userList.put(userId, user);
	}
	
	/**
	 * このメソッドはこのクラス内でのみ利用されるメソッドです。<br>
	 * 引数で指定された文字列がnullもしくは空文字であるかどうかを判定します。
	 * もしそうであるならtrueを返し、そうでないならfalseを返します。
	 * @param userId ユーザID
	 * @return 文字列がnullもしくは空文字ならtrue
	 */
	private boolean isUserIdNullorEmpty(String userId) {
		if (userId == null || userId.equals("")) {
			return true;
		}
		return false;
	}
	
	/**
	 * このクラスが持つuserListフィールドに、指定されたユーザIDでインスタンスが登録されているかどうかを判定します。
	 * もし追加されている場合、trueを返します。
	 * @param userId ユーザID
	 * @return userListにインスタンスが追加されている場合true
	 * @throws IllegalArgumentException 引数がnullもしくは空文字の場合
	 */
	public boolean hasUser(String userId) {
		if (isUserIdNullorEmpty(userId)) {
			throw new IllegalArgumentException("hasUserメソッドに不正な値が渡されました");
		}
		if (userList.containsKey(userId)) {
			return true;
		}
		return false;
	}
	
	/**
	 * このクラスが持つuserListフィールドから、指定されたユーザIDで登録されているインスタンスを削除します。
	 * 指定されたユーザIDが存在しなくとも何も起こりません。
	 * @param userId ユーザID
	 * @throws IllegalArgumentException 引数がnullもしくは空文字の場合
	 */
	public void removeUser(String userId) {
		if (isUserIdNullorEmpty(userId)) {
			throw new IllegalArgumentException("removeUserメソッドに不正な値が渡されました");
		}
		if (hasUser(userId)) {
			userList.remove(userId);
		}
	}
	
	/**
	 * このクラスが持つuserListフィールドにおけるキー値の反復子を返します。
	 * @return it String型のキー値の反復子
	 */
	public Iterator<String> iterator() {
		Set<String> keySet = userList.keySet();
		Iterator<String> it = keySet.iterator();
		return it;
	}
	
	/**
	 * このクラスが持つuserListフィールドに登録されているインスタンスの文字列表現をすべてコンソールに出力します。
	 */
	public void displayUserList() {
		Iterator<String> it = iterator();
		while (it.hasNext()) {
			String userId = it.next();
			System.out.println(userList.get(userId));
		}
	}
	
}
