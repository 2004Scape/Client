package jagex2.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.*;
import java.net.InetAddress;
import java.util.Objects;
import javax.sound.midi.MidiSystem;
import javax.sound.sampled.*;

@OriginalClass("client!sign/signlink")
public final class Signlink implements Runnable {

	@OriginalMember(owner = "client!sign/signlink", name = "clientversion", descriptor = "I")
	public static final int clientversion = 225;

	@OriginalMember(owner = "client!sign/signlink", name = "uid", descriptor = "I")
	public static int uid;

	@OriginalMember(owner = "client!sign/signlink", name = "sunjava", descriptor = "Z")
	public static boolean sunjava;

	@OriginalMember(owner = "client!sign/signlink", name = "active", descriptor = "Z")
	private static boolean active;

	@OriginalMember(owner = "client!sign/signlink", name = "threadliveid", descriptor = "I")
	private static int threadliveid;

	@OriginalMember(owner = "client!sign/signlink", name = "savelen", descriptor = "I")
	private static int savelen;

	@OriginalMember(owner = "client!sign/signlink", name = "midiplay", descriptor = "Z")
	private static boolean midiplay;

	@OriginalMember(owner = "client!sign/signlink", name = "midipos", descriptor = "I")
	private static int midipos;

	@OriginalMember(owner = "client!sign/signlink", name = "midivol", descriptor = "I")
	public static int midivol = 128;

	@OriginalMember(owner = "client!sign/signlink", name = "midifade", descriptor = "I")
	public static boolean midifade;

	@OriginalMember(owner = "client!sign/signlink", name = "waveplay", descriptor = "Z")
	private static boolean waveplay;

	@OriginalMember(owner = "client!sign/signlink", name = "wavepos", descriptor = "I")
	private static int wavepos;

	@OriginalMember(owner = "client!sign/signlink", name = "wavevol", descriptor = "I")
	public static int wavevol;

	@OriginalMember(owner = "client!sign/signlink", name = "dnsreq", descriptor = "Ljava/lang/String;")
	private static String dnsreq = null;

	@OriginalMember(owner = "client!sign/signlink", name = "dns", descriptor = "Ljava/lang/String;")
	public static String dns = null;

	@OriginalMember(owner = "client!sign/signlink", name = "loadreq", descriptor = "Ljava/lang/String;")
	private static String loadreq = null;

	@OriginalMember(owner = "client!sign/signlink", name = "loadbuf", descriptor = "[B")
	private static byte[] loadbuf = null;

	@OriginalMember(owner = "client!sign/signlink", name = "savereq", descriptor = "Ljava/lang/String;")
	private static String savereq = null;

	@OriginalMember(owner = "client!sign/signlink", name = "savebuf", descriptor = "[B")
	private static byte[] savebuf = null;

	@OriginalMember(owner = "client!sign/signlink", name = "looprate", descriptor = "I")
	private static int looprate = 50;

	@OriginalMember(owner = "client!sign/signlink", name = "midi", descriptor = "Ljava/lang/String;")
	public static String midi = "none";

	@OriginalMember(owner = "client!sign/signlink", name = "wave", descriptor = "Ljava/lang/String;")
	private static String wave = "none";

	@OriginalMember(owner = "client!sign/signlink", name = "errorname", descriptor = "Ljava/lang/String;")
	public static String errorname = "";

	@OriginalMember(owner = "client!sign/signlink", name = "startpriv", descriptor = "(Ljava/net/InetAddress;)V")
	public static void startpriv() {
		threadliveid = (int) (Math.random() * 9.9999999E7D);

		if (active) {
			try {
				Thread.sleep(500L);
			} catch (@Pc(10) Exception local10) {
			}
			active = false;
		}

		dnsreq = null;
		loadreq = null;
		savereq = null;

		@Pc(33) Thread thread = new Thread(new Signlink());
		thread.setDaemon(true);
		thread.start();

		while (!active) {
			try {
				Thread.sleep(50L);
			} catch (@Pc(43) Exception local43) {
			}
		}
	}

	@OriginalMember(owner = "client!sign/signlink", name = "findcachedir", descriptor = "()Ljava/lang/String;")
	public static String findcachedir() {
		@Pc(50) String[] local50 = new String[] { "c:/windows/", "c:/winnt/", "d:/windows/", "d:/winnt/", "e:/windows/", "e:/winnt/", "f:/windows/", "f:/winnt/", "c:/", "~/", "/tmp/", "" };
		@Pc(52) String local52 = ".file_store_32";
		for (@Pc(54) int local54 = 0; local54 < local50.length; local54++) {
			try {
				@Pc(59) String local59 = local50[local54];
				@Pc(67) File local67;
				if (local59.length() > 0) {
					local67 = new File(local59);
					if (!local67.exists()) {
						continue;
					}
				}
				local67 = new File(local59 + local52);
				if (local67.exists() || local67.mkdir()) {
					return local59 + local52 + "/";
				}
			} catch (@Pc(102) Exception local102) {
			}
		}
		return null;
	}

