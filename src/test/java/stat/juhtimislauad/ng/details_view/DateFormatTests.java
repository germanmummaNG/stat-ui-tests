package stat.juhtimislauad.ng.details_view;

import io.qameta.allure.Feature;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import stat.juhtimislauad.ng.ScreenshotListener;
import stat.juhtimislauad.ng.WebDriverConfiguration;

import static com.codeborne.selenide.Selenide.open;
import static com.google.common.truth.Truth.assertThat;
import static stat.juhtimislauad.ng.LoginPage.getLoginPage;
import static stat.juhtimislauad.ng.components.DashboardWidgetSelectionComponent.getDashboardWidgetSelectionComponent;
import static stat.juhtimislauad.ng.components.WidgetThumbnailSectionComponent.getWidgetThumbnailSectionComponent;
import static stat.juhtimislauad.ng.pages.HomePage.getHomePage;

@Feature("Date formats are correct in Estonian and English")
@Listeners({ScreenshotListener.class})
public class DateFormatTests extends WebDriverConfiguration {

    private static final String DECEMBER_2018_ET = "detsember 2018";

    @BeforeClass
    public void loginUsingDev() {
        getHomePage().goTo();
        getLoginPage().loginWithUser("german");
    }

    @Test(description = "Widget title contains month with correct format")
    public void title_has_correct_month_format() {
        String widgetShortName = "Registreeritud töötute arv";
        open("https://arendus.juhtimislauad.stat.ee/branches/develop/dashboard/3");

        getDashboardWidgetSelectionComponent()
                .selectWidgetByShortName(widgetShortName);

        String widgetTitleWithFilterInfo = getWidgetThumbnailSectionComponent()
                .openWidgetDetailViewByShortTitle(widgetShortName)
                .getTitleWithFilterInfo();

        assertThat(widgetTitleWithFilterInfo).contains("jaanuar 2018 - märts 2019");
    }

    @Test(description = "Widget title contains month with correct format after changing time period filter")
    public void title_has_correct_month_format_after_changing_date_filter() {
        String widgetShortName = "Registreeritud töötute arv";
        open("https://arendus.juhtimislauad.stat.ee/branches/develop/dashboard/3");
        getDashboardWidgetSelectionComponent()
                .selectWidgetByShortName(widgetShortName);

        String widgetTitleWithFilterInfo = getWidgetThumbnailSectionComponent()
                .openWidgetDetailViewByShortTitle(widgetShortName)
                .switchToMapDiagram()
                .changeTimeFilterTo(DECEMBER_2018_ET)
                .getTitleWithFilterInfo();

        assertThat(widgetTitleWithFilterInfo).endsWith(DECEMBER_2018_ET);
    }

    public void title_has_correct_quarter_format() {

    }

    public void diagram_x_axis_has_correct_quarter_format() {

    }

    public void diagram_x_axis_has_correct_quarter_month_format() {

    }

    public void period_filter_has_correct_month_format() {

    }

    @AfterMethod
    public void returnHome() {
        getHomePage().goTo();
    }

}
