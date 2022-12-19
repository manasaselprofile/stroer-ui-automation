package com.stroer.assessment.amazon.search.pageobjects;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractPage {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public AbstractPage(@NonNull WebDriver driver) {
        this.webDriver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

}
