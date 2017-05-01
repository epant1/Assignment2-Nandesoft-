package melbourneweatherfactory;

public class WeatherTypeSelector {

	public static WeatherFactory selectWeatherType(String choice) {
		// TODO Auto-generated method stub
			if("Rainfall".equalsIgnoreCase(choice)){
				return new RainfallFactory();
			}else if("Temperature".equalsIgnoreCase(choice)){
				return new TemperatureFactory();
			}
		return null;
	}

}
