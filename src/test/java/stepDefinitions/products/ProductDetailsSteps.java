package stepDefinitions.products;

import base.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.Products;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverSetup;

public class ProductDetailsSteps {
    private WebDriver driver;
    private PageObjectManager pom;
    private Products products = new Products();

    public ProductDetailsSteps(DriverSetup driverSetup) {
        this.driver = driverSetup.driver;
        this.pom = new PageObjectManager(driver);
    }

    @When("User scrolls down to Products section")
    public void userScrollsDownToProductsSection() {
        pom.scrollToElement(products.firstProduct);
    }

    @And("Clicks on a product from the products list")
    public void clicksOnAProductFromTheProductsList() throws InterruptedException {
        Thread.sleep(2000);
        pom.clickElement(products.firstProduct);
    }

    @Then("Product description page should be loaded")
    public void productDescriptionPageShouldBeLoaded() throws InterruptedException {
        Thread.sleep(2000);

        Assert.assertTrue(pom.isElementDisplayed(products.productDescription));
    }

    @And("Product image should be displayed")
    public void productImageShouldBeDisplayed() {
        Assert.assertTrue(pom.isElementDisplayed(products.productImage));
    }

    @And("Product name should be displayed")
    public void productNameShouldBeDisplayed() {
        Assert.assertTrue(pom.isElementDisplayed(products.productName));
    }

    @And("Product price should be displayed")
    public void productPriceShouldBeDisplayed() {
        Assert.assertTrue(pom.isElementDisplayed(products.productPrice));
    }
}
