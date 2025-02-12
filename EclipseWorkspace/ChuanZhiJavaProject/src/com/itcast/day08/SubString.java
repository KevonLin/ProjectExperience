package com.itcast.day08;

/*
 * 字符串的截取方法：
 * 
 * public String substring(int index)：截取从参数位置一直到字符串末尾，返回新字符串
 * public String substring(int begin,int end)：截取从begin开始，一直到end结束，中间的字符串。
 * 备注：[begin,end),包含作弊那，不包含右边。
 */

public class SubString {

	public static void main(String[] args) {
		String str1 = "HelloWorld";
		String str2 = str1.substring(5);
		System.out.println(str1);
		System.out.println(str2);

		String str3 = str1.substring(4, 7);
		System.out.println(str3);
		
		/*
		 * 字符串内容没有改变
		 * Hello的和Java的地址不同
		 * strA中保存的地址不同
		 */
		
		String strA = "Hello";
		System.out.println(strA);
		strA = "Java";
		System.out.println(strA);
	}
}
