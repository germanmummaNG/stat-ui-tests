package stat.juhtimislauad.ng.pages;

import io.qameta.allure.Step;
import stat.juhtimislauad.ng.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class HomePage {

    public static HomePage getHomePage() {
        return new HomePage();
    }

    @Step("Open home page")
    public LoginPage goTo() {
        open("/home");
        return new LoginPage();
    }

}
