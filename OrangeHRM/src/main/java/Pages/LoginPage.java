package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final By txtUsername = By.cssSelector("input[placeholder='username']");
    private final By txtPassword = By.cssSelector("input[placeholder='password']");
    private final By buttonLogin = By.xpath("//button[@type='submit']");
    private final By forgotPasswordLink = By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']");
    private final By alertErrorMessage = By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p");

    public LoginPage(WebDriver web_driver) {
        this.driver = web_driver;
    }

    public void enterUsername(String username){
        WebElement usernameBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(txtUsername));
        usernameBox.sendKeys(username);
    }

    public void enterPassword(String password){
        WebElement passwordBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(txtPassword));
        passwordBox.sendKeys(password);

    }

    public void clickLogin(){
        WebElement loginButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(buttonLogin));
        loginButton.click();
    }
    public void clickForgotPassword(){
        WebElement forgotLink = new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.elementToBeClickable(forgotPasswordLink));
        forgotLink.click();
    }
    public String getForgotPWDPageLink(){
        return driver.getCurrentUrl();
    }
    public void login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
    public String getErrorMsg(){
        WebElement errorPopUp = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(alertErrorMessage));

        return errorPopUp.getText();
    }

    public boolean getURL(String url){
        return driver.getCurrentUrl().equals(url);
    }


}
