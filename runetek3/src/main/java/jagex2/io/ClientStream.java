package jagex2.io;

import jagex2.client.GameShell;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

// ClientStream: client socket stream
@OriginalClass("client!d")
public final class ClientStream implements Runnable {

	@OriginalMember(owner = "client!d", name = "b", descriptor = "Ljava/io/InputStream;")
	private final InputStream in;

	@OriginalMember(owner = "client!d", name = "c", descriptor = "Ljava/io/OutputStream;")
	private final OutputStream out;

	@OriginalMember(owner = "client!d", name = "d", descriptor = "Ljava/net/Socket;")
	private final Socket socket;

	@OriginalMember(owner = "client!d", name = "e", descriptor = "Z")
	private boolean closed = false;

	@OriginalMember(owner = "client!d", name = "f", descriptor = "Lclient!a;")
	private final GameShell shell;

	@OriginalMember(owner = "client!d", name = "g", descriptor = "[B")
	private byte[] buf;

	@OriginalMember(owner = "client!d", name = "h", descriptor = "I")
	private int tcyl;

	@OriginalMember(owner = "client!d", name = "i", descriptor = "I")
	private int tnum;

	@OriginalMember(owner = "client!d", name = "j", descriptor = "Z")
	private boolean writing = false;

	@OriginalMember(owner = "client!d", name = "k", descriptor = "Z")
	private boolean ioerror = false;

	@OriginalMember(owner = "client!d", name = "<init>", descriptor = "(Lclient!a;BLjava/net/Socket;)V")
	public ClientStream(@OriginalArg(0) GameShell arg0, @OriginalArg(2) Socket arg2) throws IOException {
		this.shell = arg0;
		this.socket = arg2;
		this.socket.setSoTimeout(30000);
		this.socket.setTcpNoDelay(true);
		this.in = this.socket.getInputStream();
		this.out = this.socket.getOutputStream();
	}

	@OriginalMember(owner = "client!d", name = "a", descriptor = "()V")
	public void close() {
		this.closed = true;
		try {
			if (this.in != null) {
				this.in.close();
			}
			if (this.out != null) {
				this.out.close();
			}
			if (this.socket != null) {
				this.socket.close();
			}
		} catch (@Pc(22) IOException local22) {
			System.out.println("Error closing stream");
		}
		this.writing = false;
		synchronized (this) {
			this.notify();
		}
		this.buf = null;
	}

	@OriginalMember(owner = "client!d", name = "b", descriptor = "()I")
	public int read() throws IOException {
		return this.closed ? 0 : this.in.read();
	}

	@OriginalMember(owner = "client!d", name = "c", descriptor = "()I")
	public int available() throws IOException {
		return this.closed ? 0 : this.in.available();
	}

	@OriginalMember(owner = "client!d", name = "a", descriptor = "([BII)V")
	public void read(@OriginalArg(0) byte[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) throws IOException {
		if (this.closed) {
			return;
		}
		while (arg2 > 0) {
			@Pc(11) int local11 = this.in.read(arg0, arg1, arg2);
			if (local11 <= 0) {
				throw new IOException("EOF");
			}
			arg1 += local11;
			arg2 -= local11;
		}
	}

	@OriginalMember(owner = "client!d", name = "a", descriptor = "([BIZI)V")
	public void write(@OriginalArg(0) byte[] arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg3) throws IOException {
		if (this.closed) {
			return;
		}

		if (this.ioerror) {
			this.ioerror = false;
			throw new IOException("Error in writer thread");
		}
		if (this.buf == null) {
			this.buf = new byte[5000];
		}
		synchronized (this) {
			for (@Pc(31) int local31 = 0; local31 < arg1; local31++) {
				this.buf[this.tnum] = arg0[local31 + arg3];
				this.tnum = (this.tnum + 1) % 5000;
				if (this.tnum == (this.tcyl + 4900) % 5000) {
					throw new IOException("buffer overflow");
				}
			}
			if (!this.writing) {
				this.writing = true;
				this.shell.startThread(this, 2);
			}
			this.notify();
		}
	}

	@OriginalMember(owner = "client!d", name = "run", descriptor = "()V")
	@Override
	public void run() {
		while (this.writing) {
			@Pc(38) int local38;
			@Pc(27) int local27;
			synchronized (this) {
				if (this.tnum == this.tcyl) {
					try {
						this.wait();
					} catch (@Pc(16) InterruptedException local16) {
					}
				}
				if (!this.writing) {
					return;
				}
				local27 = this.tcyl;
				if (this.tnum >= this.tcyl) {
					local38 = this.tnum - this.tcyl;
				} else {
					local38 = 5000 - this.tcyl;
				}
			}
			if (local38 > 0) {
				try {
					this.out.write(this.buf, local27, local38);
				} catch (@Pc(62) IOException local62) {
					this.ioerror = true;
				}
				this.tcyl = (this.tcyl + local38) % 5000;
				try {
					if (this.tnum == this.tcyl) {
						this.out.flush();
					}
				} catch (@Pc(83) IOException local83) {
					this.ioerror = true;
				}
			}
		}
	}
}
