package issues_tests;

import issues.CreateIssueDialog;
import issues.IssueDetailPage;
import issues.IssuesHomePage;
import issues.SearchResultsDetailViewPage;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Selenium;
import utils.Utils;

public class CreateIssueTests {

//	private final static WebDriver driver = new FirefoxDriver();
//	private final static WebDriver driver = new FirefoxDriver();
	private final static WebDriver driver = new FirefoxDriver();
	
//	private final static WebDriver driver = Selenium.getDriver();
	private CreateIssueDialog issueDialog;

	private Random rand;
	
	@Before
	public void setup() {
		driver.manage().window().maximize();
		IssuesHomePage homepage = new IssuesHomePage(driver);
		homepage.login();
		issueDialog = homepage.clickCreateIssueButton();
	}

	
//    @Test
//    public void testSummaryFieldAutoFocus(){
//
//    	Assert.assertTrue(
//				issueDialog.getSummaryField().equals(driver.switchTo().activeElement()));
//    }
//    
    @Test
    public void testCreateIssue(){
    	rand = new Random();
    	String title = "QA-Issue " + rand.nextInt(9999);
    	
    	issueDialog
			.typeSummary(title)
			.checkCreateAnother(true)
			.clickSubmitButton();
    	
//    	IssueDetailPage issueDetailPage = issueDialog.clickSuccessMsgLink();
//    	Assert.assertTrue(title.equals(issueDetailPage.getIssueSummaryText()));
    	
    	WebElement msgLink = issueDialog.getSuccessMsgLink();
//    	Assert.assertTrue(msgLink.getText().contains(title));
    	
    	String issueKey = Utils.getIssueKeyFromUri(msgLink.getAttribute("href"));
    	Assert.assertTrue(msgLink.getText().equals(issueKey + " - " + title));
    }
    

//    @Test
//    public void testCreateIssueAndCreateAnother(){
//    	rand = new Random();
//    	String ts = new java.text.SimpleDateFormat("dd-MM-yyyy h:mm:ss").format(new Date());
//    	String title = ts + " QA-Issue " + rand.nextInt(9999);
//    	String title2 = ts + " QA-Issue " + rand.nextInt(9999);
//    	
//    	issueDialog
//		    	.typeSummary(title)
//		    	.submitAndCreateAnother();
//    	
//    	new WebDriverWait(driver, 10)
//    		.until(ExpectedConditions.elementToBeClickable(By.id("create-issue-submit")));
//    	
//    	SearchResultsDetailViewPage 
//    			detailViewPage = issueDialog.typeSummary(title2)
//									    	.submitAndCloseDialog()
//									    	.searchFor(ts + " QA-Issue")
//									    	.switchToDetailView();
//    	
//    	List<WebElement> issuesFoundOnResultsPage = 
//    						detailViewPage.findIssuesBySummary(ts + " QA-Issue");
//    	
//    	Assert.assertEquals(2, issuesFoundOnResultsPage.size());
////    	dvResultsPage.advanceSearchFor("");
//    	
////-------------------------------------
//    	
////    	WebElement successMsgAnchor = issueDialog.getSuccessMsgLink();
////    	Assert.assertTrue(successMsgAnchor.getText().contains(title));
////    	
////    	String issueKey = Utils.getIssueKeyFromUri(msgLink.getAttribute("href"));
////    	Assert.assertTrue(msgLink.getText().contains(title));
////    	
////    	issueDialog
////	    	.typeSummary(title2)
////	    	.getSummaryField()
////	    	.submit();				// submit from the Summary field
//    	
////-------------------------------------
//	    	
////    	// confirm that both issues were successfully created
////    	SearchResultsDetailViewPage resultsPage = new SearchResultsDetailViewPage(driver);
////    	
////    	resultsPage.searchFor(ts + " QA-Issue");
////    	resultsPage.findIssueByKeyAndSummary(issueKey, title);
////    	
////    	Assert.assertTrue(issue. > 0);
//    }
    
    
    
    
//    @Test
//    public void testCreateIssueWithoutCreatingAnother(){
//    	rand = new Random();
//    	String title = "QA-Issue " + rand.nextInt(9999);
//    	
//    	SearchResultsDetailViewPage resultsPage = 
//    						 issueDialog.typeSummary(title)
//    									.submitAndCloseDialog()
//    									.searchFor(title)
//							    		.switchToDetailView();
//    	
////    	String issueKey = Utils.getIssueKeyFromUri(msgLink.getAttribute("href"));
//    	String firstSummary = resultsPage.getSummaryOfFirstSearchResult(title);
//
//    	Assert.assertEquals(title, firstSummary);
//    }
    
//	@AfterClass
//	public static void cleanUp() {
//		 driver.quit();
//	}

}




//public static IssueFormData info1 = new IssueFormData("myName1", "myCategory1");
//IssueFormData info2 = new IssueFormData("myName1", "myCategory1");
//
//info2.category = "blah";
//
//List<WebElement> elements = ((FindsById)driver).findElementsById("verifybutton");
//Assert.equals(1, elements.size());
//
// make sure there's one (and only one) element wit id ""
//Assert.assertEquals(1, 
//		driver.findElements(By.id("create_link")).size());
//
// Initiate the page object
//IssuesHomePage page = new IssuesHomePage(driver);
//
//CreateIssueDialog issueDialog = page.clickCreateIssueButton();
//
//Assert.assertTrue(
//		issueDialog.getSummaryField().equals(driver.switchTo().activeElement()));
//
//page.findText("blabla");
//assertTrue( page.size() > 0 );
//assertEquals(resultsPage.getTopResultTitle(), "Transition");
//assertThat(resultsPage.getTopResultTitle(), is("Transition"));
