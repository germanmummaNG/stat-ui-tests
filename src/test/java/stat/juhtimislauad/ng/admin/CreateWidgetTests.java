package stat.juhtimislauad.ng.admin;

import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import stat.juhtimislauad.ng.ScreenshotListener;
import stat.juhtimislauad.ng.WebDriverConfiguration;
import stat.juhtimislauad.ng.admin.pages.AllWidgetsPage;

import java.util.Locale;

import static com.google.common.truth.Truth.assertThat;
import static stat.juhtimislauad.ng.LoginPage.getLoginPage;
import static stat.juhtimislauad.ng.admin.components.AdminLeftMenuComponent.getAdminLeftMenu;
import static stat.juhtimislauad.ng.admin.pages.AddWidgetPage.getAddWidgetPage;
import static stat.juhtimislauad.ng.admin.pages.AdminPage.getAdminPage;
import static stat.juhtimislauad.ng.pages.HomePage.getHomePage;

@Feature("Can create widgets by admin")
@Listeners({ScreenshotListener.class})
public class CreateWidgetTests extends WebDriverConfiguration {

    private static Faker faker = new Faker(new Locale("en-US"));

    @BeforeClass
    public void loginAsAdmin() {
        getHomePage().goTo();
        getLoginPage().loginWithUser("admin");
        getAdminPage().goTo();
    }

    @Test
    public void can_create_widget_with_only_required_data() {
        String widgetShortName = faker.book().author();
        String widgetLongName = faker.book().title();

        getAdminLeftMenu()
                .selectAddNewWidget()
                .fillShortNameEt(widgetShortName)
                .fillShortNameEn(widgetShortName)
                .fillLongNameEt(widgetLongName)
                .fillLongNameEn(widgetLongName)
                .clickSave();
        assertThat(AllWidgetsPage.getAllWidgetsPage().widgetWithShortNameIsPresent(widgetShortName)).isTrue();
    }

    @Test
    public void can_not_create_widget_when_required_data_is_missing() {
        getAdminLeftMenu().selectAddNewWidget()
                .clearWidgetShortNameEt();
        assertThat(getAddWidgetPage().saveButtonIsDisabled()).isTrue();
    }

}
