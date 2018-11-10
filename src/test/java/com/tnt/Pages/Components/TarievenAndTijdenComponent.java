package com.tnt.Pages.Components;


import com.tnt.Pages.PageBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TarievenAndTijdenComponent extends PageBase{

    public static final int timeoutInSeconds = 10;

    @FindBy(how= How.NAME, using="location-input-from")
    private WebElement locationInputFrom;

    @FindBy(how= How.NAME, using="location-input-to")
    private WebElement locationInputTo;

    @FindBy(how= How.NAME, using="packageType")
    private WebElement packageTypeSelect;

    @FindBy(how= How.CSS, using="button[data-e2e-id='widget.quoteButton']")
    private WebElement quoteButton;

    @FindBy(how= How.CSS, using="[data-e2e-id='address-search-input-suggestions']")
    private WebElement autocomplete;

    @FindBy(how= How.CSS, using="[data-e2e-id='address-search-input-suggestions'] li")
    private List<WebElement> autocompleteSuggestions;

    @FindBy(how= How.CLASS_NAME, using="shipment-quote-widget__title")
    private WebElement quoteWidgetTitle;

    @FindBy(how= How.CSS, using="[name='length']")
    private WebElement lengthSelector;

    @FindBy(how= How.CSS, using="[name='width']")
    private WebElement widthSelector;

    @FindBy(how= How.CSS, using="[name='height']")
    private WebElement heightSelector;

    @FindBy(how= How.CSS, using="[name='weight']")
    private WebElement weightSelector;

    @FindBy(how= How.CSS, using="[data-e2e-id='widget.button.get-prices']")
    private WebElement submitGetQuote;

    @FindBy(how= How.CLASS_NAME, using="service__col-flex")
    private WebElement quoteLoader;

    @FindBy(how= How.CLASS_NAME, using="service-all")
    private List<WebElement> quoteSummary;

    @FindBy(how= How.NAME, using="product-type")
    private WebElement envelopeTypeSelect;

    @FindBy(how= How.CSS, using="[data-e2e-id='noToFrom-error'")
    private WebElement errorNoLocation;


    protected WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);

    public void setInputFromLocation(String inputFromLocation){

        wait.until(ExpectedConditions.visibilityOf(locationInputFrom));
        locationInputFrom.sendKeys(inputFromLocation);
        wait.until(ExpectedConditions.visibilityOf(autocomplete));
        autocompleteSuggestions.get(0).click();
    }

    public void setInputToLocation(String inputToLocation){
        wait.until(ExpectedConditions.visibilityOf(locationInputTo));
        locationInputTo.sendKeys(inputToLocation);
        wait.until(ExpectedConditions.visibilityOf(autocomplete));
        autocompleteSuggestions.get(0).click();
    }

    public void selectPackageType(String packageType){
        wait.until(ExpectedConditions.visibilityOf(packageTypeSelect));
        Select select = new Select(packageTypeSelect);
        select.selectByVisibleText(packageType);
    }

    public void submitRequestQuoteButton(){
        quoteButton.click();
    }

    public void isQuoteWidgetTitleVisible(){
        wait.until(ExpectedConditions.visibilityOf(quoteWidgetTitle));
        Assert.assertTrue(quoteWidgetTitle.isDisplayed());
    }

    public void inputLength(String length){
        lengthSelector.sendKeys(length);
    }

    public void inputBreadth(String breadth){
        widthSelector.sendKeys(breadth);
    }

    public void inputHeigth(String heigth){
        heightSelector.sendKeys(heigth);
    }

    public void inputweight(String weight){
        weightSelector.sendKeys(weight);
    }

    public void submitGetQuoteButton(){
        submitGetQuote.click();
    }

    public void isQuoteSummaryVisible(){
        wait.until(ExpectedConditions.visibilityOf(quoteLoader));
        Assert.assertTrue(quoteSummary.size() > 0);
    }

    public void selectEnvelopeType(String envelopeType){
        wait.until(ExpectedConditions.visibilityOf(envelopeTypeSelect));
        Select select = new Select(envelopeTypeSelect);
        select.selectByVisibleText(envelopeType);
    }

    public void clickLocation(){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(locationInputFrom));
        locationInputFrom.click();
    }

    public void isNoLocationErrorDisplayed(){
        Assert.assertTrue(errorNoLocation.isDisplayed());
    }
}
