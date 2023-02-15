import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!d")
public final class Connection implements Runnable {

	@OriginalMember(owner = "client!d", name = "a", descriptor = "Z")
	private boolean flowObfuscator1 = false;

	@OriginalMember(owner = "client!d", name = "b", descriptor = "Ljava/io/InputStream;")
	private final InputStream anInputStream1;

	@OriginalMember(owner = "client!d", name = "c", descriptor = "Ljava/io/OutputStream;")
	private final OutputStream anOutputStream1;

	@OriginalMember(owner = "client!d", name = "d", descriptor = "Ljava/net/Socket;")
	private final Socket aSocket1;

	@OriginalMember(owner = "client!d", name = "e", descriptor = "Z")
	private boolean aBoolean75 = false;

	@OriginalMember(owner = "client!d", name = "f", descriptor = "Lclient!a;")
	private final GameShell anApplet_Sub1_2;

	@OriginalMember(owner = "client!d", name = "g", descriptor = "[B")
	private byte[] aByteArray5;

	@OriginalMember(owner = "client!d", name = "h", descriptor = "I")
	private int anInt347;

	@OriginalMember(owner = "client!d", name = "i", descriptor = "I")
	private int anInt348;

	@OriginalMember(owner = "client!d", name = "j", descriptor = "Z")
	private boolean aBoolean76 = false;

	@OriginalMember(owner = "client!d", name = "k", descriptor = "Z")
	private boolean aBoolean77 = false;

	@OriginalMember(owner = "client!d", name = "<init>", descriptor = "(Lclient!a;BLjava/net/Socket;)V")
	public Connection(@OriginalArg(0) GameShell arg0, @OriginalArg(1) byte arg1, @OriginalArg(2) Socket arg2) throws IOException {
		try {
			if (arg1 == 2) {
				@Pc(18) boolean local18 = false;
			} else {
				this.flowObfuscator1 = !this.flowObfuscator1;
			}
			this.anApplet_Sub1_2 = arg0;
			this.aSocket1 = arg2;
			this.aSocket1.setSoTimeout(30000);
			this.aSocket1.setTcpNoDelay(true);
			this.anInputStream1 = this.aSocket1.getInputStream();
			this.anOutputStream1 = this.aSocket1.getOutputStream();
		} catch (@Pc(54) RuntimeException local54) {
			signlink.reporterror("77482, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local54.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!d", name = "a", descriptor = "()V")
	public void method201() {
		this.aBoolean75 = true;
		try {
			if (this.anInputStream1 != null) {
				this.anInputStream1.close();
			}
			if (this.anOutputStream1 != null) {
				this.anOutputStream1.close();
			}
			if (this.aSocket1 != null) {
				this.aSocket1.close();
			}
		} catch (@Pc(22) IOException local22) {
			System.out.println("Error closing stream");
		}
		this.aBoolean76 = false;
		synchronized (this) {
			this.notify();
		}
		this.aByteArray5 = null;
	}

	@OriginalMember(owner = "client!d", name = "b", descriptor = "()I")
	public int method202() throws IOException {
		return this.aBoolean75 ? 0 : this.anInputStream1.read();
	}

	@OriginalMember(owner = "client!d", name = "c", descriptor = "()I")
	public int method203() throws IOException {
		return this.aBoolean75 ? 0 : this.anInputStream1.available();
	}

	@OriginalMember(owner = "client!d", name = "a", descriptor = "([BII)V")
	public void method204(@OriginalArg(0) byte[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) throws IOException {
		if (this.aBoolean75) {
			return;
		}
		while (arg2 > 0) {
			@Pc(11) int local11 = this.anInputStream1.read(arg0, arg1, arg2);
			if (local11 <= 0) {
				throw new IOException("EOF");
			}
			arg1 += local11;
			arg2 -= local11;
		}
	}

	@OriginalMember(owner = "client!d", name = "a", descriptor = "([BIZI)V")
	public void method205(@OriginalArg(0) byte[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) boolean arg2, @OriginalArg(3) int arg3) throws IOException {
		try {
			if (arg2 && !this.aBoolean75) {
				if (this.aBoolean77) {
					this.aBoolean77 = false;
					throw new IOException("Error in writer thread");
				}
				if (this.aByteArray5 == null) {
					this.aByteArray5 = new byte[5000];
				}
				synchronized (this) {
					for (@Pc(31) int local31 = 0; local31 < arg1; local31++) {
						this.aByteArray5[this.anInt348] = arg0[local31 + arg3];
						this.anInt348 = (this.anInt348 + 1) % 5000;
						if (this.anInt348 == (this.anInt347 + 4900) % 5000) {
							throw new IOException("buffer overflow");
						}
					}
					if (!this.aBoolean76) {
						this.aBoolean76 = true;
						this.anApplet_Sub1_2.method73(this, 2);
					}
					this.notify();
				}
			}
		} catch (@Pc(90) RuntimeException local90) {
			signlink.reporterror("86047, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local90.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!d", name = "run", descriptor = "()V")
	@Override
	public void run() {
		while (this.aBoolean76) {
			@Pc(38) int local38;
			@Pc(27) int local27;
			synchronized (this) {
				if (this.anInt348 == this.anInt347) {
					try {
						this.wait();
					} catch (@Pc(16) InterruptedException local16) {
					}
				}
				if (!this.aBoolean76) {
					return;
				}
				local27 = this.anInt347;
				if (this.anInt348 >= this.anInt347) {
					local38 = this.anInt348 - this.anInt347;
				} else {
					local38 = 5000 - this.anInt347;
				}
			}
			if (local38 > 0) {
				try {
					this.anOutputStream1.write(this.aByteArray5, local27, local38);
				} catch (@Pc(62) IOException local62) {
					this.aBoolean77 = true;
				}
				this.anInt347 = (this.anInt347 + local38) % 5000;
				try {
					if (this.anInt348 == this.anInt347) {
						this.anOutputStream1.flush();
					}
				} catch (@Pc(83) IOException local83) {
					this.aBoolean77 = true;
				}
			}
		}
	}
}
