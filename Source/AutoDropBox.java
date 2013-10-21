
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoDropBox {
	private FirefoxProfile _ffp;
	private WebDriver _driver;
	private UserAgentList _userAgentList;

	
	public AutoDropBox(){
		this._ffp = new FirefoxProfile();
		this._userAgentList = new UserAgentList();
		setUserAgent();
		System.out.println(_userAgentList.getCurrentUserAgent() + " \nsize:" + _userAgentList.getUserAgentListSize());
		//_driver = new FirefoxDriver(_ffp);
	}
	
    public void Start(){    	
    	WebDriver driver = getDriver();

    	setUserAgent();
    	
    	// Initialize connection
        driver.get("http://www.dropbox.com");
        
        // show the hidden form
        WebElement signUpDummy = driver.findElement(By.name("register-submit-dummy"));
        signUpDummy.click();
        
        // Wait until everything becomes visible
        delay(500);
        
        // First name field
        WebElement firstName = driver.findElement(By.name("fname"));
        firstName.sendKeys("First Name Test");
        
        // First name field
        WebElement lastName = driver.findElement(By.name("lname"));
        lastName.sendKeys("Last Name Test");
        
        // Email field
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("email Test");
        
        // Password field
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("password Test");
                
        // TOS Checkbox
        WebElement tos = driver.findElement(By.name("tos_agree"));
        tos.click();
                
                
        delay(3000);
        //Close the browser
        driver.quit();
    }
    
    public void testUserAgent(){
    	WebDriver driver = this.getDriver();
    	driver.get("http://www.whatsmyuseragent.com");
    	
    	delay(5000);
    	driver.quit();
    }
    
    public void setUserAgent(){
    	_ffp.setPreference("general.useragent.override",
    	    	"Mozilla/5.0 (Windows Funny 6.1; rv:15.0) Gecko/20100101 Firefox/15.0");
    }
    
    public void delay(int ms){
    	try {
    		  Thread.sleep(ms);
    		} catch (InterruptedException ie) {
    		    //Handle exception
    		}
    }
    
    public WebDriver getDriver(){
    	return this._driver;
    }
    
    public FirefoxProfile getFFP(){
    	return this._ffp;
    }

}

