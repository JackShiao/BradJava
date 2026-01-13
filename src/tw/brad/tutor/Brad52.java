package tw.brad.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Brad52 {

	public static void main(String[] args) {
		String mesg = "OK";
		byte[] data = mesg.getBytes();
		try {
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket packet = new DatagramPacket(
					                data, data.length, 
//					                InetAddress.getByName("10.0.101.231"), 8888);
			                        InetAddress.getByName("10.0.101.187"), 8888);
			socket.send(packet);
			socket.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
