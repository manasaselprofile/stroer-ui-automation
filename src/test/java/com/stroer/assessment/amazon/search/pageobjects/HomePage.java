package com.stroer.assessment.amazon.search.pageobjects;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AbstractPage {

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    public HomePage(@NonNull WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void searchItem(String searchText) {
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(searchBox)).sendKeys(searchText);
    }

    public void clickSearch() {
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }




}
