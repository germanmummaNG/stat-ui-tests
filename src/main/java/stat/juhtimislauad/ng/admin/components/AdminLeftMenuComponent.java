package stat.juhtimislauad.ng.admin.components;

import org.openqa.selenium.By;
import stat.juhtimislauad.ng.admin.pages.AddWidgetPage;

import static com.codeborne.selenide.Selenide.$;

public class AdminLeftMenuComponent {

    private By addNewWidgetMenuItem = By.cssSelector("a[href='/branches/feature-sa0140-280/admin/widgets/new']");

    public static AdminLeftMenuComponent getAdminLeftMenu() {
        return new AdminLeftMenuComponent();
    }

    public AddWidgetPage selectAddNewWidget() {
        $(this.addNewWidgetMenuItem).click();
        return new AddWidgetPage();
    }
}
