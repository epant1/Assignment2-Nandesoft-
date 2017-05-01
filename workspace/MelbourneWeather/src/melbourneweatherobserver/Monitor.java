package melbourneweatherobserver;

import java.util.TimerTask;

import melbourneweatherfactory.WeatherFactory;
import melbourneweatherfactory.WeatherTypeSelector;

public class Monitor extends TimerTask implements Observer{
	
	private WeatherObserver  screenObserver;
	private String location;
	private String  weatherType;
	private String[] rainfall;
	private String[] temperature;
	private WeatherFactory factory;
	private int test= 0;
	
	
	// constructor 
	public Monitor(String location, String type) throws Exception{
		this.location = location;
		this.weatherType = type;
		weatherToDisplay(type, location);
		
	}
	// check what type 
	
	public String getRainfall(int index) {
		return rainfall[index];
	}

	public String getWeatherType() {
		return weatherType;
	}

	public String getTemperature(int index) {
		return temperature[index];
	}

	//factory to use
	public void weatherToDisplay(String weatherType, String location) throws Exception{
		
		if(!weatherType.equals("Both")){
			factory = WeatherTypeSelector.selectWeatherType(weatherType);
			displayBothTypes(location);
			
		}else {		
			switch(weatherType){	
			case "Rainfall": 
					this.rainfall = factory.getWeather().getRainfall(location).get_return();
			
			case "Temperature": 
					this.temperature = factory.getWeather().getTemperature(location).get_return();
				
			}
		}
		
	}
	public void displayBothTypes(String location) throws Exception{
		
		factory = WeatherTypeSelector.selectWeatherType("Rainfall");
		this.rainfall = factory.getWeather().getRainfall(location).get_return();
		
		factory = WeatherTypeSelector.selectWeatherType("Temperature");
		this.temperature = factory.getWeather().getTemperature(location).get_return();
		
	}

	
	public WeatherObserver getScreenObserver() {
		return screenObserver;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setScreenObserver(WeatherObserver screenObserver) {
		this.screenObserver = screenObserver;
	}

	public String getLocation() {
		return location;
	}
	
	// for the observer....
	@Override
	public void updatedMonitor() throws Exception {
		// TODO Auto-generated method stub
		
		String location = this.location;
		String type = this.weatherType;
		weatherToDisplay(type,location);
		test++;
		System.out.println("Monitor: "+this.location+" has been updated");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			updatedMonitor();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
