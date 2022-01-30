package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.FlipKartLogin;
import utils.ExcelUtil;

public final class FlipKartLoginTest extends BaseTest {

    private FlipKartLoginTest(){}
    
    @Test(dataProvider = "data")
    public void loginTest(String username, String password, String verification) {
    	FlipKartLogin lp = new FlipKartLogin();
        lp.enterUsername(username)
                .enterPassword(password)
                .clickLoginButton()
                .verify(verification)
                .clickLogoutButton(verification);
    }
    
    
    @DataProvider
    public Object[][] data() {
    	return ExcelUtil.getData("LoginTest");
    }
}
