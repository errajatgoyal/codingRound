import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.println("Listner Function : onTestStart");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Listner Function : onTestSuccess");
    }

    public void onTestFailure(ITestResult result) {

        /*This can also capture a screenshot whenever there is a failure and save it in the user's project directory with
        the method name*/
        System.out.println("Test : "+result.getName()+" failed.");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Listener Function : onTestSkipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Listener Function : onTestFailedButWithinSuccessPercentage");
    }

    public void onStart(ITestContext context) {
        System.out.println("Listener Function : onStart");
    }

    public void onFinish(ITestContext context) {
        System.out.println("Listener Function : onFinish");
    }
}