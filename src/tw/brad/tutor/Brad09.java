package tw.brad.tutor;

public class Brad09 {

	public static void main(String[] args) {
		int i = 0;
		for ( printStart() ; i < 10; printEnd()) {
			System.out.println(i++);
		}
//		System.out.println("----");
//		System.out.println(i);
	}

	static void printStart() {
		System.out.println("Brad");
	}
	
	static void printEnd() {
		System.out.println("----");
	}
	
}
