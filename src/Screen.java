
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Screen {
	private JFrame frame;
	private final String title="Let's Chat";
	private int WIDTH=400,HEIGHT=600;
	private JPanel connection_info, sending_panel,reception_panel;
	private JTextField IP_Address,Port_Number,userInfo,serverPortField;
	private JLabel port_number,IP_Info,username,connection_Status,serverLabel;
	private JButton send_button,connect_button,connectToServerButton;
	private JTextArea reception_info,sending_info;
	
	public Screen(){
		
	}
	
	public void display(){
		frame=new JFrame(title);
		frame.setMinimumSize(new Dimension(WIDTH,HEIGHT));
		frame.setMaximumSize(new Dimension(WIDTH*2,HEIGHT+(HEIGHT/2)));
		frame.setLocationRelativeTo(null);
		setup_connection_info_panel();
		frame.getContentPane().add(BorderLayout.NORTH,connection_info);
		setup_reception_panel();
		frame.getContentPane().add(reception_panel);
		setup_sending_panel();
		frame.getContentPane().add(BorderLayout.SOUTH,sending_panel);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	private void setup_connection_info_panel(){ // setting up the connection panel 
		connection_info=new JPanel();
		connection_Status=new JLabel();
		Font font=new Font("Times New Roman",Font.BOLD,14);
		IP_Info=new JLabel("IP ADDRESS:");
		IP_Address=new JTextField(6);
		port_number=new JLabel("PORT:");
		Port_Number=new JTextField(4);
		connect_button=new JButton("Connect");
		username=new JLabel("Username:");
		userInfo=new JTextField(23);
		
		serverLabel=new JLabel("Enter server port #: ");
		serverLabel.setFont(font);
		serverLabel.setForeground(Color.WHITE);
		serverPortField=new JTextField(5);
		connectToServerButton=new JButton("Connect server");
		
		
		
		connection_Status.setFont(font);
		connection_Status.setForeground(Color.WHITE);
		IP_Info.setForeground(Color.WHITE);
		connection_info.setPreferredSize(new Dimension(WIDTH,125));
		connection_info.setBackground(Color.BLACK);
		port_number.setForeground(Color.WHITE);
		username.setFont(font);
		username.setForeground(Color.WHITE);
		userInfo.setFont(font);
		
		connection_info.add(serverLabel);
		connection_info.add(serverPortField);
		connection_info.add(connectToServerButton);
		
		connection_info.add(IP_Info);
		connection_info.add(IP_Address);
		connection_info.add(port_number);
		connection_info.add(Port_Number);
		connection_info.add(connect_button);
	
		connection_info.add(username);
		connection_info.add(userInfo);
		connection_info.add(connection_Status);
		
		
		
	}
	private void setup_sending_panel(){ //Setting up the user panel in order to send message
		sending_panel=new JPanel();
		sending_info=new JTextArea();
		Font font=new Font("Times New Roman",Font.BOLD,14);
		send_button=new JButton("SEND");
		send_button.setPreferredSize(new Dimension(80,100));
		sending_info.setBackground(Color.WHITE);
		Border border=BorderFactory.createLineBorder(Color.BLUE);
		sending_info.setBorder(border);
		sending_info.setFont(font);
		sending_info.setBorder(BorderFactory.createCompoundBorder(sending_info.getBorder(),BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		sending_info.setPreferredSize(new Dimension(WIDTH-100,100));
		sending_panel.setPreferredSize(new Dimension(WIDTH,110));
		sending_panel.setBackground(Color.BLACK);
		sending_panel.add(sending_info);
		sending_panel.add(send_button);
	}
	
	private void setup_reception_panel(){ //Setting up the display message panel for all received messages
		reception_panel=new JPanel();
		reception_info=new JTextArea();
		reception_info.setBackground(Color.WHITE);
		Font font=new Font("Verdanan",Font.BOLD,12);
		Border border=BorderFactory.createLineBorder(Color.BLUE);
		reception_info.setFont(font);
		reception_info.setBorder(border);
		reception_info.setFocusable(false);
		reception_info.setBorder(BorderFactory.createCompoundBorder(reception_info.getBorder(),BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		reception_info.setPreferredSize(new Dimension(WIDTH-40,HEIGHT/3));
		JScrollPane scroller=new JScrollPane(reception_info);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		reception_panel.setPreferredSize(new Dimension(WIDTH,(HEIGHT/3)+10));
		reception_panel.setBackground(Color.BLACK);
		reception_panel.add(scroller);
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}

	public JPanel getConnection_info() {
		return connection_info;
	}

	public void setConnection_info(JPanel connection_info) {
		this.connection_info = connection_info;
	}

	public JPanel getSending_panel() {
		return sending_panel;
	}

	public void setSending_panel(JPanel sending_panel) {
		this.sending_panel = sending_panel;
	}

	public JPanel getReception_panel() {
		return reception_panel;
	}

	public void setReception_panel(JPanel reception_panel) {
		this.reception_panel = reception_panel;
	}

	public JTextField getIP_Address() {
		return IP_Address;
	}

	public void setIP_Address(JTextField iP_Address) {
		IP_Address = iP_Address;
	}

	public JTextField getPort_Number() {
		return Port_Number;
	}

	public void setPort_Number(JTextField port_Number) {
		Port_Number = port_Number;
	}

	public JLabel getPort_number() {
		return port_number;
	}

	public void setPort_number(JLabel port_number) {
		this.port_number = port_number;
	}

	public JLabel getIP_Info() {
		return IP_Info;
	}

	public void setIP_Info(JLabel iP_Info) {
		IP_Info = iP_Info;
	}

	public JLabel getConnection_Status() {
		return connection_Status;
	}

	public void setConnection_Status(JLabel connection_Status) {
		this.connection_Status = connection_Status;
	}

	public JButton getSend_button() {
		return send_button;
	}

	public void setSend_button(JButton send_button) {
		this.send_button = send_button;
	}

	public JButton getConnect_button() {
		return connect_button;
	}

	public void setConnect_button(JButton connect_button) {
		this.connect_button = connect_button;
	}

	public JTextArea getReception_info() {
		return reception_info;
	}

	public void setReception_info(JTextArea reception_info) {
		this.reception_info = reception_info;
	}

	public JTextArea getSending_info() {
		return sending_info;
	}

	public void setSending_info(JTextArea sending_info) {
		this.sending_info = sending_info;
	}

	public JTextField getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(JTextField userInfo) {
		this.userInfo = userInfo;
	}

	public JTextField getServerPortField() {
		return serverPortField;
	}

	public void setServerPortField(JTextField serverPortField) {
		this.serverPortField = serverPortField;
	}

	public JButton getConnectToServerButton() {
		return connectToServerButton;
	}

	public void setConnectToServerButton(JButton connectToServerButton) {
		this.connectToServerButton = connectToServerButton;
	}

	
	

}
