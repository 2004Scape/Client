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

@OriginalClass("client!d")
public class ClientStream implements Runnable {

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
	private int bufLen;

	@OriginalMember(owner = "client!d", name = "i", descriptor = "I")
	private int bufPos;

	@OriginalMember(owner = "client!d", name = "j", descriptor = "Z")
	private boolean writer = false;

	@OriginalMember(owner = "client!d", name = "k", descriptor = "Z")
	private boolean ioerror = false;

	@OriginalMember(owner = "client!d", name = "<init>", descriptor = "(Lclient!a;BLjava/net/Socket;)V")
	public ClientStream(@OriginalArg(0) GameShell shell, @OriginalArg(2) Socket socket) throws IOException {
		this.shell = shell;
		this.socket = socket;
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
		} catch (@Pc(22) IOException ignored) {
			System.out.println("Error closing stream");
		}

		this.writer = false;
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
	public void read(@OriginalArg(0) byte[] dst, @OriginalArg(1) int off, @OriginalArg(2) int len) throws IOException {
		if (this.closed) {
			return;
		}

		while (len > 0) {
			@Pc(11) int read = this.in.read(dst, off, len);
			if (read <= 0) {
				throw new IOException("EOF");
			}

			off += read;
			len -= read;
		}
	}

	@OriginalMember(owner = "client!d", name = "a", descriptor = "([BIZI)V")
	public void write(@OriginalArg(0) byte[] src, @OriginalArg(1) int len, @OriginalArg(3) int off) throws IOException {
		if (!this.closed) {
			if (this.ioerror) {
				this.ioerror = false;
				throw new IOException("Error in writer thread");
			}

			if (this.buf == null) {
				this.buf = new byte[5000];
			}

			synchronized (this) {
				for (@Pc(31) int i = 0; i < len; i++) {
					this.buf[this.bufPos] = src[i + off];
					this.bufPos = (this.bufPos + 1) % 5000;

					if (this.bufPos == (this.bufLen + 4900) % 5000) {
						throw new IOException("buffer overflow");
					}
				}

				if (!this.writer) {
					this.writer = true;
					this.shell.startThread(this, 2);
				}

				this.notify();
			}
		}
	}

	@OriginalMember(owner = "client!d", name = "run", descriptor = "()V")
	public void run() {
		while (this.writer) {
			@Pc(38) int len;
			@Pc(27) int off;

			synchronized (this) {
				if (this.bufPos == this.bufLen) {
					try {
						this.wait();
					} catch (@Pc(16) InterruptedException ignored) {
					}
				}

				if (!this.writer) {
					return;
				}

				off = this.bufLen;
				if (this.bufPos >= this.bufLen) {
					len = this.bufPos - this.bufLen;
				} else {
					len = 5000 - this.bufLen;
				}
			}

			if (len > 0) {
				try {
					this.out.write(this.buf, off, len);
				} catch (@Pc(62) IOException ignored) {
					this.ioerror = true;
				}

				this.bufLen = (this.bufLen + len) % 5000;
				try {
					if (this.bufPos == this.bufLen) {
						this.out.flush();
					}
				} catch (@Pc(83) IOException ignored) {
					this.ioerror = true;
				}
			}
		}
	}
}
