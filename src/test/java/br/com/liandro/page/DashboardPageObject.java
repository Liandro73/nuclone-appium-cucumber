package br.com.liandro.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.Assert;

public class DashboardPageObject extends BasePage {

    @AndroidFindBy( accessibility = "card-hero" )
    private MobileElement cardBalance;

    @AndroidFindBy( accessibility = "show-balance" )
    private MobileElement btnShowBalanceOnOff;

    @AndroidFindBy( accessibility = "user-balance" )
    private MobileElement labelBalance;

    public DashboardPageObject(AppiumDriver<?> driver) {
        super(driver);
    }

    public void checkThatCardBalanceIsDisplayed() {
        cardBalance.isDisplayed();
    }

    public void clickOnBtnShowBalanceOnOff() {
        btnShowBalanceOnOff.click();
    }

    public void checkTheValueOnBalance(String value) {
        labelBalance.isDisplayed();
        Assert.assertEquals(value, labelBalance.getText());
    }

}
