package com.stroer.assessment.amazon.search.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/stroer/assessment/amazon/search/features/HatsForMen.feature",
        glue = {"com.stroer.assessment.amazon.search.stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber.html"})
public class HatsForMenSearchTestRunner {
}
