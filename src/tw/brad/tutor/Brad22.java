package tw.brad.tutor;

public class Brad22 {

	public static void main(String[] args) {
		String s1 = "Brad";
		String s2 = "Brad";
		int a = 3, b = 3;
		System.out.println(a == b);
		System.out.println(s1 == s2);
		String s3 = new String("Brad");
		String s4 = new String("Brad");
		System.out.println(s3 == s4);
		System.out.println(s1 == s4); // 比記憶體位址
		
		System.out.println("----------");
		System.out.println(s1.equals(s4)); // 比內容
		
	}

}
