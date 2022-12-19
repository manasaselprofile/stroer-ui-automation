package com.stroer.assessment.amazon.search.pageobjects;

import com.stroer.assessment.amazon.search.model.ItemPrice;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//div[@id='corePrice_feature_div']//child::span/span[@class='a-offscreen']")
    private static WebElement price;

    @FindBy(id = "quantity")
    private static WebElement quantity;

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCart;

    private ItemPrice itemPrice;

    public ProductPage(@NonNull WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void calculatePrice(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        String priceValue = (String) js.executeScript("return arguments[0].innerHTML;", price);
        itemPrice = new ItemPrice(priceValue);
    }

    public void selectQuantity(int count) {
        Select quantitySelect = new Select(quantity);
        quantitySelect.selectByValue(String.valueOf(count));
        calculatePrice();
    }

    public int quantity() {
        return Integer.parseInt(new Select(quantity).getFirstSelectedOption().getText());
    }

    public void addToCart() {
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();
    }

    public ItemPrice getItemPrice(){
        return this.itemPrice;
    }
}
