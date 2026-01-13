package tw.brad.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Brad60 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.google.com/logos/doodles/2025/nba-playoffs-2025-am-6753651837110780.2-2xa.gif");
			URLConnection conn = url.openConnection();
			
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			byte[] data = bin.readAllBytes();
			
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("dir1/test.jpg"));
			bout.write(data);
			bout.flush();
			bout.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
