package stat.juhtimislauad.ng.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {

    private By loginButton = By.cssSelector("button.is-primary");

    public static HomePage getHomePage() {
        return new HomePage();
    }

    @Step("Open home page")
    public HomePage goTo() {
        open("/home");
        return this;
    }

    @Step("Login using DEV")
    public void loginUsingDev() {
        $(loginButton).click();
    }
}
