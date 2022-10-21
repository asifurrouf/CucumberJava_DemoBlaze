package stepDefinitions.products;

import base.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.Products;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverSetup;

public class FilteringProductsSteps {
    private WebDriver driver;
    private PageObjectManager pom;
    private Products products = new Products();

    public FilteringProductsSteps(DriverSetup driverSetup) {
        this.driver = driverSetup.driver;
        this.pom = new PageObjectManager(driver);
    }

    @And("Categories section should be displayed")
    public void categoriesSectionShouldBeDisplayed() {
        Assert.assertTrue(pom.isElementDisplayed(products.categoriesSection));
    }

    @When("User clicks on Laptops option")
    public void userClicksOnLaptopsOption() {
        pom.clickElement(products.laptopsOption);
    }

    @Then("Laptop items should be Displayed")
    public void laptopItemsShouldBeDisplayed() {
        Assert.assertTrue(pom.isElementDisplayed(products.firstLaptop));
    }
}
