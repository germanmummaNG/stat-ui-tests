package stat.juhtimislauad.ng.admin;

import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import stat.juhtimislauad.ng.BaseTest;
import stat.juhtimislauad.ng.admin.pages.AddWidgetPage;
import stat.juhtimislauad.ng.helpers.admin.AddWidgetPageHelper;
import stat.juhtimislauad.ng.pages.HomePage;

import static com.codeborne.selenide.Selenide.open;
import static com.google.common.truth.Truth.assertThat;
import static stat.juhtimislauad.ng.admin.components.AdminLeftMenuComponent.getAdminLeftMenu;

@Feature("Can delete widget by admin")
public class DeleteWidgetTests extends BaseTest {

    @Test
    public void can_delete_newly_created_widget() {
        HomePage.goTo().loginUsingDev();
        open("https://arendus.juhtimislauad.stat.ee/branches/feature-sa0140-280/admin");
        getAdminLeftMenu()
                .selectAddNewWidget();
        AddWidgetPageHelper.fillFormWithDefaultValues()
                .selectDataSourceAPI()
                .typeCubeCode("LES02");

        assertThat(AddWidgetPage.getAddWidgetPage().isAddGraphTypeLinkVisible()).isTrue();
    }
}
