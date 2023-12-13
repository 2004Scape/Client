package jagex2.client;

import jagex2.io.DatabaseStore;
import jagex2.io.FileDownloadStream;
import jagex2.io.WebClientStream;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import org.teavm.jso.JSBody;

import java.io.IOException;
import java.util.Objects;

@OriginalClass("client!sign/signlink")
public final class Signlink implements Runnable {

	@OriginalMember(owner = "client!sign/signlink", name = "clientversion", descriptor = "I")
	public static int clientversion = 225;

	@OriginalMember(owner = "client!sign/signlink", name = "uid", descriptor = "I")
	public static int uid;

	@OriginalMember(owner = "client!sign/signlink", name = "active", descriptor = "Z")
	private static boolean active;

	@OriginalMember(owner = "client!sign/signlink", name = "threadliveid", descriptor = "I")
	private static int threadliveid;

	@OriginalMember(owner = "client!sign/signlink", name = "socketip", descriptor = "Ljava/net/InetAddress;")
	private static String socketip;

	@OriginalMember(owner = "client!sign/signlink", name = "socketreq", descriptor = "I")
	private static int socketreq;

	@OriginalMember(owner = "client!sign/signlink", name = "savelen", descriptor = "I")
	private static int savelen;

	@OriginalMember(owner = "client!sign/signlink", name = "midiplay", descriptor = "Z")
	private static boolean midiplay;

	@OriginalMember(owner = "client!sign/signlink", name = "midipos", descriptor = "I")
	private static int midipos;

	@OriginalMember(owner = "client!sign/signlink", name = "midivol", descriptor = "I")
	public static int midivol = 192;

	@OriginalMember(owner = "client!sign/signlink", name = "midifade", descriptor = "I")
	public static boolean midifade;

	@OriginalMember(owner = "client!sign/signlink", name = "waveplay", descriptor = "Z")
	private static boolean waveplay;

	@OriginalMember(owner = "client!sign/signlink", name = "wavepos", descriptor = "I")
	private static int wavepos;

	@OriginalMember(owner = "client!sign/signlink", name = "wavevol", descriptor = "I")
	public static int wavevol = 192;

	@OriginalMember(owner = "client!sign/signlink", name = "socket", descriptor = "Ljava/net/Socket;")
	private static WebClientStream socket = null;

	@OriginalMember(owner = "client!sign/signlink", name = "threadreqpri", descriptor = "I")
	private static int threadreqpri = 1;

	@OriginalMember(owner = "client!sign/signlink", name = "threadreq", descriptor = "Ljava/lang/Runnable;")
	private static Runnable threadreq = null;

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

	@OriginalMember(owner = "client!sign/signlink", name = "urlreq", descriptor = "Ljava/lang/String;")
	private static String urlreq = null;

	@OriginalMember(owner = "client!sign/signlink", name = "urlstream", descriptor = "Ljava/io/DataInputStream;")
	private static FileDownloadStream urlstream = null;

	@OriginalMember(owner = "client!sign/signlink", name = "looprate", descriptor = "I")
	private static int looprate = 50;

	@OriginalMember(owner = "client!sign/signlink", name = "midi", descriptor = "Ljava/lang/String;")
	public static String midi = "none";

	@OriginalMember(owner = "client!sign/signlink", name = "wave", descriptor = "Ljava/lang/String;")
	private static String wave = "none";

	@OriginalMember(owner = "client!sign/signlink", name = "reporterror", descriptor = "Z")
	public static boolean reporterror = true;

	@OriginalMember(owner = "client!sign/signlink", name = "errorname", descriptor = "Ljava/lang/String;")
	public static String errorname = "";

	@OriginalMember(owner = "client!sign/signlink", name = "startpriv", descriptor = "(Ljava/net/InetAddress;)V")
	public static void startpriv(@OriginalArg(0) String arg0) {
		threadliveid = (int) (Math.random() * 9.9999999E7D);
		if (active) {
			try {
				Thread.sleep(500L);
			} catch (@Pc(10) Exception local10) {
			}
			active = false;
		}
		socketreq = 0;
		threadreq = null;
		dnsreq = null;
		loadreq = null;
		savereq = null;
		urlreq = null;
		socketip = arg0;
		@Pc(33) Thread local33 = new Thread(new Signlink());
		local33.setDaemon(true);
		local33.start();
		while (!active) {
			try {
				Thread.sleep(50L);
			} catch (@Pc(43) Exception local43) {
			}
		}
	}

	@OriginalMember(owner = "client!sign/signlink", name = "getuid", descriptor = "(Ljava/lang/String;)I")
	public static int getuid() {
		return (int)(Math.random() * Integer.MAX_VALUE);
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
		loadreq = String.valueOf(arg0);
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
		savereq = String.valueOf(arg0);
		while (savereq != null) {
			try {
				Thread.sleep(1L);
			} catch (@Pc(28) Exception local28) {
			}
		}
	}

	@OriginalMember(owner = "client!sign/signlink", name = "opensocket", descriptor = "(I)Ljava/net/Socket;")
	public static synchronized WebClientStream opensocket(@OriginalArg(0) int arg0) throws IOException {
		socketreq = arg0;
		while (socketreq != 0) {
			try {
				Thread.sleep(50L);
			} catch (@Pc(6) Exception local6) {
			}
		}
		if (socket == null) {
			throw new IOException("could not open socket");
		}
		return socket;
	}

