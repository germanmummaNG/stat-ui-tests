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

    @Step("Select checkbox by widget short title")
    public DashboardWidgetSelectionComponent selectWidgetByShortTitle(String widgetShortTitle) {
        $(widgetCheckboxes).find(By.xpath("//label[contains(normalize-space(.), '" + widgetShortTitle + "')]")).click();
        return this;
    }
}
