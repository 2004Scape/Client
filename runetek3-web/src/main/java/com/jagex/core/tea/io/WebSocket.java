package com.jagex.core.tea.io;

import org.teavm.interop.Async;
import org.teavm.interop.AsyncCallback;
import org.teavm.jso.dom.events.Event;
import org.teavm.jso.dom.events.EventListener;
import org.teavm.jso.dom.events.MessageEvent;
import org.teavm.jso.typedarrays.Int8Array;
import org.teavm.jso.websocket.CloseEvent;

import java.io.IOException;
import java.util.ArrayList;

public class WebSocket {
	private String host;
	private int port;
	private org.teavm.jso.websocket.WebSocket client;
	private boolean connected = false;
	private int bytesAvailable = 0;
	private ArrayList<Int8Array> buffers = new ArrayList<Int8Array>();
	private Int8Array currentBuffer;
	private int offset = 0;
	private int bytesLeft = 0;

	public WebSocket(String host, int port) {
		this.host = host;
		this.port = port;
	}

	@Async
	public native int connect();
	public void connect(AsyncCallback<Integer> callback) {
		boolean isSecure = this.host.startsWith("https:");
		this.client = org.teavm.jso.websocket.WebSocket.create((isSecure ? "wss" : "ws") + "://" + this.host.substring("http://".length()) + ":" + (isSecure ? this.port + 2 : this.port + 1), "binary");
		this.client.setBinaryType("arraybuffer");

		this.client.onClose(new EventListener<CloseEvent>(){
			public void handleEvent(CloseEvent event) {
				connected = false;
			}
		});

		this.client.onMessage(new EventListener<MessageEvent>(){
			public void handleEvent(MessageEvent event) {
				Int8Array toAdd = Int8Array.create(event.getDataAsArray());
				buffers.add(toAdd);
				bytesAvailable += toAdd.getLength();
				refreshCurrentBuffer();
			};
		});

		this.client.onOpen(new EventListener<MessageEvent>(){
			public void handleEvent(MessageEvent event) {
				connected = true;
				callback.complete(1);
			}
		});

		this.client.onError(new EventListener<Event>(){
			public void handleEvent(Event event) {
				connected = false;
				callback.error(new IOException("WebSocket error"));
			}
		});
	}

	public void write(byte[] bytes, int length, int offset) throws IOException {
		if (!this.connected) {
			throw new IOException("Socket is not connected");
		}

		Int8Array toSend = Int8Array.create(length);

		for (int i = 0; i < length; i += 1) {
			toSend.set(i, bytes[offset + i]);
		}

		this.client.send(toSend);
	}

	private void refreshCurrentBuffer() {
		if (this.bytesLeft == 0 && this.bytesAvailable > 0) {
			this.currentBuffer = this.buffers.remove(0);
			this.offset = 0;

			if (this.currentBuffer != null && this.currentBuffer.getLength() > 0) {
				this.bytesLeft = this.currentBuffer.getLength();
			} else {
				this.bytesLeft = 0;
			}
		}
	}

	public int read() throws IOException {
		if (!this.connected) {
			throw new IOException("Socket is not connected");
		}

		if (this.bytesLeft > 0) {
			this.bytesLeft--;
			this.bytesAvailable--;
			return this.currentBuffer.get(this.offset++) & 0xff;
		}

		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
		}

		return this.read();
	}

	public int read(byte[] destination, int off, int length) throws IOException {
		if (!this.connected) {
			throw new IOException("Socket is not connected");
		}

		if (this.bytesAvailable >= length) {
			while (length > 0) {
				destination[off++] = this.currentBuffer.get(this.offset++);
				this.bytesLeft -= 1;
				this.bytesAvailable -= 1;
				length -= 1;

				if (this.bytesLeft == 0) {
					this.refreshCurrentBuffer();
				}
			}

			return length;
		}

		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
		}

		return this.read(destination, offset, length);
	}

	public void close() {
		if (!this.connected) {
			return;
		}

		this.client.close();
	}

	public int available() {
		return this.bytesAvailable;
	}

	public void clear() {
		if (this.connected) {
			this.client.close();
		}

		this.currentBuffer = null;
		this.buffers.clear();
		this.bytesLeft = 0;
	}
}
