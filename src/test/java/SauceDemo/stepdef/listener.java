package SauceDemo.stepdef;


import SauceDemo.classPackage.Listener;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;

import static SauceDemo.classPackage.Listener.driver;


public class listener {
        Listener obj = new Listener();

        String url = "https://www.saucedemo.com/";
        @Given("Username and Password")
        public void username_and_password() {
            obj.setUp();
            driver.get(url);
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");

        }

        @Then("login to the website")
        public void login_to_the_website() {
            driver.findElement(By.id("login-button")).click();

        }

        @Given("Add product to the cart")
        public void add_product_to_the_cart() {
            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

        }

        @Then("Click on continue")
        public void clickOnContinue() {
            driver.findElement(By.xpath("(//button[@id='continue-shopping'])")).click();

        }

        @Given("Add another item")
        public void addAnotherItem()  {
            driver.findElement(By.xpath("(//button[@id='add-to-cart-sauce-labs-bolt-t-shirt'])")).click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

        }
        @Then("Checkout the product")
        public void checkout_the_product() {
            driver.findElement(By.id("checkout")).click();

        }

        @Given("Enter address information")
        public void enter_address_information() {
            driver.findElement(By.id("first-name")).sendKeys("Aaron");
            driver.findElement(By.id("last-name")).sendKeys("Tim");
            driver.findElement(By.id("postal-code")).sendKeys("632101");
            driver.findElement(By.id("continue")).click();
//            boolean cont = driver.findElement(By.id("continue")).isSelected();
//            Assert.assertEquals(cont,"continue");
        }

        @Then("Click Finish")
        public void click_finish() {
            driver.findElement(By.id("finish")).click();
//            boolean cont = driver.findElement(By.id("finish")).isSelected();
//            Assert.assertEquals(cont,"fish");
            driver.findElement(By.id("back-to-products")).click();

        }

        @Given("goto react button")
        public void goto_react_button()  {
            driver.findElement(By.xpath("(//button[contains(text(),'Open Menu')])")).click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        }

        @Then("click logout")
        public void click_logout() {
            if(driver.findElement(By.id("logout_sidebar_link")).isEnabled()){
                driver.findElement(By.xpath("(//a[@id='logout_sidebar_link'])")).click();

            }else {
                System.out.println("You need to logout now!!!");
            }        }



        @And("remove Item from cart")
        public void removeItemFromCart() {
            driver.findElement(By.xpath("(//button[@id='cancel'])")).click();
            driver.findElement(By.xpath("(//button[@id='remove-sauce-labs-backpack'])")).click();
            driver.findElement(By.id("checkout")).click();
        }

        @After
        public void tearDown(Scenario scenario){
            if(scenario.isFailed()){
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("failed Screenshot",new ByteArrayInputStream(screenshot));
            }
        }
    }


