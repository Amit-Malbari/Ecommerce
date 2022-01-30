package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driver.DriverManager;
import enums.ConfigProperties;
import enums.WaitStrategy;
import utils.ReadPropertyFile;

public final class FlipKartHomePage extends BasePage {

    private final By userLink = By.xpath("//div[@class='_1psGvi _3BvnxG']//div[text()="+ReadPropertyFile.getValue(ConfigProperties.USER)+"]");

    private final By logoutButton = By.linkText("Logout");
    
    private final By ErrorMessage= By.className("_2YULOR");
    
    private final By searchBox= By.name("q");
    
    private final By searchButton= By.className("L0Z3Pu");
    
    private final By HomeAppliance= By.linkText("Home");

    private final By kidsFurniture= By.linkText("Kids Furniture");
    
    private final By shoeRack= By.linkText("Shoe Racks");
    
    private final By itemsListed= By.className("_4ddWXP");
    
    private final By addToCart= By.className("_1KOMV2");
    
    private final By namrOfProduct= By.className("B_NuCI");
    
    private final By namrOfProductKart= By.className("_2-uG6-");
   
    private final By remove= By.xpath("//div[text()='Remove']");
    
    private final By cartEmptyMessage= By.xpath("//div[text()='Your cart is empty!']");
    
    public FlipKartHomePage verify(String verification)
    {	
    	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),10);
    	switch(verification){    
    	case "InvalidEmailID":    
    	 //code to be executed;  
            Assert.assertEquals("Please enter valid Email ID/Mobile number", getText(ErrorMessage, WaitStrategy.PRESENCE));
            break;  //optional  
    	case "IncorrectPassword":
            Assert.assertEquals("Your username or password is incorrect", getText(ErrorMessage, WaitStrategy.PRESENCE));
    	 //code to be executed;    
            break;  //optional 
    	case "EmptyEmailID":  
            Assert.assertEquals("Please enter valid Email ID/Mobile number", getText(ErrorMessage, WaitStrategy.PRESENCE));
       	 //code to be executed;    
            break;  //optional 
    	case "EmptyPassword":    
    		Assert.assertEquals("Please enter Password", getText(ErrorMessage, WaitStrategy.PRESENCE));
          	 //code to be executed;    
          	break;  //optional 
    	case "CorrectCredentials":    
       	 //code to be executed;  
            wait.until(ExpectedConditions.elementToBeClickable(userLink));
       	 	break;  //optional  
    	    
    	}    
    	return this;
    	
    }

    public FlipKartLogin clickLogoutButton(String verification) {
    	switch(verification){    
    	case "CorrectCredentials":    
       	 //code to be executed;  
    		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),10);
            wait.until(ExpectedConditions.elementToBeClickable(userLink));
            hover(userLink, WaitStrategy.PRESENCE);
            click(logoutButton,WaitStrategy.CLICKABLE,"Logout Button");
            break;
    	default:DriverManager.getDriver().navigate().refresh();
    	} 
    	return new FlipKartLogin();
    }
    
    public FlipKartLogin clickLogoutButton() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),10);
        wait.until(ExpectedConditions.elementToBeClickable(userLink));
        hover(userLink, WaitStrategy.PRESENCE);
        click(logoutButton,WaitStrategy.CLICKABLE,"Logout Button");
        return new FlipKartLogin();
    }
    
    
    public FlipKartHomePage searchBySearchBox(String item) {
    	DriverManager.getDriver().navigate().refresh();
    	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),10);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        sendKeys(searchBox, item, WaitStrategy.PRESENCE, "Search Box");
        click(searchButton, WaitStrategy.PRESENCE, "Search Button");
    	return this;
    }
    
    public FlipKartHomePage searchByMenu() {
    	DriverManager.getDriver().navigate().refresh();
    	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),10);
        wait.until(ExpectedConditions.elementToBeClickable(HomeAppliance));
        hover(HomeAppliance, WaitStrategy.PRESENCE);
        hover(kidsFurniture, WaitStrategy.PRESENCE);
        click(shoeRack, WaitStrategy.PRESENCE, "Shoe Rack Menu");
    	return this;
    }
    
    public int listOfItemsDisplayedOnPage() {
    	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),10);
        wait.until(ExpectedConditions.elementToBeClickable(itemsListed));
        return DriverManager.getDriver().findElements(itemsListed).size();
    }
    
    public FlipKartHomePage selectFirstProductDisplayed() {
    	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),10);
        wait.until(ExpectedConditions.elementToBeClickable(itemsListed));
        DriverManager.getDriver().findElements(itemsListed).get(0).click();
        switchToChildWindow();
        return this;
    }
    
    public FlipKartHomePage AddToKartVerify() {
    	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),10);
        wait.until(ExpectedConditions.elementToBeClickable(addToCart));
        String name1=getText(namrOfProduct, WaitStrategy.PRESENCE);
        click(addToCart, WaitStrategy.PRESENCE, "Add To Cart button");
        String name2=getText(namrOfProductKart, WaitStrategy.PRESENCE);
        if(!name1.contains(name2)) Assert.fail("Name of Product does not match");
        return this;
    }
    
    public FlipKartHomePage removeFromKartVerify() {
    	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),10);
        wait.until(ExpectedConditions.elementToBeClickable(remove));
        click(remove, WaitStrategy.PRESENCE, "Remove button");
        click(remove, WaitStrategy.PRESENCE, "Remove button");
        wait.until(ExpectedConditions.elementToBeClickable(cartEmptyMessage));
        Assert.assertEquals(0, DriverManager.getDriver().findElements(namrOfProductKart).size());
        return this;
    }
}
