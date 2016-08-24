package code;

public class CodePoint{
	public static void main(String[] args){
		String str = "123456";
		String str2 = "代码单元与代码点";
		System.out.println("str1.length :"+str.length());
		System.out.println("str2 codeUnit num :"+str2.length());
		System.out.println("str2 codePoint num :"+str2.codePointCount(0,str2.length()));

	}


}
