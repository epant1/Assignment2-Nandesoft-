package melbourneweatherfactory;

import melbourneweather2.MelbourneWeather2Stub.GetRainfallResponse;
import melbourneweather2.MelbourneWeather2Stub.GetTemperatureResponse;
import java.lang.Exception;

public interface Weather {
	
	public GetRainfallResponse getRainfall(String location) throws Exception;
	public GetTemperatureResponse getTemperature  (String location) throws Exception;
}
