package stat.juhtimislauad.ng.components;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DashboardWidgetSelectionComponent {
    private By domainCheckboxes = By.cssSelector("#domain-checkboxes .control");
    private By widgetCheckboxes = By.cssSelector("#widget-checkboxes .control");

    public static DashboardWidgetSelectionComponent getDashboardWidgetSelectionComponent() {
        return new DashboardWidgetSelectionComponent();
    }

    @Step("Select checkbox by widget short name")
    public DashboardWidgetSelectionComponent selectWidgetByShortName(String widgetShortName) {
        $(widgetCheckboxes).find(By.xpath("//label[contains(normalize-space(.), '" + widgetShortName + "')]")).click();
        return this;
    }

    @Step("Select checkbox by domain name")
    public DashboardWidgetSelectionComponent selectWidgetByDomainName(String domainName) {
        $(domainCheckboxes).find(By.xpath("//label[contains(normalize-space(.), '" + domainName + "')]")).click();
        return this;
    }
}
