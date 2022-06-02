package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = about:blank
public class FlightBookingPageObjects {

    @FindBy(id = "OneWay")
    public WebElement oneWay;

    @FindBy(id = "FromTag")
    public WebElement fromTag;

    //Corrected the id from toTag to ToTag
    @FindBy(id = "ToTag")
    public WebElement toTag;

    @FindBy(xpath = "//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[3]/td[7]/a")
    public WebElement desiredDate;

    @FindBy(id = "SearchBtn")
    public WebElement searchButton;

    public FlightBookingPageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}