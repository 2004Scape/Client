import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.security.MessageDigest;
import java.util.zip.ZipFile;

import sign.signlink;

public class loader extends Applet implements Runnable {
	private static final int swid = 789;
	private static final int shei = 532;

	private boolean maxpri = false;
	private Applet inner;

	public void init() {
		try {
			signlink.mainapp = this;
			signlink.startpriv(InetAddress.getByName(getCodeBase().getHost()));

			String vendor = System.getProperties().getProperty("java.vendor");
			if (vendor.toLowerCase().indexOf("sun") != -1 || vendor.toLowerCase().indexOf("apple") != -1) {
				signlink.sunjava = true;
			}

			new Thread(this).start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void run() {
		try {
			byte[] jar = signlink.cacheload("runescape.jar");

			if (!verify(jar)) {
				updatecache();

				jar = signlink.cacheload("runescape.jar");
				if (!verify(jar)) {
					return;
				}
			}

			String cachedir = signlink.findcachedir();
			if (cachedir == null) {
				showprogress("No writable cache directory", 0);
				return;
			}

			cloader classLoader = new cloader();
			classLoader.jar = new ZipFile(cachedir + "/" + signlink.gethash("runescape.jar"));
			classLoader.link = Class.forName("sign.signlink");

			inner = (Applet) classLoader.loadClass("client").newInstance();
			inner.init();
			inner.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void showprogress(String message, int percent) {
		Graphics g = getGraphics();

		Font bold = new Font("Helvetica", Font.BOLD, 13);
		FontMetrics boldMetrics = getFontMetrics(bold);
		Font plain = new Font("Helvetica", Font.PLAIN, 13);
		FontMetrics plainMetrics = getFontMetrics(plain);

		Color barColor = new Color(140, 17, 17);

		g.setColor(Color.black);
		g.fillRect(0, 0, loader.swid, loader.shei);

		g.setColor(barColor);
		g.drawRect(242, 248, 304, 34);

		String str = message + " - " + percent + "%";
		g.setFont(bold);
		g.setColor(Color.white);
		g.drawString(str, ((loader.swid - boldMetrics.stringWidth(str)) / 2), 270);
	}

	private void updatecache() throws Exception {
		// name + sha has a benefit of cache busting in addition to being harder to find
		byte[] src = new byte[sig.len];
		String uriSha = "";
		for (int i = 0; i < 10; i++) {
			uriSha += sig.sha[i];
		}
		InputStream stream = new URL(getCodeBase(), "runescape" + uriSha + ".jar").openStream();

		int lastPercent = 0;
		int read = 0;
		while (read < sig.len) {
			int remaining = sig.len - read;
			if (remaining > 1000) {
				remaining = 1000;
			}

			read += stream.read(src, read, remaining);

			int percent = read * 100 / sig.len;
			if (percent != lastPercent) {
				showprogress("Loading game code", percent);

				lastPercent = percent;
			}
		}

		stream.close();
		signlink.cachesave("runescape.jar", src);
	}

	private boolean verify(byte[] src) throws Exception {
		if (src == null) {
			return false;
		}

		MessageDigest shasum = MessageDigest.getInstance("SHA");
		shasum.reset();
		shasum.update(src);

		byte[] sha = shasum.digest();
		for (int i = 0; i < 20; i++) {
			if (sha[i] != sig.sha[i]) {
				return false;
			}
		}

		return true;
	}

	public void start() {
		if (inner != null) {
			inner.start();
		}
	}

	public void stop() {
		if (inner != null) {
			inner.stop();
		}
	}

	public void destroy() {
		if (inner != null) {
			inner.destroy();
		}
	}

	public void update(Graphics g) {
		if (inner != null) {
			inner.update(g);
		}
	}

	public void paint(Graphics g) {
		if (inner != null) {
			inner.paint(g);
		}
	}

	public String getmidi() {
		if (signlink.midi == null) {
			return "none";
		}

		String str = signlink.midi;
		signlink.midi = null;
		return str;
	}

	public int getmidivol() {
		return signlink.midivol;
	}

	public int getmidifade() {
		return signlink.midifade;
	}

	public String getwave() {
		if (signlink.wave == null) {
			return "none";
		}

		String str = signlink.wave;
		signlink.wave = null;
		return str;
	}

	public int getwavevol() {
		return signlink.wavevol;
	}
}
