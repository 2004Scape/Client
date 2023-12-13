package jagex2.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

import org.teavm.interop.Async;
import org.teavm.interop.AsyncCallback;
import org.teavm.jso.dom.events.Event;
import org.teavm.jso.dom.events.EventListener;
import org.teavm.jso.dom.events.MessageEvent;
import org.teavm.jso.typedarrays.Int8Array;
import org.teavm.jso.websocket.CloseEvent;
import org.teavm.jso.websocket.WebSocket;

public class WebClientStream {
    private String host;
    private boolean secure;
    private int port;

    private WebSocket client;
    private Queue<Int8Array> queue = new LinkedList<>();
    private int remaining = 0;
    private Int8Array buffer = null;
    private int offset = 0;

    public WebClientStream(String host, int port) {
        this.host = host.substring(host.indexOf("//") + 2);
        this.secure = host.startsWith("https:");
        // tcp on main port, ws on main port + 1, wss on main port + 2
		this.port = secure ? port + 2 : port + 1;
    }

    @Async
    public native int connect();
    public void connect(AsyncCallback<Integer> callback) {
    	String protocol = this.secure ? "wss" : "ws";
    	this.client = WebSocket.create(protocol + "://" + this.host + ":" + this.port, "binary");
        this.client.setBinaryType("arraybuffer");

        this.client.onMessage(new EventListener<MessageEvent>(){
            public void handleEvent(MessageEvent event) {
                Int8Array data = Int8Array.create(event.getDataAsArray());
                remaining += data.getLength();
                queue.add(data);
            };
        });

        this.client.onOpen(new EventListener<MessageEvent>(){
            public void handleEvent(MessageEvent event) {
                callback.complete(1);
            }
        });

        this.client.onError(new EventListener<Event>(){
            public void handleEvent(Event event) {
                callback.error(new IOException("WebSocket error"));
            }
        });
    }

    public void write(byte[] src, int length, int offset) throws IOException {
        if (this.client.getReadyState() != 1) {
			throw new IOException("Socket is not able to write");
        }

        Int8Array data = Int8Array.create(length);

        for (int i = 0; i < length; i++) {
            data.set(i, src[offset + i]);
        }

        this.client.send(data);
    }

    // read 1 byte
    public int read() throws IOException {
        if (this.client.getReadyState() != 1) {
			throw new IOException("Socket is not able to read");
        }

        if (this.remaining < 1) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
            }

            return this.read();
        }

        if (this.buffer == null) {
            this.buffer = this.queue.poll();
            this.offset = 0;
        }

        int value = this.buffer.get(this.offset) & 0xFF;
        this.offset++;
        this.remaining--;

        if (this.offset == this.buffer.getLength()) {
            this.buffer = null;
        }

        return value;
    }

    // read n bytes
    public int read(byte[] destination, int off, int length) throws IOException {
        if (this.client.getReadyState() != 1) {
			throw new IOException("Socket is not able to read");
        }

        if (this.available() < length) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
            }

            return this.read(destination, off, length);
        }

        for (int i = 0; i < length; i++) {
            destination[off + i] = (byte) this.read();
        }

        return length;
    }

    public void close() {
        if (this.client.getReadyState() != 1) {
            return;
        }

        this.client.close();
    }

    public int available() {
        return this.remaining;
    }

    public void clear() {
        if (this.client.getReadyState() == 1) {
            this.client.close();
        }

        this.queue.clear();

        this.remaining = 0;
        this.buffer = null;
        this.offset = 0;
    }
}