	@OriginalMember(owner = "client!sign/signlink", name = "getuid", descriptor = "(Ljava/lang/String;)I")
	public static int getuid(@OriginalArg(0) String arg0) {
		try {
			@Pc(11) File local11 = new File(arg0 + "uid.dat");
			if (!local11.exists() || local11.length() < 4L) {
				@Pc(34) DataOutputStream local34 = new DataOutputStream(new FileOutputStream(arg0 + "uid.dat"));
				local34.writeInt((int) (Math.random() * 9.9999999E7D));
				local34.close();
			}
		} catch (@Pc(44) Exception local44) {
		}
		try {
			@Pc(59) DataInputStream local59 = new DataInputStream(new FileInputStream(arg0 + "uid.dat"));
			@Pc(62) int local62 = local59.readInt();
			local59.close();
			return local62 + 1;
		} catch (@Pc(69) Exception local69) {
			return 0;
		}
	}

	@OriginalMember(owner = "client!sign/signlink", name = "gethash", descriptor = "(Ljava/lang/String;)J")
	public static long gethash(@OriginalArg(0) String arg0) {
		@Pc(2) String local2 = arg0.trim();
		@Pc(4) long local4 = 0L;
		for (@Pc(6) int local6 = 0; local6 < local2.length() && local6 < 12; local6++) {
			@Pc(11) char local11 = local2.charAt(local6);
			local4 *= 37L;
			if (local11 >= 'A' && local11 <= 'Z') {
				local4 += local11 + 1 - 65;
			} else if (local11 >= 'a' && local11 <= 'z') {
				local4 += local11 + 1 - 97;
			} else if (local11 >= '0' && local11 <= '9') {
				local4 += local11 + 27 - 48;
			}
		}
		return local4;
	}

	@OriginalMember(owner = "client!sign/signlink", name = "looprate", descriptor = "(I)V")
	public static void looprate(@OriginalArg(0) int arg0) {
		looprate = arg0;
	}

	@OriginalMember(owner = "client!sign/signlink", name = "cacheload", descriptor = "(Ljava/lang/String;)[B")
	public static synchronized byte[] cacheload(@OriginalArg(0) String arg0) {
		if (!active) {
			return null;
		}
		loadreq = String.valueOf(gethash(arg0));
		while (loadreq != null) {
			try {
				Thread.sleep(1L);
			} catch (@Pc(12) Exception local12) {
			}
		}
		return loadbuf;
	}

	@OriginalMember(owner = "client!sign/signlink", name = "cachesave", descriptor = "(Ljava/lang/String;[B)V")
	public static synchronized void cachesave(@OriginalArg(0) String arg0, @OriginalArg(1) byte[] arg1) {
		if (!active || arg1.length > 2000000) {
			return;
		}
		while (savereq != null) {
			try {
				Thread.sleep(1L);
			} catch (@Pc(11) Exception local11) {
			}
		}
		savelen = arg1.length;
		savebuf = arg1;
		savereq = String.valueOf(gethash(arg0));
		while (savereq != null) {
			try {
				Thread.sleep(1L);
			} catch (@Pc(28) Exception local28) {
			}
		}
	}

	@OriginalMember(owner = "client!sign/signlink", name = "dnslookup", descriptor = "(Ljava/lang/String;)V")
	public static synchronized void dnslookup(@OriginalArg(0) String arg0) {
		dns = arg0;
		dnsreq = arg0;
	}

	@OriginalMember(owner = "client!sign/signlink", name = "wavesave", descriptor = "([BI)Z")
	public static synchronized boolean wavesave(@OriginalArg(0) byte[] arg0, @OriginalArg(1) int arg1) {
		if (arg1 > 2000000) {
			return false;
		} else if (savereq == null) {
			wavepos = (wavepos + 1) % 5;
			savelen = arg1;
			savebuf = arg0;
			waveplay = true;
			savereq = "sound" + wavepos + ".wav";
			return true;
		} else {
			return false;
		}
	}

	@OriginalMember(owner = "client!sign/signlink", name = "wavereplay", descriptor = "()Z")
	public static synchronized boolean wavereplay() {
		if (savereq == null) {
			savebuf = null;
			waveplay = true;
			savereq = "sound" + wavepos + ".wav";
			return true;
		} else {
			return false;
		}
	}

	@OriginalMember(owner = "client!sign/signlink", name = "midisave", descriptor = "([BI)V")
	public static synchronized void midisave(@OriginalArg(0) byte[] arg0, @OriginalArg(1) int arg1) {
		if (arg1 > 2000000 || savereq != null) {
			return;
		}
		midipos = (midipos + 1) % 5;
		savelen = arg1;
		savebuf = arg0;
		midiplay = true;
		savereq = "jingle" + midipos + ".mid";
	}

