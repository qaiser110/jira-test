package issues;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.Page;

public class IssueDetailPage extends Page {

	    public IssueDetailPage(WebDriver driver) {
	    	super(driver);
	    	PageFactory.initElements(driver, this);        
	    }
	    
	    @FindBy(id = "summary-val")
	    private WebElement issueSummaryHeader;
	    
		public String getIssueSummaryText() {
			return issueSummaryHeader.getText();
		}
		
	    public void getReportedBy() {
	    	
	    }
}
