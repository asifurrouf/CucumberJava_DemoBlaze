package locators;

import org.openqa.selenium.By;

public class Products {
    public By categoriesSection = By.id("cat");
    public By laptopsOption = By.xpath("(//a[@id=\"itemc\"])[2]");
    public By firstLaptop = By.xpath("//a[contains(text(), 'Sony vaio i5')]");

    //Scenario : 2
    public By firstProduct = By.xpath("(//h4[@class=\"card-title\"]/a)[1]");
    public By productDescription = By.xpath("//div[@id=\"more-information\"]/strong");
    public By productImage = By.xpath("//div[@class=\"item active\"]/img");
    public By productName = By.className("name");
    public By productPrice = By.className("price-container");
}
