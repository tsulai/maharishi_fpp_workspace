package test;

class MyClass2 {
	public static void main(String args[]) {
		System.out.print(Example.result + " ");
		System.out.print(Example.result + " ");
		new Example();//cr
		//new Example();//cr			
		System.out.print(Example.result + "");
	}
}
class Example{
	static String result = "";
	{result += "c";}//instance block
	static {result += "u";}
	{result += "r";}//instance block	
}

