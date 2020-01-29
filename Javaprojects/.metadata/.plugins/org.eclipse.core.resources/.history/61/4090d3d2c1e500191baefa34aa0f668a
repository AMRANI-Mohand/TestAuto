package appiumtests;

import io.appium.java_client.MobileBy;

/**
 * Ce test ouvre journeys avec le formulaire et vérifie les composants grisés  
 * 
 * @author mamrani
 *
 */
public class A_GreyedComponent extends A_AbstractJourneysTest {
	
	public static void main(String[] args) {
		System.out.println("Hello, we're going to check the greyed components in the formulary");

		try {
			openJourney();
			continueWithFormulary();
			greyed_component();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void greyed_component() throws Exception {
		if (!driver.findElement(MobileBy.id(String.format(thePath,"frf_result_inverter"))).isEnabled()
				&& !driver.findElement(MobileBy.id(String.format(thePath,"frf_search_button")))
						  .isEnabled()) {
			System.out.println("The reverse and search button are grayed, you have to set the departure and arrival point");
		}

}
}
