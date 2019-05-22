package stat.juhtimislauad.ng.util;

import com.codeborne.selenide.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.String.format;

public class EnvironmentInformationUtil {

    private static Logger logger = LoggerFactory.getLogger(EnvironmentInformationUtil.class);

    private EnvironmentInformationUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static void createEnvironmentInformationPropertiesFile() {
        String fileSeparator = System.getProperty("file.separator");
        String fileName = "environment.properties";
        String fileDirectory = "target" + fileSeparator + "allure-results";
        String absoluteFilePath = fileDirectory + fileSeparator + fileName;
        try (FileOutputStream fileOutputStream = new FileOutputStream(absoluteFilePath)) {

            String browserProp = "browser=" + Configuration.browser + " " + Configuration.browserVersion;
            String browserSizeProp = "browser.size=" + Configuration.browserSize;
            String osProp = "os.name=" + System.getProperty("os.name");
            String windowSizeProp = "window.size=" + getWebDriver().manage().window().getSize().getWidth() + "x" + getWebDriver().manage().window().getSize().getHeight();
            String javaVersionProp = "java.version=" + System.getProperty("java.version");
            String userTimezoneProp = "user.timezone=" + System.getProperty("user.timezone");
            String fileEncodingProp = "file.encoding=" + System.getProperty("file.encoding");

            writeProp(fileOutputStream, osProp);
            writeProp(fileOutputStream, browserProp);
            writeProp(fileOutputStream, browserSizeProp);
            writeProp(fileOutputStream, windowSizeProp);
            writeProp(fileOutputStream, javaVersionProp);
            writeProp(fileOutputStream, userTimezoneProp);
            writeProp(fileOutputStream, fileEncodingProp);
            fileOutputStream.flush();
            logger.info("Successfully created environment.properties file in target/allure-results directory");
        } catch (IOException ex) {
            logger.error(format("Error creating environment.properties file:\n%s", ex.getMessage()));
        }
    }

    private static void writeProp(FileOutputStream fileOutputStream, String prop) throws IOException {
        String lineSeparator = System.getProperty("line.separator");
        fileOutputStream.write(prop.getBytes());
        fileOutputStream.write(lineSeparator.getBytes());
    }
}
