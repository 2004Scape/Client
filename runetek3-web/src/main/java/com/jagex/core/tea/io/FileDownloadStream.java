package com.jagex.core.tea.io;

import org.teavm.interop.Async;
import org.teavm.interop.AsyncCallback;
import org.teavm.jso.ajax.XMLHttpRequest;
import org.teavm.jso.typedarrays.ArrayBuffer;
import org.teavm.jso.typedarrays.Int8Array;

import java.io.IOException;

public class FileDownloadStream {

	private final XMLHttpRequest xhr;
	private Int8Array buffer = null;
	private int position = 0;
	public int length;

	public FileDownloadStream(String file) {
		this.xhr = XMLHttpRequest.create();
		this.xhr.setResponseType("arraybuffer");
		this.xhr.open("get", file);
	}

	@Async
	private native int loadResBytes();

	private void loadResBytes(AsyncCallback<Integer> callback) {
		this.xhr.setOnReadyStateChange(() -> {
			if (xhr.getReadyState() != XMLHttpRequest.DONE) {
				return;
			}

			int statusGroup = xhr.getStatus() / 100;

			if (statusGroup != 2 && statusGroup != 3) {
				callback.error(new IOException("HTTP status: " + xhr.getStatus() + " " + xhr.getStatusText()));
			} else {
				this.buffer = Int8Array.create((ArrayBuffer) xhr.getResponse());
				callback.complete(1);
			}
		});

		this.xhr.send();
	}

	public int readFully(byte[] destination, int offset, int length) throws IOException {
		if (this.buffer == null) {
			this.loadResBytes();
		}

		for (int i = 0; i < length; i++) {
			destination[offset + i] = this.buffer.get(i + this.position);
		}

		this.position += length;
		return length;
	}

	public int readFully(byte[] destination, int offset) throws IOException {
		return this.readFully(destination, offset, destination.length);
	}

	public void close() {
		this.buffer = null;
	}

}
