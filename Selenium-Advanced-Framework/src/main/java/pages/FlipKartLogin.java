package pages;

import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reports.ExtentLogger;

public final class FlipKartLogin extends BasePage {

    private final By usernameBox = By.xpath("(//div[@class='_2MlkI1']//input)[1]");

    private final By passwordBox = By.xpath("(//div[@class='_2MlkI1']//input)[2]");

    private final By loginButton = By.cssSelector("button[class='_2KpZ6l _2HKlqd _3AWRsL']");

    private final By invalidCredsError = By.id("spanMessage");

    public FlipKartLogin enterUsername(String usernameValue){
        sendKeys(usernameBox,usernameValue, WaitStrategy.PRESENCE,"Username");
        return this;
    }

    public FlipKartLogin enterPassword(String passwordValue){
        sendKeys(passwordBox,passwordValue,WaitStrategy.PRESENCE,"Password");
        return this;
    }

    public FlipKartHomePage clickLoginButton(){
        click(loginButton,WaitStrategy.CLICKABLE,"Login Button");
        return new FlipKartHomePage();
    }
    
    

    public String invalidCredsErrorText() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),10);
        wait.until(ExpectedConditions.elementToBeClickable(invalidCredsError));
        return getText(invalidCredsError,WaitStrategy.PRESENCE);
    }

}
