package stat.juhtimislauad.ng.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {

    private By loginButton = By.cssSelector("button.is-primary");

    @Step("Open home page")
    public static HomePage goTo() {
        open("https://arendus.juhtimislauad.stat.ee");
        return new HomePage();
    }

    @Step("Login using DEV")
    public DashboardSelectionPage loginUsingDev() {
        $(loginButton).click();
        return new DashboardSelectionPage();
    }
}
