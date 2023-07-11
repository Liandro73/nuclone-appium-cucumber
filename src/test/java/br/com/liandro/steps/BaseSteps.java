package br.com.liandro.steps;

import br.com.liandro.page.DashboardPageObject;
import br.com.liandro.page.BasePage;
import br.com.liandro.utils.DriverManager;
import io.appium.java_client.AppiumDriver;

public class BaseSteps {

    AppiumDriver driver;
    BasePage basePage;
    DashboardPageObject dashboardPageObject;

    public BaseSteps() {
        this.driver = DriverManager.getDriver();
        this.basePage = new BasePage(driver);
        this.dashboardPageObject = basePage.getDashboardPageObject();
    }

}
