package melbourneweatherapp;

import java.lang.Exception;

import melbourneweathermodels.Locations;

public class Driver{
	// set up some constants to index into the result arrays
	
		public static void main(String[] args) throws Exception {
			
			Locations cd = new Locations();
			cd.downloadLocations();
				
			MelbourneWeatherGui ui = new MelbourneWeatherGui(cd);
			ui.createGui();
	
		}



	}

