package stat.juhtimislauad.ng;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest {

    private static final String browserType = System.getProperty("browser");

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        if (browserType != null) {
            if (browserType.equalsIgnoreCase("chrome")) {
                configureChromeDriver();
            } else if (browserType.equalsIgnoreCase("firefox")) {
                configureFirefoxDriver();
            } else if (browserType.equalsIgnoreCase("ie")) {
                configureIEDriver();
            } else if (browserType.equalsIgnoreCase("edge")) {
                configureEdgeDriver();
            } else if (browserType.equalsIgnoreCase("safari")) {
                configureSafariDriver();
            } else {
                System.out.println("UNKNOWN DRIVER!");
            }
        } else {
            System.out.println("No driver specified, using default");
            configureChromeDriver();
        }
    }

    private void configureSafariDriver() {
        SafariOptions safariOptions = new SafariOptions();
        safariOptions.setCapability("cleanSession", true);
        SafariDriver safariDriver = new SafariDriver(safariOptions);
        safariDriver.manage().window().maximize();
        setWebDriver(safariDriver);
    }

    private void configureEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setCapability("ms:inPrivate", true);
        EdgeDriver edgeDriver = new EdgeDriver(edgeOptions);
        edgeDriver.manage().window().maximize();
        setWebDriver(edgeDriver);
    }

    private void configureIEDriver() {
        WebDriverManager.iedriver().setup();
        InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
        internetExplorerOptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        InternetExplorerDriver internetExplorerDriver = new InternetExplorerDriver(internetExplorerOptions);
        internetExplorerDriver.manage().window().maximize();
        setWebDriver(internetExplorerDriver);
    }

    private void configureFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("browser.privatebrowsing.autostart", true);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setProfile(firefoxProfile);
        FirefoxDriver firefoxDriver = new FirefoxDriver(firefoxOptions);
        firefoxDriver.manage().window().maximize();
        setWebDriver(firefoxDriver);
    }

    private void configureChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars", "incognito");
        ChromeDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().window().maximize();
        setWebDriver(chromeDriver);
    }

    @AfterSuite
    public void tearDown() {
        getWebDriver().quit();
    }
}
