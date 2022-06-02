import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.FlightBookingPageObjects;
import utils.TestHelper;

import java.util.List;

public class FlightBookingTest extends TestHelper {

    FlightBookingPageObjects flightBookingPageObjects;

    @Test
    public void testThatResultsAppearForAOneWayJourney() {

        flightBookingPageObjects = new FlightBookingPageObjects(driver);
        flightBookingPageObjects.oneWay.click();
        flightBookingPageObjects.fromTag.clear();
        flightBookingPageObjects.fromTag.sendKeys("Bangalore");

        List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
        originOptions.get(0).click();

        flightBookingPageObjects.toTag.clear();
        flightBookingPageObjects.toTag.sendKeys("Delhi");

        //select the first item from the destination auto complete list
        List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
        destinationOptions.get(0).click();

        flightBookingPageObjects.desiredDate.click();

        //all fields filled in. Now click on search
        flightBookingPageObjects.searchButton.click();

        //verify that result appears for the provided journey search
        Assert.assertTrue(isElementPresent(driver, By.className("searchSummary")), "Search Summary not present");
    }

}
