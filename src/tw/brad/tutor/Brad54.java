package tw.brad.tutor;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Brad54 {

	public static void main(String[] args) {
		// 可以寫for迴圈掃埠號，注意違法!
		try (Socket socket = new Socket(
				InetAddress.getByName("10.0.101.187"), 9999);){
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
