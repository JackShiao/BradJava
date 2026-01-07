package tw.brad.tutor;

import tw.brad.apis.TWId;

public class Brad23 {

	public static void main(String[] args) {
		System.out.println(TWId.isRight("B123456780"));
//		System.out.println(TWId.isRight("A111S11111"));
		
		System.out.println("---------");
		TWId id1 = new TWId();
		TWId id2 = new TWId(false);
		TWId id3 = new TWId('P');
		TWId id4 = new TWId(true, 'C');
		
		System.out.println(id1);
		System.out.println(TWId.isRight(id1.toString()));
		System.out.println(id2);
		System.out.println(TWId.isRight(id2.toString()));
		System.out.println(id3);
		System.out.println(TWId.isRight(id3.toString()));
		System.out.println(id4);
		System.out.println(TWId.isRight(id4.toString()));

		System.out.println("---------");
		TWId id5 = new TWId().createTWId("A123456789");
		System.out.println(id5.isMale());
	}
}

