package lostcity;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;

public class ShaSum {
	public static void main(String[] args) {
		// todo: spit out sig.java

		try {
			String name = args[0];
			byte[] src = Files.readAllBytes(Paths.get(name));

			System.out.println("len: " + src.length);

			MessageDigest shasum = MessageDigest.getInstance("SHA");
			shasum.reset();
			shasum.update(src);

			System.out.print("SHA: ");
			String uriSha = "";
			byte[] sha = shasum.digest();
			for (int i = 0; i < 20; i++) {
				if (i < 10) {
					uriSha += sha[i];
				}

				System.out.printf("%d, ", sha[i]);
			}
			System.out.println();
			System.out.println("URI: " + uriSha);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}