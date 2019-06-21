package stat.juhtimislauad.ng;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private By selectUserDropdown = By.xpath("//div[contains(text(), 'Logi sisse testkasutajaga')]");

    public static LoginPage getLoginPage() {
        return new LoginPage();
    }

    @Step("Login with username \"{username}\".")
    public void loginWithUser(String username) {
        $(selectUserDropdown).click();
        $x("//div[@tabindex = -1 and contains(text(), '" + username + "')]").click();
        $x("//div[@tabindex = -1]").waitUntil(not(visible), 4000);
    }

}
