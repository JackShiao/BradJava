package tw.brad.tutor;

public class Brad08 {

	public static void main(String[] args) {
		int a = 10, b = 3;
        // 先判斷再運算 (Java認證考試考古題)
        if ( a++ > 10 && b-- < 3 ) {
        	System.out.printf("OK: a = %d; b = %d", a, b);
        }else {
        	System.out.printf("XX: a = %d; b = %d", a, b);
        }
	}

}
