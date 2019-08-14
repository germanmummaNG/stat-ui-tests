package stat.juhtimislauad.ng;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.Dimension;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import stat.juhtimislauad.ng.util.EnvironmentInformationUtil;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    private static Logger logger = LoggerFactory.getLogger(BaseTest.class);
    private static final String BROWSER_TYPE = System.getProperty("browser");
    private static final String BASE_URL = "https://arendus.juhtimislauad.stat.ee/branches/develop";

    @BeforeSuite
    public void setUp() throws Exception {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        setWebDriver();
        setBaseUrl();
    }

    private void setBaseUrl() {
        Configuration.baseUrl = BASE_URL;
    }

    private void setWebDriver() throws Exception {
        if (BROWSER_TYPE != null) {
            if (BROWSER_TYPE.equalsIgnoreCase("chrome")) {
                configureChromeDriver();
            } else if (BROWSER_TYPE.equalsIgnoreCase("firefox")) {
                configureFirefoxDriver();
            } else if (BROWSER_TYPE.equalsIgnoreCase("ie")) {
                configureIEDriver();
            } else if (BROWSER_TYPE.equalsIgnoreCase("edge")) {
                configureEdgeDriver();
            } else if (BROWSER_TYPE.equalsIgnoreCase("safari")) {
                configureSafariDriver();
            } else {
                logger.error(String.format("UNKNOWN DRIVER SPECIFIED: %s", BROWSER_TYPE));
                throw new Exception("Unknown driver specified!");
            }
        } else {
            logger.info("No driver specified, using chrome");
            configureChromeDriver();
        }
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().window().setSize(new Dimension(1366, 768));
    }

    private void configureSafariDriver() {
        SafariOptions safariOptions = new SafariOptions();
        safariOptions.setCapability("cleanSession", true);
        SafariDriver safariDriver = new SafariDriver(safariOptions);
        WebDriverRunner.setWebDriver(safariDriver);
    }

    private void configureEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setCapability("ms:inPrivate", true);
        EdgeDriver edgeDriver = new EdgeDriver(edgeOptions);
        WebDriverRunner.setWebDriver(edgeDriver);
    }

    private void configureIEDriver() {
        WebDriverManager.iedriver().setup();
        InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
        internetExplorerOptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        InternetExplorerDriver internetExplorerDriver = new InternetExplorerDriver(internetExplorerOptions);
        WebDriverRunner.setWebDriver(internetExplorerDriver);
    }

    private void configureFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("browser.privatebrowsing.autostart", true);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setProfile(firefoxProfile);
        FirefoxDriver firefoxDriver = new FirefoxDriver(firefoxOptions);
        WebDriverRunner.setWebDriver(firefoxDriver);
    }

    private void configureChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars", "incognito", "--headless", "--no-sandbox");
        ChromeDriver chromeDriver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(chromeDriver);
    }

    @AfterClass
    public void clearWebDriverSession() {
        WebDriverRunner.getSelenideDriver().clearBrowserLocalStorage();
        WebDriverRunner.getSelenideDriver().clearCookies();
    }

    @AfterSuite
    public void tearDown() {
        EnvironmentInformationUtil.createEnvironmentInformationPropertiesFile();
        SelenideLogger.removeListener("AllureSelenide");
        getWebDriver().quit();
    }

}
