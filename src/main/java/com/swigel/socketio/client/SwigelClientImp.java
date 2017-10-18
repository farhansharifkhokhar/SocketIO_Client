package com.swigel.socketio.client;

import java.net.URI;
import java.net.URISyntaxException;

import io.socket.client.Ack;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class SwigelClientImp extends Connection {

	// Logger logger = LoggerFactory.getLogger(this.getClass());

	private Socket socket;

	public String getTopsSocketResponse() {

		try {

			URI uri = new URI("https://ws-api.iextrading.com/1.0/tops");

			IO.Options opts = new IO.Options();
			opts.path = "socket.io-client";
			opts.reconnection = true;
			opts.upgrade = true;
			opts.secure = true;
			socket = IO.socket(uri, opts);
			socket = client();
			socket.open().connect().emit("subscribe", "firehose", new Ack() {

				@Override
				public void call(Object... args) {
					System.out.println("Connected");
				}
			});
			socket.connect().emit("subscribe", "firehose", new Ack() {

				@Override
				public void call(Object... args) {
					System.out.println("Connected");
				}
			});

			socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

				@Override
				public void call(Object... arg0) {
					// logger.info("Connected");

					System.out.println("Connected");
					socket.emit("subscribe", "firehose");
					socket.connect();
				}
			});

			socket.connect();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}
}
