package stat.juhtimislauad.ng.admin.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ElementNotFound;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AdminPage {

    private static Logger logger = LoggerFactory.getLogger(AdminPage.class);

    private static By dashboardHeading = By.xpath("//p[contains(text(), 'TÖÖLAUD')]");

    public static AdminPage getAdminPage() {
        return new AdminPage();
    }

    @Step("Open admin page")
    public AdminPage goTo() {
        open("/admin");
        return this;
    }

    public static boolean isAt() {
        try {
            $(dashboardHeading).shouldBe(Condition.visible);
            return true;
        } catch (ElementNotFound elementNotFound) {
            logger.error(elementNotFound.getMessage());
            return false;
        }
    }

}
