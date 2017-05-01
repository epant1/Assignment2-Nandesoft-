package melbourneweatherapp;

import java.awt.*;

import javax.swing.*;

import melbourneweatherobserver.Monitor;

public class MonitorGui extends JFrame {
	
	private JLabel lblDateAndTime, lblTemp, lblRainfall;
	private JLabel lblDateAndTimeR, lblTempR, lblRainfallR;
	private GridLayout mainLayout;
	private JPanel panel1, panel2, panel3;
	private Container container;
	
	public MonitorGui(Monitor monitor){
		
		container = getContentPane();
		mainLayout = new GridLayout();
		lblTemp = new JLabel("Temperature:");
		lblRainfall = new JLabel("Rainful:");
		lblDateAndTime = new JLabel("Date&Time:");
		lblDateAndTimeR = new JLabel("X");
		lblTempR = new JLabel("X");
		lblRainfallR = new JLabel("X");
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		
		createGui(monitor.getLocation());
		loadScreen(monitor);
	}
	// load data 
	public void loadScreen(Monitor current){
		
		System.out.println(current.getWeatherType());

		if(current.getWeatherType().equals("Rainfall")){
			panel2.setVisible(false);
			}else if(current.getWeatherType().equals("Temperature")){
				panel3.setVisible(false);
			}

		lblDateAndTimeR.setText(current.getRainfall(0)); // this is for the time
		lblRainfallR.setText(current.getRainfall(1)); // this for the temp/value of rainfall
		lblTempR.setText(current.getTemperature(1));
		
	}
	public void createGuiPersonalised(Panel panel, String location){
		
		panel1.setLayout(new FlowLayout());
		panel1.add(lblDateAndTime);
		panel1.add(lblDateAndTimeR);
		
		setTitle(location);
		setSize(250,150);
		mainLayout = new GridLayout(2,0);
		container = getContentPane();
		container.setLayout(mainLayout);
		
		container.add(panel1);
		container.add(panel);
		setLocationRelativeTo(null);
		setVisible(true);	
	}
	
	public void createGui(String location){
		
		panel1.setLayout(new FlowLayout());
		panel1.add(lblDateAndTime);
		panel1.add(lblDateAndTimeR);
		
		
		panel2.setLayout(new FlowLayout());
		panel2.add(lblTemp); 
		panel2.add(lblTempR);
		
		panel3.setLayout(new FlowLayout());
		panel3.add(lblRainfall);
		panel3.add(lblRainfallR);
		
		setTitle(location);
		setSize(250,150);
		mainLayout = new GridLayout(3,0);
		container = getContentPane();
		container.setLayout(mainLayout);
		container.add(panel1);
		container.add(panel2);
		container.add(panel3);
		setLocationRelativeTo(null);
		setVisible(true);	

				
	}

}
