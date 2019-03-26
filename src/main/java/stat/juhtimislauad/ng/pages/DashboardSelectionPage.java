package stat.juhtimislauad.ng.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DashboardSelectionPage {

    private By loggedInUsersName = By.className("header__personal__person");

    private By selectDashboardDropdown = By.xpath("//div[contains(text(),'Vali juhtimislaud')]");
    private By turismDropdownItem = By.xpath("//div[contains(text(),'Turism')]");
    private By regionalStatisticsDropdownItem = By.xpath("//div[contains(text(),'Piirkondlik statistika')]");
    private By ministryOfSocialAffairsDropdownItem = By.xpath("//div[contains(text(),'Sotsiaalministeerium')]");
    private By confirmSelectionButton = By.className("is-primary");

    public static DashboardSelectionPage getDashboardSelectionPage() {
        return new DashboardSelectionPage();
    }

    @Step("Select and open dashboard 'Turism'")
    public PersonalizedDashboardPage openTurismDashboard() {
        $(selectDashboardDropdown).click();
        $(turismDropdownItem).click();
        $(confirmSelectionButton).click();
        return new PersonalizedDashboardPage();
    }

    public String getLoggedInUsersName() {
        return $(loggedInUsersName).getText();
    }

    @Step("Select and open dashboard 'Regional Statistics'")
    public PersonalizedDashboardPage openRegionalStatisticsDashboard() {
        $(selectDashboardDropdown).click();
        $(regionalStatisticsDropdownItem).click();
        $(confirmSelectionButton).click();
        return new PersonalizedDashboardPage();
    }

    @Step("Select and open dashboard 'Ministry of Social Affairs'")
    public PersonalizedDashboardPage openMinistryOfSocialAffairsDashboard() {
        $(selectDashboardDropdown).click();
        $(ministryOfSocialAffairsDropdownItem).click();
        $(confirmSelectionButton).click();
        return new PersonalizedDashboardPage();
    }
}
