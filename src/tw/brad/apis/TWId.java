package tw.brad.apis;

import java.util.Random;

public class TWId {
    private String id;
	private static final String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO";

    
    public TWId () {
    	this(new Random().nextBoolean());
    }
    public TWId (boolean isMale) {
    	this(isMale, letters.charAt(new Random().nextInt(26)));
    }
    public TWId (char area) {
    	this(new Random().nextBoolean(),area);
    }
    public TWId (boolean isMale, char area) {
    	StringBuffer sb = new StringBuffer();
    	sb.append(area);
    	sb.append(isMale?'1':'2');
    	for (int i=0; i<7; i++) sb.append(new Random().nextInt(10));
    	for (int i=0; i<10; i++) {
    		if (isRight(sb.toString() + i)) {
    			id = sb.append(i).toString();
    			break;
    		}
    	}
    }
    
    @Override
    public String toString() {
    	return id;
    }
    
    
    
    public static boolean isRight(String id) {
        boolean isRight = false;		
        
        // 自寫
//    	if(id.length() == 10) {
//    	    char c1 = id.charAt(0);
//    	    String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//    	    if (letters.indexOf(c1) != -1) {
//    	    	char c2 = id.charAt(1);
//    	    	if (c2 == '1' || c2 == '2') {
//    	    		for (int i = 2; i < 10; i++) {
//    	    			char x = id.charAt(i);
//    	    			System.out.println(x);
//    	    			if (x == '0' || x == '1' || x == '2'|| x == '3'|| x == '4' || x == '5'
//    	    					|| x == '6' || x == '7' || x == '8' || x == '9') {
//    	    				isRight = true;
//    	    			}else {
//    	    				isRight = false;
//    	    				break;
//    	    			}
//	    			}
//    			}
//			}
//    	}

    	
        
        // 正規化寫法
        if (id.matches("[A-Z][12][0-9]{8}")) {
        	char c1 = id.charAt(0);
        	int a12 = letters.indexOf(c1) + 10;
//        	System.out.println(a12);
        	int a1 = a12 / 10;
        	int a2 = a12 % 10;
        	String temp = id.substring(1, 2);
        	int n1 = Integer.parseInt(temp);
        	int n2 = Integer.parseInt(id.substring(2, 3));
        	int n3 = Integer.parseInt(id.substring(3, 4));
        	int n4 = Integer.parseInt(id.substring(4, 5));
        	int n5 = Integer.parseInt(id.substring(5, 6));
        	int n6 = Integer.parseInt(id.substring(6, 7));
        	int n7 = Integer.parseInt(id.substring(7, 8));
        	int n8 = Integer.parseInt(id.substring(8, 9));
        	int n9 = Integer.parseInt(id.substring(9, 10));
        	
        	int sum = a1*1 + a2*9 + n1*8 + n2*7 + n3*6 + n4*5 +
        			n5*4 + n6*3 + n7*2 + n8*1 + n9*1;
        	isRight = sum % 10 == 0;
        }
    
        
    	return isRight;
	}
    
}


