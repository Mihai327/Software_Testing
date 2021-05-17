package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class SortBySteps {
    WebDriver driver;
    ElementsPaths element = new ElementsPaths();
    ArrayList<Integer> order = new ArrayList<>();

    @Given("I go to the Men's wear - Accessories page")
    public void i_go_to_the_men_s_wear_accessories_page() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        //se navigheaza pe net catre site-ul indicat in variabila siteAddress
        driver.navigate().to(element.siteAddress);
        driver.findElement(By.xpath(element.menWearPage)).click();
        driver.findElement(By.xpath(element.menAccessories)).click();

    }
    @When("I check the Sort By name \\(A-Z option)")
    public void i_check_the_sort_by_name_a_z_option() {
        driver.findElement(By.xpath(element.sortByField)).click();
        driver.findElement(By.xpath(element.A_Z_Option)).click();
        String productName = driver.findElement(By.xpath(element.product_1)).getText();
        String productName2 = driver.findElement(By.xpath(element.product_2)).getText();
        order.add(productName.compareTo(productName2));
        String productName3 = driver.findElement(By.xpath(element.product_3)).getText();
        order.add(productName2.compareTo(productName3));
        String productName4 = driver.findElement(By.xpath(element.product_4)).getText();
        order.add(productName3.compareTo(productName4));
        String productName5 = driver.findElement(By.xpath(element.product_5)).getText();
        order.add(productName4.compareTo(productName5));
    }
    @Then("I get the sorting result")
    public void i_get_the_sorting_result() {
        for(int i=0; i<=4; i++){
            if(order.get(i) < 0){ //>0 - means that products ara not displayed alphabetically from a to z
                System.out.println("Scenario: Sort a product");
                System.out.println("    Test Result: The Sort By name from A to Z option doesn't work");
            }
            break;
        }

    }
}
