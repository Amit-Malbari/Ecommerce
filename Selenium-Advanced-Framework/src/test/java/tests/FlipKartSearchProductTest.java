package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import enums.ConfigProperties;
import pages.FlipKartHomePage;
import pages.FlipKartLogin;
import utils.ReadPropertyFile;

public final class FlipKartSearchProductTest extends BaseTest {

    private FlipKartSearchProductTest(){}
    FlipKartHomePage hp;
    @BeforeMethod
    public void beforeMethod() {
    	FlipKartLogin lp = new FlipKartLogin();
        lp.enterUsername(ReadPropertyFile.getValue(ConfigProperties.USERNAME))
                .enterPassword(ReadPropertyFile.getValue(ConfigProperties.PASSWORD))
                .clickLoginButton();
    }
    
    @AfterMethod
    public void afterMethod() {
        hp.clickLogoutButton();
    }
    
    @Test(description="To check whether searched item is displayed more than 0")
    public void searchProductBySearchBox() {
    	hp = new FlipKartHomePage();
    	Assert.assertNotEquals(0,hp.searchBySearchBox("Shoe Rack")
    	    	.listOfItemsDisplayedOnPage());
    }
    
    @Test(description="To check whether searched item is displayed more than 0")    
    public void searchProductByMenu() {
    	hp = new FlipKartHomePage();
    	Assert.assertNotEquals(0,hp.searchByMenu()
    	    	.listOfItemsDisplayedOnPage());
    }
        
}