	@OriginalMember(owner = "client!sign/signlink", name = "openurl", descriptor = "(Ljava/lang/String;)Ljava/io/DataInputStream;")
	public static synchronized FileDownloadStream openurl(@OriginalArg(0) String arg0) throws IOException {
		urlreq = arg0;
		while (urlreq != null) {
			try {
				Thread.sleep(50L);
			} catch (@Pc(6) Exception local6) {
			}
		}
		if (urlstream == null) {
			throw new IOException("could not open: " + arg0);
		}
		return urlstream;
	}

	@OriginalMember(owner = "client!sign/signlink", name = "dnslookup", descriptor = "(Ljava/lang/String;)V")
	public static synchronized void dnslookup(@OriginalArg(0) String arg0) {
		dns = arg0;
		dnsreq = arg0;
	}

	@OriginalMember(owner = "client!sign/signlink", name = "startthread", descriptor = "(Ljava/lang/Runnable;I)V")
	public static synchronized void startthread(@OriginalArg(0) Runnable arg0, @OriginalArg(1) int arg1) {
		threadreqpri = arg1;
		threadreq = arg0;
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

	@OriginalMember(owner = "client!sign/signlink", name = "reporterror", descriptor = "(Ljava/lang/String;)V")
	public static void reporterror(@OriginalArg(0) String arg0) {
		if (!reporterror || !active) {
			return;
		}
		System.out.println("Error: " + arg0);
		try {
			@Pc(19) String local19 = arg0.replace('@', '_');
			@Pc(24) String local24 = local19.replace('&', '_');
			@Pc(29) String local29 = local24.replace('#', '_');
			openurl("reporterror" + 225 + ".cgi?error=" + errorname + " " + local29);
		} catch (IOException ex) {
		}
	}

	@JSBody(params = { "data", "vol" }, script = "playWave(data, vol)")
	public static native void jsPlayWave(byte[] data, int vol);

	@JSBody(params = { "vol" }, script = "setWaveVolume(vol)")
	public static native void jsSetWaveVolume(int vol);

	@JSBody(params = { "data", "vol", "fade" }, script = "playMidi(data, vol, fade)")
	public static native void jsPlayMidi(byte[] data, int vol, boolean fade);

	@JSBody(script = "stopMidi()")
	public static native void jsStopMidi();

	@JSBody(params = { "vol" }, script = "setMidiVolume(vol)")
	public static native void jsSetMidiVolume(int vol);

	// adapted from play_members.html's JS loop
	private void audioLoop() {
		try {
			if (!Objects.equals(midi, "none")) {
				if (Objects.equals(midi, "stop")) {
					jsStopMidi();
				} else if (Objects.equals(midi, "voladjust")) {
					jsSetMidiVolume(midivol);
				} else {
					byte[] data = DatabaseStore.getFile(midi);
					if (data == null) {
						data = savebuf; // no caching, we hope it's the right file
					}
					jsPlayMidi(data, midivol, midifade);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		midi = "none";

		try {
			if (!Objects.equals(wave, "none")) {
				byte[] data = DatabaseStore.getFile(wave);
				if (data == null) {
					data = savebuf; // no caching, we hope it's the right file
				}
				jsPlayWave(data, wavevol);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		wave = "none";
	}

	@OriginalMember(owner = "client!sign/signlink", name = "run", descriptor = "()V")
	@Override
	public void run() {
		DatabaseStore.initDb();

		active = true;
		uid = getuid();
		@Pc(8) int local8 = threadliveid;
		while (threadliveid == local8) {
			audioLoop();

			if (socketreq != 0) {
				try {
					socket = new WebClientStream(socketip, socketreq);
					socket.connect();
				} catch (@Pc(19) Exception local19) {
					socket = null;
				}
				socketreq = 0;
			} else if (threadreq != null) {
				@Pc(31) Thread local31 = new Thread(threadreq);
				local31.setDaemon(true);
				local31.start();
				local31.setPriority(threadreqpri);
				threadreq = null;
			} else if (dnsreq != null) {
				dns = dnsreq;
				dnsreq = null;
			} else if (loadreq != null) {
				loadbuf = null;
				try {
					loadbuf = DatabaseStore.getFile(loadreq);
					if (loadbuf != null && loadbuf.length == 0) {
						System.out.println("Failed to load " + loadreq);
						loadbuf = null;
					}
				} catch (@Pc(133) Exception ex) {
					ex.printStackTrace();
				}
				loadreq = null;
			} else if (savereq != null) {
				if (savebuf != null) {
					try {
						DatabaseStore.putFile(savereq, savebuf);
					} catch (@Pc(133) Exception ex) {
						ex.printStackTrace();
					}
				}

				if (waveplay) {
					wave = savereq;
					waveplay = false;
				}
				if (midiplay) {
					midi = savereq;
					midiplay = false;
				}
				savereq = null;
			} else if (urlreq != null) {
				try {
					urlstream = new FileDownloadStream(urlreq);
				} catch (@Pc(178) Exception ignored) {
					urlstream = null;
				}
				urlreq = null;
			}
			try {
				Thread.sleep((long) looprate);
			} catch (@Pc(187) Exception local187) {
			}
		}
	}
}
