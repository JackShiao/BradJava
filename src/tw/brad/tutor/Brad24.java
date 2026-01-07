package tw.brad.tutor;

public class Brad24 {

	public static void main(String[] args) {
        Brad242 obj = new Brad242();
//        obj.m2();
	}

}

class Brad241 {
	int a = 123;
	
	{System.out.println("{}:" + a);}
	static {System.out.println("static {}");}  // 只載入一次
	
	Brad241(){System.out.println("Brad241()" + a);}
	void m1() {System.out.println("Brad241:m1()");}
	static void m2() {System.out.println("Brad241");}
}

class Brad242 extends Brad241 {
	Brad242() {System.out.println("Brad242()");}
}