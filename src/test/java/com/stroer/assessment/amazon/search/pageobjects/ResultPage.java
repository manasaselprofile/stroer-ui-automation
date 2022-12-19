package com.stroer.assessment.amazon.search.pageobjects;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultPage extends AbstractPage {

    public ResultPage(@NonNull WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void viewItemDetails(Integer position) {
        WebElement interestedItem = this.webDriverWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div/img[@data-image-index='"+position+"']")));
        interestedItem.click();
    }
}
