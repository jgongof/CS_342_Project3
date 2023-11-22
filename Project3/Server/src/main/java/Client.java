import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.Locale;
import java.util.function.Consumer;

public class Client {
	Socket socketPlayer;
	Clientele player;
	ObjectOutputStream out;
	ObjectInputStream in;
	private Consumer<Serializable> callback;
	int port;

	Client(Consumer<Serializable> call, int port){

		callback = call;
		this.port = port;
		player = new Clientele();
		player.start();
	}

	public void message(String message)
	{
		try{
			out.writeObject(message);
		}catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public class Clientele extends Thread{

		public void run() {

			try {
				socketPlayer= new Socket("127.0.0.1",port);
				out = new ObjectOutputStream(socketPlayer.getOutputStream());
				in = new ObjectInputStream(socketPlayer.getInputStream());
				socketPlayer.setTcpNoDelay(true);
			}
			catch(Exception e) {}

			while(true) {

				try {
					String message = in.readObject().toString();
					System.out.println("Player Recieved Something From Server.");
					callback.accept(message);
				}
				catch(Exception e) {}
			}

		}
	}
}
