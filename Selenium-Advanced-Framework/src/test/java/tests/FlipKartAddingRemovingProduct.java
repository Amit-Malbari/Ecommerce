package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import enums.ConfigProperties;
import pages.FlipKartHomePage;
import pages.FlipKartLogin;
import utils.ReadPropertyFile;

public final class FlipKartAddingRemovingProduct extends BaseTest {

    private FlipKartAddingRemovingProduct(){}
    FlipKartHomePage hp;
    @BeforeMethod
    public void beforeMethod() {
    	FlipKartLogin lp = new FlipKartLogin();
        lp.enterUsername(ReadPropertyFile.getValue(ConfigProperties.USERNAME))
                .enterPassword(ReadPropertyFile.getValue(ConfigProperties.PASSWORD))
                .clickLoginButton().searchBySearchBox("Shoe Rack");
    }
    
    @AfterMethod
    public void afterMethod() {
        hp.clickLogoutButton();
    }
    
    @Test(description="To check whether iteam can be added and removed from cart")
    public void addRemoveVerification() {
    	hp = new FlipKartHomePage();
    	hp.selectFirstProductDisplayed()
    	.AddToKartVerify()
    	.removeFromKartVerify();
    } 
    
}
