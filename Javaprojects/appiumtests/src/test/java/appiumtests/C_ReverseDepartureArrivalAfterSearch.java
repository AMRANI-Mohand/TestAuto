package appiumtests;

import io.appium.java_client.MobileBy;

/**
 * Ce test ouvre journeys avec le formulaire et inverse le départ et l'arrivée après avoir fait une recherche d'itinéraire
 * 
 * @author mamrani
 *
 */
public class C_ReverseDepartureArrivalAfterSearch extends C_ReverseDepartureArrivalBeforeSearch {                              

	public static void main(String[] args) {
		System.out.println("Hello, we're going to reverse the departure and arrival after the itinerary search");

		try {
			openJourney();
			continueWithFormulary();
			ReverseThenSearch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void ReverseThenSearch() throws Exception {

		FillInTheDepartureBeforeArrival();
		FillInTheArrivalFieldAfterDeparture();
		clickOnSearch();

		Thread.sleep(4000);

		driver.findElement(MobileBy.id(String.format(thePath,"frj_result_inverter"))).click();
	}
	
}
