package tw.brad.tutor;

import java.io.File;
import java.io.FileInputStream;

public class Brad43 {

	public static void main(String[] args) {
		File source = new File("dir1/file2.txt");
		try {
			FileInputStream fin = new FileInputStream("dir1/file2.txt");
			int len; byte[] buf = new byte[(int)source.length()];
			while ((len = fin.read(buf)) != -1) {
				System.out.print(new String(buf, 0, len));
			}
			
			System.out.println("\n-------\n");
			fin.read(buf);
			System.out.println(new String(buf));
			
			fin.close();
			System.out.println("\n-------\n讀取OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
