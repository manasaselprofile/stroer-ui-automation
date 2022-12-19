package com.stroer.assessment.amazon.search.stepdefinitions;

import com.stroer.assessment.amazon.search.utils.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class SearchStepDefinition {

    TestBase testBase = new TestBase();

    @Given("User should launch chrome browser")
    public void user_should_launch_chrome_browser() {
        testBase.initDriver();
    }

    @When("User should go to url {string}")
    public void user_should_go_to_url(String url) {
        testBase.openWebsite(url);
    }

    @And("User should give {string} in search box")
    public void user_should_give_in_search_box(String searchText) {
       testBase.homePage().searchItem(searchText);
    }

    @And("User should click on search")
    public void user_should_click_on_search() {
        testBase.homePage().clickSearch();
    }

    @And("User should select the first item in the result")
    public void user_should_select_the_first_item_in_the_result() {
        testBase.resultPage().viewItemDetails(1);
    }

    @And("User should select the quantity as {int}")
    public void user_should_select_the_quantity_as(int quantity) {
        testBase.productPage().selectQuantity(quantity);
    }

    @And("User should select the add to cart")
    public void user_should_select_the_add_to_cart() {
        testBase.productPage().addToCart();
    }

    @And("User should select go to the cart")
    public void user_should_select_go_to_the_cart() {
        testBase.cartSubTotalPage().goToTheCart();
    }

    @And("User should see price and quantity")
    public void user_should_see_price_and_quantity() {
        assertEquals(testBase.productPage().quantity(), testBase.shoppingCartPage().quantity());

        Optional<Double> calculatedPrice = Optional.of(testBase.productPage().getItemPrice().getValue() * testBase.productPage().quantity());
        assertEquals(calculatedPrice.get(), testBase.shoppingCartPage().price());
    }

    @And("User should reduce the quantity to {string}")
    public void user_should_reduce_the_quantity_to(String quantityCount) {
        testBase.shoppingCartPage().modifyQuantityCount(quantityCount);
    }

    @And("User should verify the modified quantity as {string}")
    public void user_should_verify_the_modified_quantity_as(String modifiedQuantity) {
        assertEquals((Integer.parseInt(modifiedQuantity)), testBase.shoppingCartPage().updatedQuantity());
    }

    @Then("User should verify the price")
    public void user_should_verify_the_price() {
        testBase.wait(2000);
        Optional<Double> calculatedPrice = Optional.of(testBase.productPage().getItemPrice().getValue() * testBase.shoppingCartPage().updatedQuantity());
        assertEquals(calculatedPrice.get(), testBase.shoppingCartPage().updatedPrice());
    }

    @And("close browser")
    public void close_browser() {
        testBase.cleanup();
    }
}
