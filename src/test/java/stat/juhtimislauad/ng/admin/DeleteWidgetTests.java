package stat.juhtimislauad.ng.admin;

import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import stat.juhtimislauad.ng.ScreenshotListener;
import stat.juhtimislauad.ng.WebDriverConfiguration;
import stat.juhtimislauad.ng.helpers.admin.AddWidgetPageHelper;

import static com.google.common.truth.Truth.assertThat;
import static stat.juhtimislauad.ng.admin.components.AdminLeftMenuComponent.getAdminLeftMenu;
import static stat.juhtimislauad.ng.admin.pages.AddWidgetPage.getAddWidgetPage;
import static stat.juhtimislauad.ng.admin.pages.AdminPage.getAdminPage;
import static stat.juhtimislauad.ng.pages.HomePage.getHomePage;

@Feature("Can delete widget by admin")
@Listeners({ScreenshotListener.class})
public class DeleteWidgetTests extends WebDriverConfiguration {

    @BeforeClass
    public void loginAndOpenAdminPage() {
        getHomePage()
                .goTo()
                .loginWithUser("admin");
        getAdminPage().goTo();
    }

    @Test
    public void can_delete_newly_created_widget() {
        getAdminLeftMenu()
                .selectAddNewWidget();
        AddWidgetPageHelper.fillFormWithDefaultValues()
                .selectDataSourceAPI()
                .typeCubeCode("Hodor");

        assertThat(getAddWidgetPage().isAddGraphTypeLinkVisible()).isTrue();
    }

    @Test
    public void dropAllZapWidgets() {
        getAdminLeftMenu()
                .selectAllWidgets();

    }
}
