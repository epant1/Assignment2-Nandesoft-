package melbourneweatherfactory;

import melbourneweathermodels.Temperature;

public class TemperatureFactory implements  WeatherFactory {

	public Weather getWeather() {
		// TODO Auto-generated method stub
		return (Weather) new Temperature();
	}

	
}
