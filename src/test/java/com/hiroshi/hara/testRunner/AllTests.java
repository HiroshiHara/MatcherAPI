package com.hiroshi.hara.testRunner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.hiroshi.hara.beans.UserTest;
import com.hiroshi.hara.model.UserListTest;
import com.hiroshi.hara.model.UserUtilTest;

/*
 * テストスイートクラス。
 * RunWithアノテーションにSuiteクラスを指定＋
 * SuiteClassesアノテーションに実行したいテストクラスを列挙する。
 * このクラスを実行することによって、列挙したテストクラスを一括で実行できる。
 */
@RunWith(Suite.class)
@SuiteClasses({UserTest.class, UserUtilTest.class, UserListTest.class})
public class AllTests {

}
