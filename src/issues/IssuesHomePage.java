package issues;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Route;

import common.Page;

public class IssuesHomePage extends Page {

	public IssuesHomePage(WebDriver driver) {
    	super(driver);
    	_driver.get(Route.JIRA_TST_HOME);
        PageFactory.initElements(driver, this);        
    }
     
}
