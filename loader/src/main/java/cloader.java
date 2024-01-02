import java.io.DataInputStream;
import java.util.Hashtable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class cloader extends ClassLoader {
	private Hashtable cache = new Hashtable();
	ZipFile jar;
	Class link;

	public synchronized Class loadClass(String name, boolean resolve) {
		Class instance = (Class) cache.get(name);
		if (instance != null) {
			return instance;
		}

		Class found;
		try {
			instance = super.findSystemClass(name);
			found = instance;
		} catch (ClassNotFoundException _ex1) {
			if (name.indexOf("signlink") != -1) {
				return this.link;
			}

			try {
				ZipEntry entry = (this).jar.getEntry(name.replace('.', '/') + ".class");
				int size = (int) entry.getSize();

				DataInputStream stream = new DataInputStream(this.jar.getInputStream(entry));
				byte[] is = new byte[size];
				stream.readFully(is);
				stream.close();

				instance = defineClass(is, 0, is.length);
				if (resolve) {
					resolveClass(instance);
				}

				cache.put(name, instance);
			} catch (Exception _ex2) {
				/* empty */
			}

			return instance;
		}

		return found;
	}
}
