package com.hiroshi.hara.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.hiroshi.hara.beans.User;

public class UserList {
	
	private static UserList singleton = new UserList();
	private static HashMap<String, User> userList;
	
	private UserList() {
		userList = new HashMap<String, User>();
	}
	
	public static UserList getInstance() {
		return singleton;
	}
	
	public static void addUser(String userId, User user) {
		if (user == null) {
			throw new IllegalArgumentException("追加するユーザ情報に誤りがあります");
		}
		if (hasUser(userId)) {
			throw new IllegalArgumentException("指定されたユーザ情報はすでに登録されています");
		}
		userList.put(userId, user);
	}
	
	public static boolean isUserIdNullorEmpty(String userId) {
		if (userId == null || userId.equals("")) {
			return true;
		}
		return false;
	}
	
	public static boolean hasUser(String userId) {
		if (isUserIdNullorEmpty(userId)) {
			throw new IllegalArgumentException("hasUserメソッドに不正な値が渡されました");
		}
		if (userList.containsKey(userId)) {
			return true;
		}
		return false;
	}
	
	public static void removeUser(String userId) {
		if (isUserIdNullorEmpty(userId)) {
			throw new IllegalArgumentException("removeUserメソッドに不正な値が渡されました");
		}
		if (hasUser(userId)) {
			userList.remove(userId);
		}
	}
	
	public static void displayUserList() {
		Set<String> keySet = userList.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String userId = it.next();
			System.out.println(userList.get(userId));
		}
	}
	
}
