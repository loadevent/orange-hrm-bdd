package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By txtUsername = By.xpath("//input[@placeholder='Username']");
    private By txtPassword = By.name("password");
    private By buttonLogin = By.xpath("//button[@type='submit']");
    private By forgotPasswordLink = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p");
    //private By alertErrorMessage = By.cssSelector("div[role='alert']");
    private By alertErrorMessage = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username){
        driver.findElement(txtUsername).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(buttonLogin).click();
    }
    public void clickForgotPassword(){
        driver.findElement(forgotPasswordLink).click();
    }
    public void login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
    public String getErrorMsg(){
        return driver.findElement(alertErrorMessage).getText();
    }

    public boolean getURL(String url){
        return driver.getCurrentUrl().equals(url);
    }
}
