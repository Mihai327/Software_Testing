package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteFromCartSteps {
    WebDriver driver;
    ElementsPaths element = new ElementsPaths();

    @Given("I go to the Women's wear - Women clothing page")
    public void i_go_to_the_women_s_wear_women_clothing_page() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        //se navigheaza pe net catre site-ul indicat in variabila siteAddress
        driver.navigate().to(element.siteAddress);
        // accesez pagina cu accesorii pentru femei
        driver.findElement(By.xpath(element.womenWearPage)).click();
        driver.findElement(By.xpath(element.womenClothing)).click();
    }
    @Then("I add an product to my cart")
    public void i_add_an_product_to_my_cart() {
        //add an product to the cart
        driver.findElement(By.xpath(element.addToCartButton)).click();
    }
    @Then("I delete the recent added product")
    public void i_delete_the_recent_added_product() {
        // delete the added product
        driver.findElement(By.xpath(element.accessTheCart)).click();
        driver.findElement(By.xpath(element.removeFromCartButton)).click();
    }
    @When("I check if the cart is empty")
    public void i_check_if_the_cart_is_empty() {
        // check the cart state after deletion
        driver.findElement(By.xpath(element.accessTheCart)).click();
        String cartState = driver.findElement(By.xpath(element.cartMessage)).getTagName();
        if (cartState.equals("p")){
            System.out.println("Scenario: Remove an product from cart");
            System.out.println("    Test Result: The was successfully deleted from the cart");
        }
    }
}
