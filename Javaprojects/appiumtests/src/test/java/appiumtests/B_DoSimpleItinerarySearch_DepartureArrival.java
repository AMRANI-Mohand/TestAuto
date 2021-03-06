package appiumtests;

import io.appium.java_client.MobileBy;

/**
 * Ce test ouvre journeys avec le formulaire et fait une recherche d'itin�raire en commen�ant de saisir le d�part
 * 
 * @author mamrani
 *
 */
public class B_DoSimpleItinerarySearch_DepartureArrival extends A_AbstractJourneysTest {                               

	public static void main(String[] args) {
		System.out.println("Hello, we're going to do a simple itinerary search starting with the departure");

		try {
			openJourney();
			continueWithFormulary();
			FillInTheDepartureBeforeArrival();
			FillInTheArrivalFieldAfterDeparture();
			clickOnSearch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Ouverture de l'auto-completion et saisie du champs d�part
	 * 
	 * @throws Exception
	 */
	static void FillInTheDepartureBeforeArrival() throws Exception {

		getElementById("frf_departure_text").click();
		getElementById("fra_departure_text").setValue("paris ga");

		Thread.sleep(4000);

		driver.findElement(MobileBy.xpath(String.format(theXpath,"Arr�t Gare de Lyon (Paris)\"]")))
			  .click();		
	}
	
	/**
	 * Saisie du champs arriv�e apr�s avoir saisi le d�part
	 * 
	 * @throws Exception
	 */
	
	static void FillInTheArrivalFieldAfterDeparture() throws Exception {
		
		getElementById("fra_arrival_text").setValue("repub");

		Thread.sleep(4000);

		driver.findElement(MobileBy.xpath(String.format(theXpath,"Arr�t R�publique (Paris)\"]")))
				.click();
	}
		
	static void clickOnSearch() throws Exception {
		getElementById("frf_search_button").click();
	}
}
