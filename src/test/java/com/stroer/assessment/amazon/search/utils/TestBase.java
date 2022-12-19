package com.stroer.assessment.amazon.search.utils;

import com.stroer.assessment.amazon.search.pageobjects.HomePage;
import com.stroer.assessment.amazon.search.pageobjects.CartSubTotalPage;
import com.stroer.assessment.amazon.search.pageobjects.ProductPage;
import com.stroer.assessment.amazon.search.pageobjects.ResultPage;
import com.stroer.assessment.amazon.search.pageobjects.ShoppingCartPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestBase {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private HomePage homePage;
    private ProductPage productPage;
    private ResultPage resultPage;
    private ShoppingCartPage shoppingCartPage;
    private CartSubTotalPage cartSubTotalPage;

    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        final ChromeOptions options = new ChromeOptions();
        webDriver = new ChromeDriver(options);
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        homePage = new HomePage(webDriver);
        productPage = new ProductPage(webDriver);
        resultPage = new ResultPage(webDriver);
        shoppingCartPage = new ShoppingCartPage(webDriver);
        cartSubTotalPage = new CartSubTotalPage(webDriver);
    }

    public WebDriver driver(){
        return this.webDriver;
    }

    public void cleanup(){
        webDriver.close();
        webDriver.quit();
    }

    public HomePage homePage(){
        return this.homePage;
    }

    public ResultPage resultPage(){
        return this.resultPage;
    }

    public ProductPage productPage(){
        return this.productPage;
    }

    public ShoppingCartPage shoppingCartPage(){
        return this.shoppingCartPage;
    }

    public CartSubTotalPage cartSubTotalPage(){
        return this.cartSubTotalPage;
    }

    public void openWebsite(String url){
        this.webDriver.get(url);
        this.webDriver.manage().window().maximize();
    }

    public void wait(int millis){
        try {
            Thread.sleep(2000);
        } catch(InterruptedException ie){
            // Interrupted Exception while attempting to thread sleep
        }
    }
}
