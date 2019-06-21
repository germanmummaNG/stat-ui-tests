package stat.juhtimislauad.ng.admin.pages;

import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$x;

public class AllWidgetsPage {

    private static Logger logger = LoggerFactory.getLogger(AllWidgetsPage.class);

    public static AllWidgetsPage getAllWidgetsPage() {
        return new AllWidgetsPage();
    }

    @Step("Widget with name \"{widgetShortName}\" is displayed in table")
    public boolean widgetWithShortNameIsPresent(String widgetShortName) {
        String selector = "//a[contains(text(),'" + widgetShortName + "')]";
//        if (selenideElements.size() > 1) {
//            logger.error("Found more than 1 widget with name '{}'", widgetShortName);
//            throw new TooManyElementsFoundException(selector);
//        }
        System.out.println(selector);
        return $x(selector).should(appear) != null;
    }
}
