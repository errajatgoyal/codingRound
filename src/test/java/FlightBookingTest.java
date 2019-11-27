import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FlightBookingTest extends TestHelper {

    @FindBy(id = "OneWay")
    private WebElement oneWay;

    @FindBy(id = "FromTag")
    private WebElement fromTag;

    //Corrected the id from toTag to ToTag
    @FindBy(id = "ToTag")
    private WebElement toTag;

    @FindBy(xpath = "//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[3]/td[7]/a")
    private WebElement desiredDate;

    @FindBy(id = "SearchBtn")
    private WebElement searchButton;

    @Test
    public void testThatResultsAppearForAOneWayJourney() {

        oneWay.click();
        fromTag.clear();
        fromTag.sendKeys("Bangalore");

        List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
        originOptions.get(0).click();

        toTag.clear();
        toTag.sendKeys("Delhi");

        //select the first item from the destination auto complete list
        List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
        destinationOptions.get(0).click();

        desiredDate.click();

        //all fields filled in. Now click on search
        searchButton.click();

        //verify that result appears for the provided journey search
        Assert.assertTrue(isElementPresent(driver, By.className("searchSummary")), "Search Summary not present");
    }

}
