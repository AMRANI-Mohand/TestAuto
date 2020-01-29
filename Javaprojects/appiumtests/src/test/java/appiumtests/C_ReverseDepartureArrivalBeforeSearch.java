package appiumtests;

import io.appium.java_client.MobileBy;

/**
 * Ce test ouvre journeys avec le formulaire et inverse le départ et l'arrivée avant qu'on fait une recherche d'itinéraire 
 * 
 * @author mamrani
 *
 */
public class C_ReverseDepartureArrivalBeforeSearch extends B_DoSimpleItinerarySearch_DepartureArrival {                                 

	public static void main(String[] args) {
		System.out.println("Hello, we're going to reverse the departure and arrival before the itinerary search");

		try {
			openJourney();
			continueWithFormulary();
			ReverseThenSearch();
			clickOnSearch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void ReverseThenSearch() throws Exception {

		FillInTheDepartureBeforeArrival();
		FillInTheArrivalFieldAfterDeparture();

		Thread.sleep(3000);

		driver.findElement(MobileBy.id(String.format(thePath,"frf_result_inverter"))).click();
	}
	
}
