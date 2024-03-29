package appiumtests;

import io.appium.java_client.MobileBy;

/**
 * Ce test ouvre journeys avec le formulaire et remplie les champs de saisies
 * @author mamrani
 *
 */
public class Z_JourneysTest_Scenario3 extends A_AbstractJourneysTest {

	public static void main(String[] args) {
		System.out.println("Hello scenario 1");
		
		try {
			openJourney();
			gotoFormulary();
			Fill_in_the_departure_field();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Active le formulaire et lance le formulaire
	 * @throws Exception
	 */
	static void gotoFormulary() throws Exception {
		getElementById("switch_configuration_form").click();

		Thread.sleep(4000);

		getElementById("button_configuration").click();
	}

	/**
	 * Ouverture de l'auto-completion et saisie du champs d�part
	 * @throws Exception
	 */
	static void Fill_in_the_departure_field() throws Exception {

		getElementById("frf_departure_text").click();
		getElementById("fra_departure_text", "edit_text_input").setValue("paris ga");

		Thread.sleep(3000);

		driver.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"Arr�t Gare de Lyon (Paris)\"]"))
				.click();
	}
}
