package com.jagex.core.tea.io;

import javax.lang.model.type.NullType;

import org.teavm.interop.Async;
import org.teavm.interop.AsyncCallback;
import org.teavm.jso.JSBody;
import org.teavm.jso.JSByRef;
import org.teavm.jso.core.JSString;
import org.teavm.jso.indexeddb.IDBDatabase;
import org.teavm.jso.indexeddb.IDBFactory;
import org.teavm.jso.indexeddb.IDBGetRequest;
import org.teavm.jso.indexeddb.IDBObjectStore;
import org.teavm.jso.indexeddb.IDBOpenDBRequest;
import org.teavm.jso.indexeddb.IDBRequest;
import org.teavm.jso.indexeddb.IDBTransaction;
import org.teavm.jso.typedarrays.Uint8Array;

public class DatabaseStore {

	@JSBody(params = {"data"}, script = "return Uint8Array.from(data);")
	public static native Uint8Array getUint8Array(@JSByRef byte[] data);

	@JSBody(params = {"data"}, script = "return typeof data === 'undefined' ? null : data;")
	public static native byte[] fromUint8Array(Uint8Array data);

	private static IDBDatabase db = null;

	@Async
	public static native void initDb();

	public static void initDb(AsyncCallback<NullType> callback) {
		IDBOpenDBRequest req = IDBFactory.getInstance().open("lostcity", 1);

		req.setOnError(() -> {
			callback.error(new Exception("Error opening IndexedDB"));
		});

		req.setOnUpgradeNeeded(evt -> {
			IDBDatabase db = req.getResult();
			db.createObjectStore("cache"); // no need to create any indexes
		});

		req.setOnSuccess(() -> {
			db = req.getResult();
			callback.complete(null);
		});
	}

	@Async
	public static native byte[] getFile(String name);

	public static void getFile(String name, AsyncCallback<byte[]> callback) {
		if (db == null) {
			callback.error(new Exception("Database not initialized"));
			return;
		}

		IDBTransaction tx = db.transaction("cache", IDBDatabase.TRANSACTION_READWRITE);
		tx.setOnError(() -> {
			callback.error(new Exception("Error reading from IndexedDB"));
		});

		IDBObjectStore store = tx.objectStore("cache");
		IDBGetRequest rx = store.get(JSString.valueOf(name));
		rx.setOnError(() -> {
			callback.error(new Exception("Error reading from IndexedDB"));
		});

		rx.setOnSuccess(() -> {
			Uint8Array data = (Uint8Array) rx.getResult();

			if (data != null) {
				callback.complete(fromUint8Array(data));
			} else {
				callback.complete(null);
			}
		});
	}

	@Async
	public static native void putFile(String name, byte[] data);

	public static void putFile(String name, byte[] data, AsyncCallback<NullType> callback) {
		if (db == null) {
			callback.error(new Exception("Database not initialized"));
			return;
		}

		IDBTransaction tx = db.transaction("cache", IDBDatabase.TRANSACTION_READWRITE);
		tx.setOnError(() -> {
			callback.error(new Exception("Error writing to IndexedDB"));
		});

		IDBObjectStore store = tx.objectStore("cache");
		IDBRequest rx = store.put(getUint8Array(data), JSString.valueOf(name));
		rx.setOnError(() -> {
			callback.error(new Exception("Error writing to IndexedDB"));
		});

		rx.setOnSuccess(() -> {
			callback.complete(null);
		});
	}

}
