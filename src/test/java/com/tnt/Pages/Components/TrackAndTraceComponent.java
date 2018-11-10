package com.tnt.Pages.Components;

import com.tnt.Pages.PageBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrackAndTraceComponent extends PageBase {
    public static final int timeoutInSeconds = 10;

    @FindBy(how= How.CSS, using="[name=\"track-and-trace\"] input[type=\"text\"]")
    private WebElement inputShipmentNumber;

    @FindBy(how=How.CSS, using="[class=\"search-box--widget__box--slide\"] button")
    private WebElement submitZoeken;

    @FindBy(how=How.CSS, using="[class*='pb-c-search-form']")
    private WebElement trackVisit;

    @FindBy(how=How.CSS, using="[class='__c-feedback__title']")
    private WebElement trackFeedback;

    @FindBy(how=How.CSS, using="[class='__c-feedback__header']")
    private WebElement trackFeedbackHeader;


    protected WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);

    public void setShipmentNumber(int shipmentNumber){
        wait.until(ExpectedConditions.visibilityOf(inputShipmentNumber));
        inputShipmentNumber.sendKeys(Integer.toString(shipmentNumber));
    }

    public void submitZoekenButton(){
        wait.until(ExpectedConditions.elementToBeClickable(submitZoeken));
        submitZoeken.click();
    }

    public void trackVisitIsVisible(){
        wait.until(ExpectedConditions.visibilityOf(trackVisit));
        Assert.assertTrue(trackVisit.isDisplayed());
    }

    public void trackFeedback(int shipmentNumber){
        wait.until(ExpectedConditions.visibilityOf(trackFeedback));
        Assert.assertTrue(trackFeedback.getText().contains(Integer.toString(shipmentNumber)));
    }
}
