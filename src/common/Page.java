package common;


import issues.CreateIssueDialog;
import issues.SearchResultsPage;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class Page {
    
	protected WebDriver _driver;
	
	boolean isLoggedIn = false;

	public Page(WebDriver driver){
        this._driver = driver;
    }
	
    @FindBy(className = "login-link")
    WebElement loginLink;
    
    @FindBy(id = "quickSearchInput")
    private WebElement searchBox;
    
    @FindBy(id = "create_link")
    private WebElement createIssueButton;

    @FindBy(id = "create-issue-dialog")
    private WebElement createIssueDialog;
    
    public SearchResultsPage searchFor(String text) {
    	searchBox.sendKeys(text);
    	searchBox.submit();
    	return PageFactory.initElements(_driver, SearchResultsPage.class);
    }
    
    public CreateIssueDialog clickCreateIssueButton(){
    	createIssueButton.click();
    	
    	new WebDriverWait(_driver, 30)
                .until(ExpectedConditions.visibilityOf(createIssueDialog));
        return PageFactory.initElements(_driver, CreateIssueDialog.class);
    }

	public boolean login() {
		if(isLoggedIn || isLoggedIn()) {
			return true;
		}
		
		_driver.findElement((By.className("login-link"))).click();
		new WebDriverWait(_driver, 30)
			.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
		
		LoginPage loginPage = new LoginPage(_driver);
		isLoggedIn = loginPage.login();
		
		return isLoggedIn;
	}
	
	public boolean isLoggedIn() {
		isLoggedIn = _driver.findElements(By.className("login-link")).isEmpty();
		return isLoggedIn;
	}
	
	public String getFirstH1(){
		return _driver.findElement(By.xpath("/html/body/h1")).getText();
	}
	
	public boolean isTitle(String title){
		return title.equals(_driver.getTitle());
	}
	
	void throwIfTitleNot(String title){
		if (!isTitle(title)) {
			throw new IllegalStateException("This page title is not: " + title);
		}
	}
	
	void goToPageIfTitleNot(String title, String url){
		if (!isTitle(title)) {
			_driver.get(url);
		}
	}

	WebElement getWhenExists(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(_driver, timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
    WebElement fluentWait(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(_driver)
                .withTimeout(60, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement el = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });

        return  el;
    };
    
	void clearAndType(WebElement field, String text) {
	    field.clear();
	    field.sendKeys(text);
	}
}
