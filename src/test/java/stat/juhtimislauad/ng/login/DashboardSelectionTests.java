package stat.juhtimislauad.ng.login;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import stat.juhtimislauad.ng.BaseTest;
import stat.juhtimislauad.ng.ListenerClass;
import stat.juhtimislauad.ng.pages.HomePage;

import static com.google.common.truth.Truth.assertThat;
import static stat.juhtimislauad.ng.pages.DashboardSelectionPage.getDashboardSelectionPage;

@Listeners({ListenerClass.class})
public class DashboardSelectionTests extends BaseTest {

    private static final String DEV_USERS_NAME = "lokaalne";
    private static final String DASHBOARD_TITLE_TURISM = "Turism";
    private static final String DASHBOARD_TITLE_REGIONAL_STATISTICS = "Piirkondlik statistika";
    private static final String DASHBOARD_TITLE_MINISTRY_OF_SOCIAL_AFFAIRS = "Heaolu arengukava 2016–2023";

    @BeforeClass(description = "Can login using DEV")
    public void can_see_username_after_successful_login() {
        HomePage
                .goTo()
                .loginUsingDev();
        assertThat(getDashboardSelectionPage().getLoggedInUsersName()).contains(DEV_USERS_NAME);
    }

    @AfterMethod
    public void backToDashboardSelection() {
        HomePage.goTo();
    }

    @Test(description = "Can select dashboard 'Turism'")
    public void can_select_turism() {
        String dashboardTitle = getDashboardSelectionPage()
                .openTurismDashboard()
                .getDashboardTitle();
        assertThat(dashboardTitle).isEqualTo(DASHBOARD_TITLE_TURISM);
    }

    @Test(description = "Can select dashboard 'Regional Statistics'")
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
}
