package stat.juhtimislauad.ng.components;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class WidgetDetailViewComponent {
    private By widgetShortTitle = By.cssSelector("#expanded_chart h2");
    private By widgetTitle = By.cssSelector("#expanded_chart h4");
    private By chartLegends = By.cssSelector(".recharts-legend-wrapper .recharts-legend-item > span");
    private By chartIconBar = By.cssSelector("button[aria-label='Choose bar']");
    private By chartIconVertical = By.cssSelector("button[aria-label='Choose vertical']");
    private By chartIconStacked = By.cssSelector("button[aria-label='Choose stacked']");
    private By chartIconPie = By.cssSelector("button[aria-label='Choose pie']");
    private By chartIconInfo = By.cssSelector("button[aria-label='Choose info']");
    private By chartIconMap = By.cssSelector("button[aria-label='Choose map']");
    private By filters = By.cssSelector(".filters .react-select-container");

    public String getTitleWithFilterInfo() {
        return $(widgetTitle).getText();
    }

    public WidgetDetailViewComponent switchToMapDiagram() {
        while (!$(chartIconMap).getAttribute("class").contains("active")) {
            $(chartIconMap).waitUntil(Condition.visible, 4000).click();
        }
        return this;
    }

    public WidgetDetailViewComponent changeTimeFilterTo(String filterOption) {
//        $$x("//div[contains(@class, 'react-select-container')]").last().click();
        $x("/preceding-sibling::div").click();
        $x("//div[text()='" + filterOption + "']").click();
        $x("//div[text()='" + filterOption + "']").parent().find("div");
        return this;
    }
}
