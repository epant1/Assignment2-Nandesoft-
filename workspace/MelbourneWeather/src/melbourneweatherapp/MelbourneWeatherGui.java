package melbourneweatherapp;

import java.awt.*;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.*;

import javafx.event.ActionEvent;
import melbourneweathermodels.Locations;
import melbourneweathermodels.Rainfall;
import melbourneweathermodels.Temperature;
import melbourneweatherobserver.Monitor;

public class MelbourneWeatherGui extends JFrame {
	
	private JLabel lblLocation;
	private JComboBox<String> jcLocations; // Remind:create a class arraylist to hold the locations
	private JCheckBox chbViewTemp, chbViewRainfall;
	private JButton btnDisplay;
	private Container container;
	private GridLayout mainLayout;
	private JPanel panel1, panel2, panel3;
	private ActionListener chbListener;
	private String selectedChb;
	//private Locations locations = new Locations();
	
	// Constructor
	public MelbourneWeatherGui(Locations locations){
		
		lblLocation = new JLabel("List of available Locations");
		jcLocations = new JComboBox<String>();
		chbViewTemp = new JCheckBox("View Temperature");
		chbViewRainfall = new JCheckBox("View Rainfall");
		btnDisplay = new JButton("Display Weather Monitor");
		container = getContentPane();
		mainLayout = new GridLayout();
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		chbListener = new ChbHandler();
		
		createGui();
		jcLocationsSet(locations.getListOfLocations());
		
		//Display button listener
		btnDisplay.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==btnDisplay){
					
					if(selectedChb==null){
						JOptionPane.showMessageDialog(null, "Please select type of weather", "Alert: " + "Unselected checkBox(es)", JOptionPane.INFORMATION_MESSAGE);
					}else{
						try {
							Monitor monitor=new Monitor(jcSelectedLocation(),selectedChb);
							Timer timer = new Timer();
							Rainfall rainfallObserver = new Rainfall();
							Temperature tempObserver = new Temperature();
							
							rainfallObserver.setWeatherObserver(monitor);
							tempObserver.setWeatherObserver(monitor);
			

							timer.schedule(monitor, 0, 5000);
							
							MonitorGui xd = new MonitorGui(monitor);
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				}
			}
		});
		
		//adding listener to checBoxes
		chbViewTemp.addActionListener(chbListener);
		chbViewRainfall.addActionListener(chbListener);
	}
	//checkBoxes listener building
	class ChbHandler implements ActionListener{

		@Override
		public void actionPerformed(java.awt.event.ActionEvent e) {
			// TODO Auto-generated method stub
			selectedChb= null;
			
			JCheckBox chbEvent = (JCheckBox) e.getSource();
			if(chbEvent.isSelected()){
				
				if(chbEvent==chbViewTemp && (chbViewRainfall.isSelected()==false)){
					selectedChb="Temperature";
				}else if(chbEvent==chbViewRainfall && (chbViewTemp.isSelected()==false)){
					selectedChb="Rainfall";
				}else if(chbViewRainfall.isSelected() && chbViewTemp.isSelected()){
					selectedChb="both";
				}
			}
		}
	}
	//add content to comboBox
	public void jcLocationsSet(String[] list){
		jcLocations.setMaximumRowCount(list.length);
		for(String location: list){
			jcLocations.addItem(location);
			
		}
	}
	// get comboBox selectedItem 
	public String jcSelectedLocation(){
		return (String) jcLocations.getSelectedItem();
	}
	
	// creates user interface 
	public void createGui(){
		
		mainLayout = new GridLayout(3,0);
		container = getContentPane();
		
		panel1.setLayout(new FlowLayout());
		panel1.add(lblLocation);
		panel1.add(jcLocations);
		
		panel2.setLayout(new FlowLayout());
		panel2.add(chbViewTemp);
		panel2.add(chbViewRainfall);
		
		panel3.setLayout(new FlowLayout());
		panel3.add(btnDisplay);
		
		setTitle("Melbourne Weather Application!");
		setSize(600,400);
		container.setLayout(mainLayout);
		container.add(panel1);
		container.add(panel2);
		container.add(panel3);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
