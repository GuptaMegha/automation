package com.tnt.Util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    public static WebDriver driver=null;

    public static WebDriver startdriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;

    }

}

