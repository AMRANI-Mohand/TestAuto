package appiumtests;

import io.appium.java_client.MobileBy;

/**
 * Ce test ouvre journeys avec le formulaire et v�rifie les composants cach�s 
 * 
 * @author mamrani
 *
 */
public class A_HiddenComponent extends A_AbstractJourneysTest {
	
	public static void main(String[] args) {
		System.out.println("Hello, we're going to check the greyed components in the formulary");

		try {
			openJourney();
			continueWithFormulary();
			hidden_component();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void hidden_component() throws Exception {

		driver.findElement(MobileBy.id(String.format(thePath,"frf_departure_text"))).click();
		try {
			driver.findElement(MobileBy.id(String.format(thePath,"frf_result_inverter"))).isDisplayed();
			driver.findElement(MobileBy.id(String.format(thePath,"frf_search_button"))).isDisplayed();
		} catch (Exception e) {
			System.out.println("The reverse and search button are hidden");
		}

		driver.findElement(MobileBy.id(String.format(thePath,"fra_arrival_text"))).click();
		try {
			driver.findElement(MobileBy.id(String.format(thePath,"frf_result_inverter"))).isDisplayed();
			driver.findElement(MobileBy.id(String.format(thePath,"frf_search_button"))).isDisplayed();
		} catch (Exception e) {
			System.out.println("The reverse and search button are hidden");
		}
	}
}
