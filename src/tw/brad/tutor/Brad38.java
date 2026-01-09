package tw.brad.tutor;

public class Brad38 {

	public static void main(String[] args) {
        Brad381.m1();
	}

}
class Brad381{
	static void m1() {
		try {
			System.out.println(10 / 1);
		} catch (Exception e) {
			System.out.println("xx");
		} finally {
			System.out.println("F");
		}
	}
}