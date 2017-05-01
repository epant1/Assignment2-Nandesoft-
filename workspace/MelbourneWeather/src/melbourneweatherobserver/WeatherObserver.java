package melbourneweatherobserver;

public interface WeatherObserver {
	public void setWeatherObserver(Observer observer);
	public void removeWeatherObserver(Observer observer);
	abstract void sendWeatherUpdates(Observer observer) throws Exception;

}
  