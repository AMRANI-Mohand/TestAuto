package appiumtests;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

abstract public class A_AbstractJourneysTest {

	public static AppiumDriver<MobileElement> driver; // Utiliser le driver de Appium
	
	public static String thePath = "org.kisio.sample.navitia.sdk.ui:id/%s"; //le %s c'est pour qu'il prend pas en concidération le " du la suite 
	public static String theXpath = "//android.view.ViewGroup[@content-desc=\"%s";	     
	
	public static void main(String[] args) { // The main function
		System.out.println("Hello abstract");
	}

	public static void openJourney() throws Exception { // start the application
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
		Thread.sleep(3000);
	}

	public static void continueWithFormulary() throws Exception {
		getElementById("switch_configuration_form").click();

		Thread.sleep(4000);

		getElementById("button_configuration").click();
	}

	public static void continueWithoutFormulary() throws Exception {
		getElementById("button_configuration").click();
	}
	
	public static MobileElement getElementById(String... ids) {
		MobileElement element = null;
		for (String id : ids) {
			if (element == null) {
				element = driver.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/"+id));
			} else {
				element = element.findElement(MobileBy.id("org.kisio.sample.navitia.sdk.ui:id/"+id));
			}
		}
		return element;
	}								

	public static void find_transport_mode() throws Exception {

		continueWithFormulary();
		getElementById("vps_recycler")
				.findElement(MobileBy.xpath(String.format(theXpath, "Bus\"]")));
		getElementById("vps_recycler")
		        .findElement(MobileBy.xpath(String.format(theXpath, "Vélo\"]")));
		getElementById("vps_recycler")
		        .findElement(MobileBy.xpath(String.format(theXpath,"Vélo en libre service\"]")));
		getElementById("vps_recycler")
				.findElement(MobileBy.xpath(String.format(theXpath,"Voiture\"]")));

		System.out.println("Bus, bike, VLS and car are available on transport_mode");
	}

	public static void componenents_selected_by_default() throws Exception {
		continueWithFormulary();

		if (getElementById("vps_recycler")
				.findElement(MobileBy.xpath(String.format(theXpath, "Bus\"]"))).isSelected()

				&& getElementById("vps_recycler")
				.findElement(MobileBy.xpath(String.format(theXpath, "Vélo\"]"))).isSelected()

				&& getElementById("vps_recycler")
				.findElement(MobileBy.xpath(String.format(theXpath,"Vélo en libre service\"]"))).isSelected()

				&& getElementById("vps_recycler")
				.findElement(MobileBy.xpath(String.format(theXpath,"Voiture\"]"))).isSelected()) 
		{
			System.out.println("The Bus, bike, VLS car transport mode and Departure button are selected");
		}
	}

	public static void click_on_transport_mode() throws Exception {

		continueWithFormulary();

		getElementById("vps_recycler")
		         .findElement(MobileBy.xpath(String.format(theXpath, "Bus\"]"))).click();

		if (!getElementById("vps_recycler")
				 .findElement(MobileBy.xpath(String.format(theXpath, "Bus\"]"))).isSelected()) {
			System.out.println("The Bus transport mode is deselected");
		}

		getElementById("vps_recycler")
		         .findElement(MobileBy.xpath(String.format(theXpath, "Vélo\"]"))).click();

		if (!getElementById("vps_recycler")
				 .findElement(MobileBy.xpath(String.format(theXpath, "Vélo\"]"))).isSelected()) {
			System.out.println("The Bike transport mode is deselected");
		}

		getElementById("vps_recycler")
		         .findElement(MobileBy.xpath(String.format(theXpath,"Vélo en libre service\"]"))).click();

		if (!getElementById("vps_recycler")
				 .findElement(MobileBy.xpath(String.format(theXpath,"Vélo en libre service\"]"))).isSelected()) {
			System.out.println("The VLS transport mode is deselected");
		}

		getElementById("vps_recycler")
		         .findElement(MobileBy.xpath(String.format(theXpath,"Voiture\"]"))).click();

		if (getElementById("vps_recycler")
				 .findElement(MobileBy.xpath(String.format(theXpath,"Voiture\"]"))).isSelected()) {
			System.out.println("The car transport mode is selected");
		}
	}



}
