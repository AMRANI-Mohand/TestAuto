package appiumtests;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class Z_SaveTests2 {

	static AppiumDriver<MobileElement> driver; // Utiliser le driver de Appium

	public static void main(String[] args) { // The main function
		try {
			openJourney();

			 Fill_in_the_departure_field();

			// Fill_in_the_arrival_field();

			// Fill_in_the_departure_and_arrival_field();

			// itinerary_search();

			// reverse_then_search();

			// search_then_reverse();

			// departure_delete_button();

			// arrival_delete_button();

			// find_transport_mode();

			// click_on_transport_mode();

			// greyed_component();

			// hidden_component();

			//componenets_selected_by_default();

		} catch (Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	static MobileElement getElementById(String... ids) {
		MobileElement element = null;
		for (String id : ids) {
			if (element == null) {
				element = driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/" + id));
			} else {
				element = element.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/" + id));
			}
		}
		return element;
	}

	static void openJourney() throws Exception { // start the application
		DesiredCapabilities cap = new DesiredCapabilities();				
		cap.setCapability("autoGrantPermissions", "true"); // always allow all permissions your app wants

		cap.setCapability("deviceName", "Galaxy S9"); // phone capabilities
		cap.setCapability("udid", "2b8a0ac836037ece");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9");

		cap.setCapability("appPackage", "org.kisio.sample.navitia.sdk.ui"); // application capabilities
		cap.setCapability("appActivity", "org.kisio.sample.navitia.sdk.ui.MainActivity");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap); // send this capabilities to the appium server and we have
															// to pass the url server
		System.out.println("Application Started....");
	}

	static void greyed_component() throws Exception {
		gotoFormulary();

		if (!driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/frf_result_inverter")).isEnabled()
				&& !driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/frf_search_button"))
						  .isEnabled()) {
			System.out.println("The reverse and search button are grayed, you have to set the departure and arrival point");
		}
	}

	static void hidden_component() throws Exception {
		gotoFormulary();

		driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/frf_departure_text")).click();
		try {
			driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/frf_result_inverter")).isDisplayed();
			driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/frf_search_button")).isDisplayed();
		} catch (Exception e) {
			System.out.println("The reverse and search button are hidden");
		}

		driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/fra_arrival_text")).click();
		try {
			driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/frf_result_inverter")).isDisplayed();
			driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/frf_search_button")).isDisplayed();
		} catch (Exception e) {
			System.out.println("The reverse and search button are hidden");
		}
	}

	static void gotoFormulary() throws Exception {
		driver.findElement(By.id("org.kisio.sample.navitia.sdk.ui:id/switch_configuration_form")).click();

		Thread.sleep(4000);

		driver.findElement(By.id("org.kisio.sample.navitia.sdk.ui:id/button_configuration")).click();
	}

	static void Fill_in_the_departure_field() throws Exception {

		gotoFormulary();

		getElementById("frf_departure_text").click();
		getElementById("fra_departure_text", "edit_text_input").setValue("paris ga");

		Thread.sleep(3000);

		driver.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"Arr�t Gare de Lyon (Paris)\"]"))
				.click();
	}

	static void Fill_in_the_arrival_field() throws Exception {

		gotoFormulary();

		driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/frf_arrival_text")).click();
		driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/fra_arrival_text"))
				.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/edit_text_input")).setValue("repub");

		Thread.sleep(3000);

		driver.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"Arr�t R�publique (Paris)\"]"))
				.click();
	}

	static void Fill_in_the_departure_and_arrival_field() throws Exception {

		gotoFormulary();

		driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/frf_departure_text")).click();
		driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/fra_departure_text"))
				.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/edit_text_input")).setValue("paris ga");

		Thread.sleep(3000);

		// List <MobileElement> listElements = (List<MobileElement>)
		// driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/fra_result_recycler"));
		// int count = listElements.size();
		// listElements.get(2).click();
		driver.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"Arr�t Gare de Lyon (Paris)\"]"))
				.click();

		Thread.sleep(3000);

		driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/fra_arrival_text"))
				.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/edit_text_input")).setValue("repub");

		Thread.sleep(3000);

		driver.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"Arr�t R�publique (Paris)\"]"))
				.click();
	}

	static void itinerary_search() throws Exception {

		Fill_in_the_departure_and_arrival_field();
		Thread.sleep(3000);
		driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/frf_search_button")).click();
	}

	static void reverse_then_search() throws Exception {

		Fill_in_the_departure_and_arrival_field();

		Thread.sleep(3000);

		driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/frf_result_inverter")).click();
		driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/frf_search_button")).click();
	}

	static void search_then_reverse() throws Exception {

		Fill_in_the_departure_and_arrival_field();

		Thread.sleep(3000);

		driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/frf_search_button")).click();

		Thread.sleep(4000);

		driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/frj_result_inverter")).click();

	}

	static void departure_delete_button() throws Exception {

		Fill_in_the_departure_field();
		driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/fra_departure_text"))
				.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/edit_text_input")).click();
		driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/image_button_clear")).click();

	}

	static void arrival_delete_button() throws Exception {

		Fill_in_the_arrival_field();
		driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/fra_arrival_text"))
				.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/edit_text_input")).click();
		driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/image_button_clear")).click();

	}