	private MidiPlayer midiPlayer;
	public boolean midiFadingIn = false;
	public boolean midiFadingOut = false;
	public int midiFadeVol = 0;
	private final Position curPosition = Position.NORMAL;

	enum Position {
		LEFT, RIGHT, NORMAL
	}

	public void playMidi(String music) {
		if (midiFadingOut) {
			return;
		} else if (!midiFadingIn && midifade && midiPlayer.running()) {
			midiFadingOut = true;
			midiFadeVol = midivol;
			return;
		}

		try {
			if (midifade && midiFadingIn) {
				midiFadingOut = false;
				midiFadeVol = 0;
				midiPlayer.play(MidiSystem.getSequence(new File(music)), midifade, midiFadeVol);
			} else {
				midiPlayer.play(MidiSystem.getSequence(new File(music)), midifade, midivol);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// adapted from play_members.html's JS loop
	private void audioLoop() {
		if (midiFadingIn) {
			midiFadeVol += 8;
			if (midiFadeVol > midivol) {
				midiFadeVol = midivol;
			}
			midiPlayer.setVolume(0, midiFadeVol);
			if (midiFadeVol == midivol) {
				midiFadingIn = false;
			}
		} else if (midiFadingOut) {
			midiFadeVol -= 8;
			if (midiFadeVol < 0) {
				midiFadeVol = 0;
			}
			midiPlayer.setVolume(0, midiFadeVol);
			if (midiFadeVol == 0) {
				midiFadingOut = false;
				midiFadingIn = true;
			}
		}

		if (!Objects.equals(midi, "none")) {
			if (Objects.equals(midi, "stop")) {
				midiPlayer.stop();
			} else if (Objects.equals(midi, "voladjust")) {
				midiPlayer.setVolume(0, midivol);
			} else {
				playMidi(midi);
			}

			if (!midiFadingOut) {
				midi = "none";
			}
		}

		if (!Objects.equals(wave, "none")) {
			AudioInputStream audioInputStream;

			try {
				audioInputStream = AudioSystem.getAudioInputStream(new File(wave));
			} catch (Exception e1) {
				e1.printStackTrace();
				return;
			}

			AudioFormat format = audioInputStream.getFormat();
			SourceDataLine auline;
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

			try {
				auline = (SourceDataLine) AudioSystem.getLine(info);
				auline.open(format);
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}

			if (auline.isControlSupported(FloatControl.Type.PAN)) {
				FloatControl pan = (FloatControl) auline.getControl(FloatControl.Type.PAN);
				if (curPosition == Position.RIGHT) {
					pan.setValue(1.0f);
				} else if (curPosition == Position.LEFT) {
					pan.setValue(-1.0f);
				}
			}

			auline.start();
			int nBytesRead = 0;
			int EXTERNAL_BUFFER_SIZE = 524288;
			byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];

			try {
				while (nBytesRead != -1) {
					nBytesRead = audioInputStream.read(abData, 0, abData.length);
					if (nBytesRead >= 0) {
						auline.write(abData, 0, nBytesRead);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				auline.drain();
				auline.close();
			}

			wave = "none";
		}
	}

	@OriginalMember(owner = "client!sign/signlink", name = "run", descriptor = "()V")
	@Override
	public void run() {
		active = true;

		@Pc(3) String cachedir = findcachedir();
		uid = getuid(cachedir);

		try {
			midiPlayer = new MidiPlayer();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		@Pc(8) int threadid = threadliveid;
		while (threadliveid == threadid) {
			audioLoop();

			if (dnsreq != null) {
				try {
					dns = InetAddress.getByName(dnsreq).getHostName();
				} catch (@Pc(50) Exception local50) {
					dns = "unknown";
				}
				dnsreq = null;
			} else if (loadreq != null) {
				loadbuf = null;
				try {
					@Pc(71) File local71 = new File(cachedir + loadreq);
					if (local71.exists()) {
						@Pc(78) int local78 = (int) local71.length();
						loadbuf = new byte[local78];
						@Pc(96) DataInputStream local96 = new DataInputStream(new FileInputStream(cachedir + loadreq));
						local96.readFully(loadbuf, 0, local78);
						local96.close();
					}
				} catch (@Pc(105) Exception local105) {
				}
				loadreq = null;
			} else if (savereq != null) {
				if (savebuf != null) {
					try {
						@Pc(124) FileOutputStream local124 = new FileOutputStream(cachedir + savereq);
						local124.write(savebuf, 0, savelen);
						local124.close();
					} catch (@Pc(133) Exception local133) {
					}
				}
				if (waveplay) {
					wave = cachedir + savereq;
					waveplay = false;
				}
				if (midiplay) {
					midi = cachedir + savereq;
					midiplay = false;
				}
				savereq = null;
			}

			try {
				Thread.sleep(looprate);
			} catch (@Pc(187) Exception local187) {
			}
		}
	}
}
