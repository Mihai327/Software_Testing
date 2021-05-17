package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchSteps {
    WebDriver driver;
    ElementsPaths element = new ElementsPaths();

    @Given("I launch the browser")
    public void i_launch_the_browser() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @When("I open Elite Shoppy homepage")
    public void i_open_elite_shoppy_homepage() {
        //se navigheaza pe net catre site-ul indicat in variabila siteAddress
        driver.navigate().to(element.siteAddress);
    }

    @Then("I verify that the search field works")
    public void i_verify_that_the_search_field_works() {
        //se cauta search field-ul si se acceseaza
        driver.findElement(By.xpath(element.searchField)).sendKeys("jeans");
        //se transmite cuvantul care urmeaza a fi cautat, in casuta de cautare accesata anterior
        //se gaseste si se acceseaza butonul search pentru pornirea cautarii
        driver.findElement(By.xpath(element.searchButton)).click();

        String message;
        message = driver.findElement(By.xpath("/html/body/div/div/div[1]/h1")).getText();
        if (message.equals("Page Not Found")){
            System.out.println("Scenario: Search a product");
            System.out.println("    Test Result: The Search Field doesn't work");
        }
    }
}
