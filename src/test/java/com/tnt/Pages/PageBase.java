package com.tnt.Pages;

import com.tnt.Util.Driver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

    protected static WebDriver driver;

    public static final int timeoutInSeconds = 10;
    private static final String baseUrl = "https://www.tnt.com/express/nl_nl/site/home.html";

    @FindBy(how= How.LINK_TEXT, using="Accepteren")
    private WebElement acceptCookiePolicy;

    @FindBy(how= How.LINK_TEXT, using="Contact")
    private WebElement contactButton;

    @FindBy(how= How.LINK_TEXT, using="Kies uw service")
    private WebElement servicesButton;

    @FindBy(how=How.LINK_TEXT, using="0800 1234")
    private WebElement nationalNumber;

    @FindBy(how=How.LINK_TEXT, using="+31 20 4744343")
    private WebElement internationalNumber;

    @FindBy(how= How.CLASS_NAME, using="cms-c-navigation__login__label")
    private WebElement inloggen;

    @FindBy(how= How.NAME, using="username")
    private WebElement emailSelector;

    @FindBy(how= How.NAME, using="password")
    private WebElement passwordSelector;

    @FindBy(how= How.CSS, using="[data-e2e-id='mytnt.sign-in.submit']")
    private WebElement inloggenSelector;

    @FindBy(how=How.LINK_TEXT, using="Snel verzenden")
    private WebElement snelVerzendenService;

    @FindBy(how=How.LINK_TEXT, using="Voordelig verzenden")
    private WebElement voordeligVerzendenService;

    @FindBy(how=How.LINK_TEXT, using="Bekijk onze Special Services")
    private WebElement bekijkOnzeSpecialServices;

    @FindBy(how=How.LINK_TEXT, using="Account aanmaken")
    private WebElement accountAanmakenSelector;

    @FindBy(how= How.TAG_NAME, using="my-tnt-terms-of-service-checkbox")
    private WebElement selectPolicy;

    @FindBy(how=How.ID, using="cookieMessageCloseLink")
    private WebElement loginCookie;

    @FindBy(how= How.CSS, using="button[data-e2e-id='mytnt.registration.next']")
    private WebElement volgendeButton;

    @FindBy(how= How.CSS, using="[data-type='country']")
    private WebElement selectConuntry;

    @FindBy(how= How.NAME, using="tc-geo-country")
    private WebElement enterConuntry;

    @FindBy(how= How.CSS, using="div[class='js-cms-countrylist-all'] a")
    private WebElement countryList;

    @FindBy(how= How.CSS, using="div+message[type='alert']>div")
    private WebElement errorMessage;

    @FindBy(how= How.CSS, using="[alt='email sent']+p")
    private WebElement emailSentMessage;


    public PageBase(){
        driver = Driver.driver;
        driver.navigate().to(baseUrl);
        PageFactory.initElements(driver, this);
        acceptCookiePolicy();
    }

    public void acceptCookiePolicy(){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(acceptCookiePolicy));
        acceptCookiePolicy.click();
    }

    public void clickContactButton(){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(contactButton));
        contactButton.click();
    }

    public void isNationalNumberDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(nationalNumber));
        Assert.assertTrue(nationalNumber.isDisplayed());
    }

    public void isInterNationalNumberDisplayed(){
        Assert.assertTrue(internationalNumber.isDisplayed());
    }

    public void clickInloggen(){
        inloggen.click();
    }

    public void enterUserName(String email){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(emailSelector));
        emailSelector.sendKeys(email);
    }

    public void enterPassword(String password){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(passwordSelector));
        passwordSelector.sendKeys(password);
    }

    public void submitInloggen(){
        inloggenSelector.click();
    }

    public void clickKiesUwServicesButton(){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(servicesButton));
        servicesButton.click();
    }

    public void areAllServicesDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(snelVerzendenService));
        Assert.assertTrue(snelVerzendenService.isDisplayed());
        Assert.assertTrue(voordeligVerzendenService.isDisplayed());
        Assert.assertTrue(bekijkOnzeSpecialServices.isDisplayed());
    }

    public void isErrorMessageDisplayed() {
       WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
       Assert.assertTrue(errorMessage.isDisplayed());
    }

    public void clickAccountAanmakenButton(){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(accountAanmakenSelector));
        accountAanmakenSelector.click();
    }

    public void clickVolgendeButton(){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(volgendeButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", volgendeButton);
        volgendeButton.click();
    }

    public void selectPolicy(){
        loginCookie.click();
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectPolicy);
        selectPolicy.click();
    }

    public void navigateToCountry(){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(selectConuntry));
        selectConuntry.click();
    }

    public void enterCountryToBeSearched(String country){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(enterConuntry));
        enterConuntry.sendKeys(country);
    }

    public void countryListHasSearchedCountry(String country){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(enterConuntry));
        Assert.assertTrue(countryList.getText().contains(country));
    }

    public void emailSentMessageIsDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(emailSentMessage));
        Assert.assertTrue(emailSentMessage.isDisplayed());
    }
}
