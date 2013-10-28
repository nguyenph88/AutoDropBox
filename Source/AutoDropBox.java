

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class AutoDropBox {
	private FirefoxProfile _ffp;
	private WebDriver _driver;
	private UserAgentList _userAgentList;

	
	public AutoDropBox(){
		// doing nothing, otherwise it will pop up a lot of windows
	}
	
    public void Start(String url, String fName, String lName, String inputEmail, String inputPassword){
    	initializeProtocol();
    	
    	WebDriver driver = getDriver();

    	setUserAgent();
    	
    	// Initialize connection
        driver.get(url);
        
        // show the hidden form
        WebElement signUp = driver.findElement(By.name("register-submit-dummy"));
        
        // IMPORANTANT: unless this is non-referral link, do not click here.
        //signUp.click();
        
        // Wait until everything becomes visible
        delay(500);
        
        // First name field
        WebElement firstName = driver.findElement(By.name("fname"));
        firstName.sendKeys(fName);
        
        // First name field
        WebElement lastName = driver.findElement(By.name("lname"));
        lastName.sendKeys(lName);
        
        // Email field
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(inputEmail);
        
        // Password field
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys(inputPassword);
                
        // TOS Checkbox
        WebElement tos = driver.findElement(By.name("tos_agree"));
        tos.click();
        
        // Now click the register button
        signUp.click();
        
        // Hang around a bit
        delay(750);
        //Close the browser
        driver.quit();
    }
    
    public void initializeProtocol(){
    	this._ffp = new FirefoxProfile();
		this._userAgentList = new UserAgentList();
		setUserAgent();
		_driver = new FirefoxDriver(_ffp);
    }
    
    public void testSockProxy(){
        _ffp.setPreference("network.proxy.socks", "121.14.46.222");
        _ffp.setPreference("network.proxy.socks_port", 1080);
        _ffp.setPreference("network.proxy.type", 1);         // this is used to set proxy configuration to manual, after which firefox considers the //proxy set above

        WebDriver driver = new FirefoxDriver(_ffp);
        driver.get("http://www.whatsmyuseragent.com");
        delay(5000);
    	driver.quit();
    }
    
    public void testUserAgent(){
    	WebDriver driver = this.getDriver();
    	driver.get("http://www.whatsmyuseragent.com");
    	
    	delay(5000);
    	driver.quit();
    }
    
    public void setUserAgent(){
    	_ffp.setPreference("general.useragent.override", getRandomUserAgent());
    }
    
    String getRandomUserAgent(){
    	return this._userAgentList.getRandomUserAgent();
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

