package stat.juhtimislauad.ng;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

// The TestNG listener class
public class ListenerClass extends TestListenerAdapter {
    @Attachment
    private byte[] captureScreenshot(WebDriver d) {
        return ((TakesScreenshot) d).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        captureScreenshot(getWebDriver());
    }
}