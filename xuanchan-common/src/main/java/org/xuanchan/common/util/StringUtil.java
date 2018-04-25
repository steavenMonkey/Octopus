package org.xuanchan.common.util;


public class StringUtil {

	public static boolean isBlankOrNull(String str) {

		return (str == null || str.trim().length() <= 0);
	}


	public static boolean equals(String str1, String str2) {

		if (isBlankOrNull(str1) || isBlankOrNull(str2)) {
			return false;
		}

		return str1.equals(str2);
	}

}
