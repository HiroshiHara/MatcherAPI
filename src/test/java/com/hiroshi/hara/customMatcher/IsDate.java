package com.hiroshi.hara.customMatcher;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

/*
 * カスタムMatcherのサンプル
 * BaseMatcherクラスを継承し、計測値を型パラメータとする
 */

public class IsDate extends BaseMatcher<Date> {
	
	private final int year;
	private final int month;
	private final int date;
	
	Object actual;
	
	// ②staticなファクトリメソッドを定義する
	public static Matcher<Date> dateOf(int yyyy, int mm, int dd) {
		return new IsDate(yyyy, mm, dd);
	}
	
	// ①コンストラクタを定義する
	public IsDate(int yyyy, int mm, int dd) {
		year = yyyy;
		month = mm;
		date = dd;
	}
	
	// assertThat内で実際に比較検討を行うmatchesメソッド
	public boolean matches(Object actual) {
		this.actual = actual;
		// 実測値に対して比較検討をおこなう
		// すべて一致していた場合のみtrueを返す
		if (!(actual instanceof Date)) {
			return false;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime((Date)actual);
		if (year != cal.get(Calendar.YEAR)) {
			return false;
		}
		if (month != cal.get(Calendar.MONTH) + 1) {
			return false;
		}
		if (date != cal.get(Calendar.DATE)) {
			return false;
		}
		return true;
	}
	
	// matchesメソッドがfalseを返したときに自動的に呼ばれるdescribeToメソッド
	public void describeTo(Description description) {
		// Expected: is ~ の内容 = 期待値(デフォルトの内容を変更)
		description.appendValue(String.format("%d/%02d/%02d", year, month, date));
		// but actual is ~ の内容を追加(オリジナルの記述)
		if (actual != null) {
			description.appendText(" but actual is");
			description.appendValue(new SimpleDateFormat("yyyy/MM/dd").format((Date)actual));
		}
		
	}
	
	
}
