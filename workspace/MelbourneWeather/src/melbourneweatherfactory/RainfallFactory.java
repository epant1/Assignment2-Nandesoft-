package melbourneweatherfactory;

import melbourneweathermodels.Rainfall;

public class RainfallFactory implements WeatherFactory{

	public Weather getWeather() {
		// TODO Auto-generated method stub
		return (Weather) new Rainfall();
	}


}
