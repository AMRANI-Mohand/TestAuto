package appiumtests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class Z_CustomMobileElement2 extends MobileElement {
	
	
	public MobileElement getElementByXpath(AppiumDriver<Z_CustomMobileElement2> driver, String... ids) {
		MobileElement element = null;
		for (String id : ids) {
			if (element == null) {
				element = driver.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\\"+id));
			} else {
				element = element.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\\"+id));
			}
		}
		
		return element;	
	}
}
