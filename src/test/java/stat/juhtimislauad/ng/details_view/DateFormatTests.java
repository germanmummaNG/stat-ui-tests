package stat.juhtimislauad.ng.details_view;

import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import stat.juhtimislauad.ng.BaseTest;
import stat.juhtimislauad.ng.pages.HomePage;

@Feature("Date formats are correct in Estonian and English")
public class DateFormatTests extends BaseTest {

    @BeforeClass
    public void loginUsingDev() {
        HomePage.goTo().loginUsingDev();
    }
}
