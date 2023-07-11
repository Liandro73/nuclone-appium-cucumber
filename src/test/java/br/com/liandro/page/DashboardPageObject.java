package br.com.liandro.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class DashboardPageObject extends BasePage {

    @AndroidFindBy( accessibility = "card-hero" )
    private WebElement cardBalance;

    @AndroidFindBy( accessibility = "show-balance" )
    private WebElement btnShowBalanceOnOff;

    @AndroidFindBy( accessibility = "user-balance" )
    private WebElement labelBalance;

    public DashboardPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void checkThatCardBalanceIsDisplayed() {
        cardBalance.isDisplayed();
    }

    public void clickOnBtnShowBalanceOnOff() {
        btnShowBalanceOnOff.click();
    }

    public void checkTheValueOnBalance(String value) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        labelBalance.isDisplayed();
        if (value.equals(labelBalance.getText())) {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Balance matched!\"}}");
        }
        else {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Balance not matched\"}}");
        }
        Assert.assertEquals(value, labelBalance.getText());
    }

}
