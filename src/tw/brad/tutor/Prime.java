package tw.brad.tutor;

public class Prime {

	public static void main(String[] args) {
//		int max = 500; // Specify the upper limit here
//	
//	    for (int n = 2; n <= max; n++) {
//	        boolean isPrime = true;
//	        for (int i = 2; i <= Math.sqrt(n); i++) {
//	            if (n % i == 0) {
//	                isPrime = false;
//	                break;
//	            }
//	        }
//	        if (isPrime) {
//	            System.out.println(n + " is prime");
//	        }
//	    }
//	}	
	
	
        boolean isPri;
        
        for (int i = 1; i <= 20; i++) {
        	isPri = true;

        	for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPri = false;
					break;
				}
			}
        	
            if (isPri) {
            	System.out.println(i);
		    }
			
		}

    }
	
}


