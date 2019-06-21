package stat.juhtimislauad.ng.admin;

import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import stat.juhtimislauad.ng.BaseTest;
import stat.juhtimislauad.ng.admin.pages.AddWidgetPage;
import stat.juhtimislauad.ng.admin.pages.AdminPage;
import stat.juhtimislauad.ng.helpers.admin.AddWidgetPageHelper;

import static com.google.common.truth.Truth.assertThat;
import static stat.juhtimislauad.ng.LoginPage.getLoginPage;
import static stat.juhtimislauad.ng.admin.components.AdminLeftMenuComponent.getAdminLeftMenu;
import static stat.juhtimislauad.ng.pages.HomePage.getHomePage;

@Feature("Can delete widget by admin")
public class DeleteWidgetTests extends BaseTest {

    @BeforeClass
    public void loginAndOpenAdminPage() {
        getHomePage().goTo();
        getLoginPage().loginWithUser("admin");
        AdminPage.getAdminPage().goTo();
    }

    @Test
    public void can_delete_newly_created_widget() {
        getAdminLeftMenu()
                .selectAddNewWidget();
        AddWidgetPageHelper.fillFormWithDefaultValues()
                .selectDataSourceAPI()
                .typeCubeCode("Hodor");

        assertThat(AddWidgetPage.getAddWidgetPage().isAddGraphTypeLinkVisible()).isTrue();
    }
}
