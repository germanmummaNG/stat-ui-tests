package stat.juhtimislauad.ng;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
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
                setWebDriver(getConfiguredChromeDriver());
            } else if (browserType.equalsIgnoreCase("firefox")) {
                setWebDriver(getConfiguredFirefoxDriver());
            } else if (browserType.equalsIgnoreCase("ie")) {
                setWebDriver(getConfiguredIEDriver());
            } else if (browserType.equalsIgnoreCase("edge")) {
                setWebDriver(getConfiguredEdgeDriver());
            } else if (browserType.equalsIgnoreCase("safari")) {
                setWebDriver(getConfiguredSafariDriver());
            } else {
                System.out.println("UNKNOWN DRIVER!");
            }
        } else {
            System.out.println("No driver specified, using default");
            setWebDriver(getConfiguredChromeDriver());
        }

    }

    private SafariDriver getConfiguredSafariDriver() {
        SafariDriver driver = new SafariDriver();

        driver.manage().window().maximize();
        return driver;
    }

    @AfterSuite
    public void tearDown() {
        getWebDriver().quit();
    }

    private EdgeDriver getConfiguredEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private FirefoxDriver getConfiguredFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.manage().window().maximize();
        return firefoxDriver;
    }

    private InternetExplorerDriver getConfiguredIEDriver() {
        WebDriverManager.iedriver().setup();
        InternetExplorerDriver driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private ChromeDriver getConfiguredChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }
}
