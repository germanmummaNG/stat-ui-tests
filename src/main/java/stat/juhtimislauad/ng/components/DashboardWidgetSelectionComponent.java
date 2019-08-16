package stat.juhtimislauad.ng.components;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;

public class DashboardWidgetSelectionComponent {
    private By domainCheckboxes = By.cssSelector("#domain-checkboxes .control");
    private By widgetCheckboxes = By.cssSelector("#widget-checkboxes .control");
    private By toggleWidgetSelectionDrawer = By.cssSelector("h1 > button");
    private By confirmWidgetSelection = By.cssSelector("button[aria-label=confirm-selection]");

    public static DashboardWidgetSelectionComponent getDashboardWidgetSelectionComponent() {
        return new DashboardWidgetSelectionComponent();
    }

    @Step("Expand widget selection drawer")
    public DashboardWidgetSelectionComponent expandWidgetSelectionDrawer() {
        $(toggleWidgetSelectionDrawer).click();
        $(confirmWidgetSelection).should(appear);
        return this;
    }

    @Step("Select checkbox for widget with short name \"{widgetShortName}\"")
    public DashboardWidgetSelectionComponent selectWidgetByShortName(String widgetShortName) {
        $(widgetCheckboxes).find(By.xpath("//label[contains(normalize-space(.), '" + widgetShortName + "')]")).click();
        return this;
    }

    @Step("Select checkbox for widget with short name \"{widgetShortName}\" if not selected")
    public DashboardWidgetSelectionComponent selectWidgetByShortNameIfNotSelected(String widgetShortName) {
        $(widgetCheckboxes).find(By.xpath("//label[contains(normalize-space(.), '" + widgetShortName + "')]")).click();
        return this;
    }

    @Step("Select checkbox by domain name")
    public DashboardWidgetSelectionComponent selectWidgetByDomainName(String domainName) {
        $(domainCheckboxes).find(By.xpath("//label[contains(normalize-space(.), '" + domainName + "')]")).click();
        return this;
    }
}
