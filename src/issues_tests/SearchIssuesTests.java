package issues_tests;

import issues.CreateIssueDialog;
import issues.IssuesHomePage;
import issues.SearchResultsPage;

import java.util.Random;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.Utils;

public class SearchIssuesTests {
	
//	private final static WebDriver driver = new HtmlUnitDriver();
	private final static WebDriver driver = new FirefoxDriver();
	
	private CreateIssueDialog issueDialog;

	private Random rand;
	
	@Before
	public void setup() {
		driver.manage().window().maximize();
		IssuesHomePage homepage = new IssuesHomePage(driver);
		homepage.login();
		issueDialog = homepage.clickCreateIssueButton();
	}

	
    @Test
    public void testSearchIssueById() {
    	rand = new Random();
    	String title = "QA-Issue " + rand.nextInt(9999);
    	
    	issueDialog
			.typeSummary(title)
			.checkCreateAnother(true)
			.clickSubmitButton();
    	
    	WebElement msgLink = issueDialog.getSuccessMsgLink();
    	String issueKey = Utils.getIssueKeyFromUri(msgLink.getAttribute("href"));
    	
    	SearchResultsPage resultsPage = new SearchResultsPage(driver)
    											.searchIssueByKey(issueKey);
		
		Assert.assertEquals(title,
							resultsPage.getSummaryOfFirstSearchResult(title));    	
    }
    
    @Test
    public void testSearchIssueBySummary() {
    	rand = new Random();
    	String title = "QA-Issue " + rand.nextInt(9999);
    	
    	SearchResultsPage resultsPage = issueDialog
    			.typeSummary(title)
    			.submitAndCloseDialog()
    			.searchFor(title);
    	resultsPage.switchToDetailView();
    	
    	Assert.assertEquals(title,
    			resultsPage.getSummaryOfFirstSearchResult(title));
    }
    
	@AfterClass
	public static void cleanUp() {
		 driver.quit();
	}

}