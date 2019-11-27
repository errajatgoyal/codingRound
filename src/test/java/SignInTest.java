import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends TestHelper {

    @FindBy(linkText = "Your trips")
    private WebElement yourTrips;

    @FindBy(id = "SignIn")
    private WebElement signInButtonUnderYourTrips;

    @FindBy(id = "signInButton")
    private WebElement logInButton;

    @FindBy(id = "errors1")
    private WebElement errorMessageOnLoginFailure;

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() throws InterruptedException {

        yourTrips.click();
        signInButtonUnderYourTrips.click();
        driver.switchTo().frame("modal_window");
        logInButton.click();
        String errors1 = errorMessageOnLoginFailure.getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"), "Login got successful without entering the details");
    }
}