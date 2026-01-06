package tw.brad.tutor;

public class Brad07 {

	public static void main(String[] args) {
		int year = 2028;
		boolean isLeap;
		
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					// 29
					isLeap = true;
				}else {
					// 28
					isLeap = false;
				}
			}else {
				// 29
				isLeap = true;
			}
		}else {
			// 28
			isLeap = false;
		}
		System.out.printf("%d年為%s年", year, isLeap?"閏":"平");
		
		
//		  自寫
//        double count = Math.random()*2100+1;
//        int year = (int)count;
//        if (year % 4 == 0) {
//        	System.out.printf("%d年為閏年", year);
//        }else if (year % 100 == 0) {
//        	System.out.printf("%d年為平年", year);
//        }else if (year % 400 == 0) {
//        	System.out.printf("%d年為閏年", year);
//        }else {
//        	System.out.printf("%d年為平年", year);
//        }
		
	}

}
