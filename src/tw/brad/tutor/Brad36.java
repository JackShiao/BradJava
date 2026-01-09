package tw.brad.tutor;

public class Brad36 {
	public static void main(String[] args) {
		// Exception 例外，異常
		int a = 10, b = 1;
		int c;
		int[] d = {1,2,3,4,5};
		try {
			c = a / b;
			System.out.println(c);
			System.out.println(d[3]);
		} catch (ArithmeticException e) {
			System.out.println("數字怪怪的");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("內容長度怪怪的");			
		} catch (RuntimeException e) {
			System.out.println("執行程式時錯誤");			
		}
		System.out.println("執行完畢");		
	}
}
