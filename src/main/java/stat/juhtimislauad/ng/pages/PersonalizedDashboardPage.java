package stat.juhtimislauad.ng.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PersonalizedDashboardPage {

    private By dashboardHeader = By.cssSelector("h1.title");

    public static PersonalizedDashboardPage getPersonalizedDashboardPage() {
        return new PersonalizedDashboardPage();
    }

    @Step("Get current dashboard title")
    public String getDashboardTitle() {
        return $(dashboardHeader).getText();
    }
}
