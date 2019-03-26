package stat.juhtimislauad.ng.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PersonalizedDashboardPage {

    private By dashboardTitle = By.cssSelector("#navMenu > .navbar-start > .navbar-item");

    @Step("Get current dashboard title")
    public String getDashboardTitle() {
        return $(dashboardTitle).getText();
    }
}
