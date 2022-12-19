package com.stroer.assessment.amazon.search.pageobjects;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartSubTotalPage extends AbstractPage {

    @FindBy(id = "sw-gtc")
    private WebElement goToCartButton;

    public CartSubTotalPage(@NonNull WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToTheCart() {
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(goToCartButton)).click();
    }
}
