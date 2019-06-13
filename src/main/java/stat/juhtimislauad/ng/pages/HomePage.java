package stat.juhtimislauad.ng.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {

    private By loginButton = By.cssSelector("button.is-primary");

    @Step("Open home page")
    public static HomePage goTo() {
        open("https://arendus.juhtimislauad.stat.ee/branches/feature-sa0140-280/admin");
        return new HomePage();
    }

    @Step("Login using DEV")
    public void loginUsingDev() {
        $(loginButton).click();
    }
}
