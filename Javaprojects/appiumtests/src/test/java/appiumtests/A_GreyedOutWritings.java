package appiumtests;

import io.appium.java_client.*;

/**
 * Ce test ouvre journeys avec le formulaire et vérifie les composants cachés 
 * 
 * @author mamrani
 *
 */
public class A_GreyedOutWritings extends A_AbstractJourneysTest {
	
	public static String theXpath = "android.widget.LinearLayout[@content-desc=";	 
	
	public static void main(String[] args) {
		System.out.println("Hello, we're going to check the greyed components in the formulary");

		try {
			openJourney();
			continueWithFormulary();
			DepartureWordingBeforeClicking();
			ArrivalWordingBeforeClicking(); 
			DepartureWordingAfterClicking();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static String DepartureWordingBeforeClicking() throws Exception {
        MobileElement textFieldDepartureElement = driver.findElement(MobileBy.id(String.format(thePath,"frf_departure_text")));
        String theDepartureText = textFieldDepartureElement.getText();	
        System.out.println("The DepartureWording before clicking :" +theDepartureText); 
		return theDepartureText;		
	}
	
	static String ArrivalWordingBeforeClicking() throws Exception {
        MobileElement textFieldArrivalElement = driver.findElement(MobileBy.id(String.format(thePath,"frf_arrival_text")));
        String theArrivalText = textFieldArrivalElement.getText();	
        System.out.println("The ArrivalWording before clicking :" +theArrivalText); 
		return theArrivalText;		
	}
	
	static String DepartureWordingAfterClicking() throws Exception {
		getElementById("frf_departure_text").click();
		MobileElement textFieldDepartureElement = getElementById("fra_departure_text"); 
		//.findElement(MobileBy.id(String.format(thePath,"edit_text_input")));
		//MobileElement textFieldDepartureElement = driver.findElement(MobileBy.xpath("//android.widget.LinearLayout[@content-desc=\"Recherche d'itinéraire en cours\"]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.EditText"));
        //driver.findElement(MobileBy.id(String.format(thePath,"edit_text_input")));
        String theDepartureText = textFieldDepartureElement.getAttribute("edit_text_input");	      
        System.out.println("The DepartureWording after clicking :" +theDepartureText); 
		return theDepartureText;		
	}
	/*
	getElementById("fra_arrival_text")
	.findElement(MobileBy.id(String.format(thePath,"edit_text_input"))).setValue("repub");
	
	android.widget.LinearLayout[@content-desc="Recherche d'itinéraire en cours"]/android.widget.LinearLayout[1]
	android.view.ViewGroup[@content-desc=\  */
	
	static String ArrivalWordingAfterClicking() throws Exception {
		getElementById("frf_arrival_text").click();
        MobileElement textFieldArrivalElement = driver.findElement(MobileBy.id(String.format(thePath,"fra_departure_text")));
        String theArrivalText = textFieldArrivalElement.getText();	
        System.out.println("The ArrivalWording after clicking :" +theArrivalText); 
		return theArrivalText;		
	}
}
