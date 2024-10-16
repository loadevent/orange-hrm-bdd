package stepsdefinition;

import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginPageStepDef {
    private static WebDriver driver;
    private LoginPage loginPage;
    @Before
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterAll
    public static void terminate(){
        if (driver != null) driver.quit();
    }
    @Given("I am on the login page")
    public void i_am_on_the_login_page(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(driver);
    }
    @Given("I have entered valid username and password")
    public void i_have_entered_valid_username_and_password(){
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
    }
    @When("I click on the login button")
    public void I_click_on_the_login_button(){
        loginPage.clickLogin();
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
        Assert.assertTrue(loginPage.getURL(
                "https://opensource-demo.orangehrmlive.com/dashboard/index"));
    }

    @Given("I have entered invalid {string} and {string}")
    public void iHaveEnteredInvalidAnd(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @Then("I should see an error message indicating {string}")
    public void iShouldSeeAnErrorMessageIndicating(String error_msg) {
        Assert.assertEquals(loginPage.getErrorMsg(),error_msg);
    }

    @When("I click on the Forgot Password link")
    public void iClickOnTheForgotPasswordLink() {
        loginPage.clickForgotPassword();
            }

    @Then("I should be redirected to the password reset page")
    public void iShouldBeRedirectedToThePasswordResetPage() {
        Assert.assertEquals(loginPage.getForgotPWDPageLink(),
                "https://opensource-demo.orangehrmlive.com/auth/requestPasswordResetCode");
    }
}
