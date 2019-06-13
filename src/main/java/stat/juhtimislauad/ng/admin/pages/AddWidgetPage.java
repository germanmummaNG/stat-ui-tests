package stat.juhtimislauad.ng.admin.pages;

import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddWidgetPage {

    private By shortNameEt = By.name("shortnameEt");
    private By shortNameEn = By.name("shortnameEn");
    private By nameEt = By.name("nameEt");
    private By nameEn = By.name("nameEn");
    private By numberOfLatestPeriods = By.name("periods");
    private By timePeriodStart = By.xpath("//div[@id='time-period-start-date']//div[contains(text(), 'Vali aasta')]");
    private By timePeriodEnd = By.xpath("//div[@id='time-period-end-date']//div[contains(text(), 'Vali aasta')]");
    private By widgetVisibilityCheckboxes = By.cssSelector("#widget-visibility .control");
    private By saveBtn = By.cssSelector("button[type='submit']");
    private By dataSourceApi = By.cssSelector("input[value='API']");
    private By addGraphTypeLink = By.xpath("//a[contains(text(),'Lisa graafikutüüp')]");

    public boolean isAddGraphTypeLinkVisible() {
        try {
            $(addGraphTypeLink).shouldBe(visible);
            return true;
        } catch (ElementNotFound ex) {
            return false;
        }
    }

    private By cubeCode = By.name("cube");

    public static AddWidgetPage getAddWidgetPage() {
        return new AddWidgetPage();
    }

    public AddWidgetPage fillShortNameEt(String shortNameEt) {
        $(this.shortNameEt).setValue(shortNameEt);
        return this;
    }

    public AddWidgetPage fillShortNameEn(String shortNameEn) {
        $(this.shortNameEn).setValue(shortNameEn);
        return this;
    }

    public AddWidgetPage fillLongNameEt(String nameEt) {
        $(this.nameEt).setValue(nameEt);
        return this;
    }

    public AddWidgetPage fillLongNameEn(String nameEn) {
        $(this.nameEn).setValue(nameEn);
        return this;
    }

    public AddWidgetPage fillNumberOfLatestPeriods(int numberOfLatestPeriods) {
        $(this.numberOfLatestPeriods).setValue(String.valueOf(numberOfLatestPeriods));
        return this;
    }

    public AddWidgetPage fillTimePeriodStartWithFirstOption() {
        $(this.timePeriodStart).click();
        $$("#time-period-start-date div[tabindex='-1']").first().click();
        $$("#time-period-start-date div[tabindex='-1']").last().waitUntil(not(visible), 1000);
        return this;
    }

    public AddWidgetPage fillTimePeriodEndWithFirstOption() {
        $(this.timePeriodEnd).click();
        $$("#time-period-end-date div[tabindex='-1']").last().click();
        $$("#time-period-end-date div[tabindex='-1']").last().waitUntil(not(visible), 1000);
        return this;
    }

    public AddWidgetPage selectWidgetIsVisible() {
        $$(this.widgetVisibilityCheckboxes).first();
        return this;
    }

    public AddWidgetPage selectWidgetIsNotVisible() {
        $$(this.widgetVisibilityCheckboxes).last();
        return this;
    }

    public void clickSave() {
        $(this.saveBtn).shouldBe(visible).click();
    }

    public AddWidgetPage selectDataSourceAPI() {
        $(this.dataSourceApi).waitUntil(visible, 1000).click();
        return this;
    }

    public AddWidgetPage typeCubeCode(String cubeCode) {
        $(this.cubeCode).setValue(cubeCode);
        return this;
    }
}
