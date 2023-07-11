package br.com.liandro.page;

import br.com.liandro.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected AppiumDriver driver;
    private DashboardPageObject dashboardPageObject;

    public BasePage(AppiumDriver driver) {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public DashboardPageObject getDashboardPageObject() {
        if(this.dashboardPageObject == null) {
            this.dashboardPageObject = new DashboardPageObject(driver);
        }
        return this.dashboardPageObject;
    }

}
