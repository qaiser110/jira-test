package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	private final String userId = "qaiser110@gmail.com";
	private final String pwd = "qais0001";

    public LoginPage(WebDriver driver) {
    	this.driver = driver;
        PageFactory.initElements(driver, this);        
    }
    
    private WebElement username;
    private WebElement password;
    
    @FindBy(id = "login-submit")
    private WebElement submitBtn;

	public boolean login() {
		username.clear();
		username.sendKeys(userId);
		password.clear();
		password.sendKeys(pwd);
		password.submit();
		
		return true;
	}
    
    
}
