package stat.juhtimislauad.ng.admin.components;

import org.openqa.selenium.By;
import stat.juhtimislauad.ng.admin.pages.AddWidgetPage;

import static com.codeborne.selenide.Selenide.$;

public class AdminLeftMenuComponent {


    //    private By addNewWidgetMenuItem = By.id("add-new-widget-link");
    private By addNewWidgetMenuItem = By.xpath("//a[contains(@href, 'admin/widgets/new')]");
    private By addNewDashboardMenuItem = By.id("add-new-dashboard-link");
    private By allDashboardNavMenu = By.id("all-dashboards-link");
    private By allWidgetsMenuItem = By.id("all-widgets-link");
    private By adminHomeMenuItem = By.id("admin-home-link");

    public static AdminLeftMenuComponent getAdminLeftMenu() {
        return new AdminLeftMenuComponent();
    }

    public AddWidgetPage selectAddNewWidget() {
        $(this.addNewWidgetMenuItem).click();
        return new AddWidgetPage();
    }
}
