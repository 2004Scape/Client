package lostcity.tools;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;

public class MapviewSig {
	public static void main(String[] args) {
		String sig = "public class sig  {\n\tpublic static final int len = %d;\n\n\tpublic static final int[] sha = { %s };\n}";

		try {
			String name = args[0];
			byte[] src = Files.readAllBytes(Paths.get(name));

			System.out.println("len: " + src.length);

			MessageDigest shasum = MessageDigest.getInstance("SHA");
			shasum.reset();
			shasum.update(src);

			String shaStr = "";
			String uriSha = "";
			byte[] sha = shasum.digest();
			for (int i = 0; i < 20; i++) {
				if (i < 10) {
					uriSha += sha[i];
				}

				if (i < 19) {
					shaStr += sha[i] + ", ";
				} else {
					shaStr += sha[i];
				}
			}
			System.out.println("SHA: " + shaStr);
			System.out.println("URI: " + uriSha);

			sig = String.format(sig, src.length, shaStr);

			Files.write(Paths.get("mapview/src/main/java/sig.java"), sig.getBytes());
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(1);
		}
	}
}