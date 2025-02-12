
public class DataTypeTest05 {
	public static void main(String[] args) {
	
		long x = 100L;
		
		//小容量转换大容量需要"强制转换符"
		//加上强制转换符运行阶段可能会损失精度
		//谨慎使用，会损失严重
		
		//强转原理：
			//原始数据： 00000000 00000000 00000000 00000000 00000000 00000000 00000000 01100100
			//强转之后的数据： 00000000 00000000 00000000 01100100
			//将左边的二进制去掉【所有的数据强转都是这么完成的】
		int y = (int)x;
		System.out.println(y);
		
		//原始数据： 00000000 00000000 00000000 00000000 10000000 00000000 00000000 00000000
		//强转之后的数据： 10000000 00000000 00000000 00000000
		//10000000 00000000 00000000 00000000 目前是补码形式
		//将以上的补码转换到原码是最终结果
		long k = 2147483648L;
		int e = (int)k;
		System.out.println(e);//损失精度严重，结果是负数 【-2147483648】
		
		/*
		 50是int类型的字面值，b是byte类型的变量，大容量转换为小容量
		 以下程序没有加强制转换符号，说明：在Java语言中当一个整数型字面值没有超出byte类型
		 取值范围时，该字面值可以直接赋值给byte类型的变量		  
		 */
		byte b = 50;
		System.out.println(b);
		
		/*
		  当一个证书字面值没有超出byte，short，char的取值范围，
		  这个字面值可以直接赋值给byte，short，char类型的变量，
		  这种机制SUN允许了，目的是为了方柏霓程序员的编译
		 */
	}
}
