
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private Socket socket;
	private BufferedReader input;
	private PrintWriter output;
	private String hostname;
	private int port;
	private String connecttionStatus;
	private Screen screen;

	public Client() {
		screen = new Screen();
		screen.display();
		screen.getConnection_Status().setText("Not connected");
		listenForEvents();
		connect(hostname, port);
		Thread readerThread = new Thread(new IncomingMessage());
		readerThread.start();

	}

	public void listenForEvents() {
		screen.getSend_button().addActionListener(new Message());
		screen.getConnect_button().addActionListener(new Connection());
	}

	public void connect(String host, int port) {
		try {
			socket = new Socket(host, port);
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream());
			System.out.println("Networking established");
			screen.getConnection_Status().setText("Connected");

		} catch (IOException ex) {
			screen.getConnection_Status().setText("Connection failed!");
			System.out.println("Error "+ex);
		}
	}

	public class Message implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (screen.getConnection_Status().getText().equals("Connected")) {
				String message=screen.getSending_info().getText();
				if(message.length()>0 && message!=null){
					try {
						output.println(formatUsername() + ": " + message);
						output.flush();
					} catch (Exception ex) {
						System.out.println("Error "+ex);
					}
					screen.getSending_info().setText("");
					screen.getSending_info().requestFocus(true);
				}
				
			}
		}

	}

	public class Connection implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (screen.getConnect_button().getText().equals("Connect")) {
				hostname = screen.getIP_Address().getText();
				port = Integer.parseInt(screen.getPort_Number().getText());
				connect(hostname, port);
				Thread readerThread = new Thread(new IncomingMessage());
				readerThread.start();
				screen.getConnect_button().setText("Disconnect");
			} else {
				try {
					socket.close();
					screen.getConnection_Status().setText("Not connected");
					screen.getConnect_button().setText("Connect");
				} catch (IOException ex) {
					System.out.println("Error "+ex);
				}
			}
		}

	}

	public class IncomingMessage implements Runnable {

		@Override
		public void run() {
			String message;
			try {
				while ((message = input.readLine()) != null) {
					System.out.println("Read" + message);
					screen.getReception_info().append(message + "\n");
				}
			} catch (Exception ex) {
				System.out.println("Error "+ex);
			}
		}

	}

	public String formatUsername() {
		String username = screen.getUserInfo().getText();
		if (username == null || username.length() == 0) {
			username = "UI User";
		} else if (username.length() > 10) {
			username = username.substring(0, 10);
		} 
		return username.substring(0, 1).toUpperCase() + username.substring(1, username.length());
	}

	public String getConnecttionStatus() {
		return connecttionStatus;
	}

	public void setConnecttionStatus(String connecttionStatus) {
		this.connecttionStatus = connecttionStatus;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	
	
}
