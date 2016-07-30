import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application {
	

	private  Server server;
	private  Client client;
	
	public Application() {
		
	}
	
	public void run(){
		client=new Client();
		server=new Server();
		client.getScreen().getConnectToServerButton().addActionListener(new Connection());
	}
	
	public  class Connection implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int port=Integer.parseInt(client.getScreen().getServerPortField().getText());
			server.starter(port);
			System.out.println("Connected");
			
		}
		
	}

}

