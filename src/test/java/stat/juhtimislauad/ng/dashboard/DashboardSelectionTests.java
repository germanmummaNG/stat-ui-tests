package stat.juhtimislauad.ng.dashboard;

import io.qameta.allure.Feature;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import stat.juhtimislauad.ng.ScreenshotListener;
import stat.juhtimislauad.ng.WebDriverConfiguration;

import static com.google.common.truth.Truth.assertThat;
import static stat.juhtimislauad.ng.LoginPage.getLoginPage;
import static stat.juhtimislauad.ng.pages.DashboardSelectionPage.getDashboardSelectionPage;
import static stat.juhtimislauad.ng.pages.HomePage.getHomePage;

@Feature("Can open different dashboards")
@Listeners(ScreenshotListener.class)
public class DashboardSelectionTests extends WebDriverConfiguration {

    private static final String DASHBOARD_TITLE_TOURISM = "Turism";
    private static final String DASHBOARD_TITLE_REGIONAL_STATISTICS = "Piirkondlik statistika";
    private static final String DASHBOARD_TITLE_MINISTRY_OF_SOCIAL_AFFAIRS = "Heaolu arengukava 2016–2023";

    @BeforeClass
    public void loginUsingDev() {
        getHomePage().goTo();
        getLoginPage().loginWithUser("german");
    }

    @Test(description = "Can select dashboard 'Turism'")
    public void can_select_tourism() {
        String dashboardTitle = getDashboardSelectionPage()
                .openTourismDashboard()
                .getDashboardTitle();
        assertThat(dashboardTitle).isEqualTo(DASHBOARD_TITLE_TOURISM);
    }

    @Test(description = "Can select dashboard 'Piirkondlik statistika'")
    public void can_select_regional_statistics() {
        String dashboardTitle = getDashboardSelectionPage()
                .openRegionalStatisticsDashboard()
                .getDashboardTitle();
        assertThat(dashboardTitle).isEqualTo(DASHBOARD_TITLE_REGIONAL_STATISTICS);
    }

    @Test(description = "Can select dashboard 'Ministry of Social Affairs'")
    public void can_select_ministry_of_social_affairs() {
        String dashboardTitle = getDashboardSelectionPage()
                .openMinistryOfSocialAffairsDashboard()
                .getDashboardTitle();
        assertThat(dashboardTitle).isEqualTo(DASHBOARD_TITLE_MINISTRY_OF_SOCIAL_AFFAIRS);
    }

    @AfterMethod
    public void goToHome() {
        getHomePage().goTo();
    }
}
