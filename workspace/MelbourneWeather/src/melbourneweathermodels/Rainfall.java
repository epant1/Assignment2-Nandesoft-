package melbourneweathermodels;

import melbourneweather2.MelbourneWeather2Stub;
import melbourneweather2.MelbourneWeather2Stub.*;
import melbourneweatherfactory.Weather;
import melbourneweatherobserver.Observer;
import melbourneweatherobserver.WeatherObserver;

import java.lang.Exception;
import java.util.ArrayList;
import java.util.List;

public class Rainfall implements Weather, WeatherObserver {
	
	private GetRainfall request;
	private GetRainfallResponse requestResponse;
	private List<Observer> listOfRainfallObservers = new ArrayList<Observer>();
	
	@Override
	public GetRainfallResponse getRainfall(String location) throws Exception {
		// TODO Auto-generated method stub
		final MelbourneWeather2Stub webService = new MelbourneWeather2Stub();
		request = new GetRainfall();
		request.setLocation(location);
		requestResponse = webService.getRainfall(request);
		
		return requestResponse;
	}

	@Override
	public GetTemperatureResponse getTemperature(String location) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setWeatherObserver(Observer observer) {
		// TODO Auto-generated method stub
		listOfRainfallObservers.add(observer);
	}

	@Override
	public void removeWeatherObserver(Observer observer) {
		// TODO Auto-generated method stub
		listOfRainfallObservers.remove(observer);
	} 

	@Override
	public void sendWeatherUpdates(Observer observer) throws Exception {
		// TODO Auto-generated method stub
		for(Observer obsv: listOfRainfallObservers){
			obsv.updatedMonitor();
		}
	}

	public List<Observer> getListOfRainfallObservers() {
		return listOfRainfallObservers;
	}

	public void setListOfRainfallObservers(List<Observer> listOfRainfallObservers) {
		this.listOfRainfallObservers = listOfRainfallObservers;
	}
	
}
