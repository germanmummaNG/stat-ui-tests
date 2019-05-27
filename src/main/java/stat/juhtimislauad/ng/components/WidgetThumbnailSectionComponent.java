package stat.juhtimislauad.ng.components;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class WidgetThumbnailSectionComponent {

    private By widgetThumbnail = By.cssSelector(".thumbnail .card-header-title");

    public static WidgetThumbnailSectionComponent getWidgetThumbnailSectionComponent() {
        return new WidgetThumbnailSectionComponent();
    }

    public WidgetDetailViewComponent openWidgetDetailViewByShortTitle(String widgetShortTitle) {
        $(widgetThumbnail).find(By.xpath("//h5[contains(text(), '" + widgetShortTitle + "')]")).click();
        return new WidgetDetailViewComponent();
    }

}
