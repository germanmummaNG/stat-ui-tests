package stat.juhtimislauad.ng.helpers.admin;

import io.qameta.allure.Step;
import stat.juhtimislauad.ng.admin.pages.AddWidgetPage;

import static stat.juhtimislauad.ng.admin.pages.AddWidgetPage.getAddWidgetPage;

public class AddWidgetPageHelper {

    private AddWidgetPageHelper() {
        throw new IllegalStateException("Utility class");
    }

    @Step("Fill widget form with default data")
    public static AddWidgetPage fillFormWithDefaultValues() {
        return getAddWidgetPage()
                .fillShortNameEt("LÜHIKE TEST ET")
                .fillShortNameEn("LÜHIKE TEST EN")
                .fillLongNameEt("PIKK TEST ET")
                .fillLongNameEn("PIKK TEST EN")
                .fillNumberOfLatestPeriods(5)
                .fillTimePeriodStartWithFirstOption()
                .fillTimePeriodEndWithLastOption()
                .selectWidgetIsVisible();
    }
}
