package com.stroer.assessment.amazon.search.pageobjects;

import com.stroer.assessment.amazon.search.model.ItemPrice;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage extends AbstractPage {

    @FindBy(id = "quantity")
    private static WebElement quantity;

    @FindBy(xpath = "//*[@id='sc-subtotal-amount-buybox']/span")
    private static WebElement price;

    public ShoppingCartPage(@NonNull WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public int quantity() {
        return Integer.parseInt(new Select(quantity).getFirstSelectedOption().getText());
    }

    public Double price() {
        return new ItemPrice(price.getText()).getValue();
    }

    public void modifyQuantityCount(String quantityCount) {
        Select quantitySelect = new Select(quantity);
        quantitySelect.selectByValue(quantityCount);
    }

    public int updatedQuantity() {
        Select quantitySelect = new Select(quantity);
        return Integer.parseInt(quantitySelect.getFirstSelectedOption().getText());
    }

    public Double updatedPrice() {
        return new ItemPrice(price.getText()).getValue();
    }
}
