import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
	
	ArrayList clientOutputStreams;
	private int portNumber;
	public Server(){
	}

	public class ClientHandler implements Runnable {
		
		BufferedReader reader;
		Socket socket;

		public ClientHandler(Socket clientSocket) {
			try {
				socket = clientSocket;
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			} catch (Exception ex) {
				System.out.println("Error "+ex);
			}
		}

		@Override
		public void run() {
			String message;
			try {
				while ((message = reader.readLine()) != null) {
					System.out.println("Read " + message);
					tellEveryone(message);
				}
			} catch (Exception ex) {
				System.out.println("Error "+ex);
			}
		}
		
	}
	
	public void starter(int port){
		clientOutputStreams=new ArrayList();
		try{
			this.portNumber=port;
			ServerSocket serverSocket=new ServerSocket(portNumber);
			while(true){
				Socket clientSocket=serverSocket.accept();
				PrintWriter writer=new PrintWriter(clientSocket.getOutputStream());
				clientOutputStreams.add(writer);
				Thread t=new Thread(new ClientHandler(clientSocket));
				t.start();
				System.out.println("Got connection!");
			}
		}
		catch(Exception ex){
			System.out.println("Error "+ex);
		}
	}
	public void tellEveryone(String message){
		Iterator it=clientOutputStreams.iterator();
		while(it.hasNext()){
			try{
				PrintWriter writer=(PrintWriter) it.next();
				writer.println(message);
				writer.flush();
			}
			catch(Exception ex){
				System.out.println("Error "+ex);
			}
		}
	}

}
