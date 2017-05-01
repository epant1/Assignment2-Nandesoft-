package melbourneweathermodels;

import melbourneweather2.ExceptionException;
import melbourneweather2.MelbourneWeather2Stub;
import melbourneweather2.MelbourneWeather2Stub.GetLocationsResponse;

public class Locations {
	
	private String[] listOfLocations;
	
	public String[] getListOfLocations() {
		return listOfLocations;
	}

	public void setListOfLocations(String[] listOfLocations) {
		this.listOfLocations = listOfLocations;
	}
	
	// get locations from webService 
	public void downloadLocations() throws Exception, ExceptionException{
		final MelbourneWeather2Stub webService = new MelbourneWeather2Stub();
		GetLocationsResponse locations = webService.getLocations();
		setListOfLocations(locations.get_return());
		
	}

}