/*
	static void find_transport_mode() throws Exception {

		gotoFormulary();
		driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/vps_recycler"))
				.findElement(MobileBy.xpath("//android.widget.ImageView[@content-desc=\"Bus\"]"));
		driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/vps_recycler"))
				.findElement(MobileBy.xpath("//android.widget.ImageView[@content-desc=\"V�lo\"]"));
		driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/vps_recycler"))
				.findElement(MobileBy.xpath("//android.widget.ImageView[@content-desc=\"V�lo en libre service\"]"));
		driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/vps_recycler"))
				.findElement(MobileBy.xpath("//android.widget.ImageView[@content-desc=\"Voiture\"]"));

		System.out.println("Bus, bike, VLS and car are available on transport_mode");
	}

	static void componenets_selected_by_default() throws Exception {
		gotoFormulary();

		if (driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/vps_recycler"))
				.findElement(MobileBy.xpath("//android.widget.ImageView[@content-desc=\"Bus\"]")).isSelected()

				&& driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/vps_recycler"))
						.findElement(MobileBy.xpath("//android.widget.ImageView[@content-desc=\"V�lo\"]")).isSelected()

				&& driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/vps_recycler"))
						.findElement(
								MobileBy.xpath("//android.widget.ImageView[@content-desc=\"V�lo en libre service\"]"))
						.isSelected()

				&& driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/vps_recycler"))
						.findElement(MobileBy.xpath("//android.widget.ImageView[@content-desc=\"Voiture\"]"))
						.isSelected()) {
			System.out.println("The Bus, bike, VLS car transport mode and Departure button are selected");
		}
	}

	static void click_on_transport_mode() throws Exception {

		gotoFormulary();

		driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/vps_recycler"))
				.findElement(MobileBy.xpath("//android.widget.ImageView[@content-desc=\"Bus\"]")).click();

		if (!driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/vps_recycler"))
				.findElement(MobileBy.xpath("//android.widget.ImageView[@content-desc=\"Bus\"]")).isSelected()) {
			System.out.println("The Bus transport mode is deselected");
		}

		driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/vps_recycler"))
				.findElement(MobileBy.xpath("//android.widget.ImageView[@content-desc=\"V�lo\"]")).click();

		if (!driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/vps_recycler"))
				.findElement(MobileBy.xpath("//android.widget.ImageView[@content-desc=\"V�lo\"]")).isSelected()) {
			System.out.println("The Bike transport mode is deselected");
		}

		driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/vps_recycler"))
				.findElement(MobileBy.xpath("//android.widget.ImageView[@content-desc=\"V�lo en libre service\"]"))
				.click();

		if (!driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/vps_recycler"))
				.findElement(MobileBy.xpath("//android.widget.ImageView[@content-desc=\"V�lo en libre service\"]"))
				.isSelected()) {
			System.out.println("The VLS transport mode is deselected");
		}

		driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/vps_recycler"))
				.findElement(MobileBy.xpath("//android.widget.ImageView[@content-desc=\"Voiture\"]")).click();

		if (driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/vps_recycler"))
				.findElement(MobileBy.xpath("//android.widget.ImageView[@content-desc=\"Voiture\"]")).isSelected()) {
			System.out.println("The car transport mode is selected");
		}
	}
*/
}

/*
 * Boolean isSelected(): This method determines if an element is selected or
 * not. It returns true if the element is selected and false if it is not. It is
 * widely used on check boxes, radio buttons and options in a select. Boolean
 * isDisplayed(): This method determines if an element is displayed or not. It
 * returns true if the element is displayed and false if it is not. Advantage of
 * this method is that it avoids parsing an elements style attribute. Boolean
 * isEnabled(): This method determines if an element is enabled or not. It
 * returns true if element is enabled (All elements apart from disabled input
 * elements) and false if otherwise.
 */
