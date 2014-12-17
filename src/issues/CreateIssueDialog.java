package issues;

import interfaces.IssueEditForm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.Page;

public class CreateIssueDialog extends Page
				implements IssueEditForm {

    public CreateIssueDialog(WebDriver driver) {
    	super(driver);
    	PageFactory.initElements(driver, this);
    }
    
    private WebElement summary;
    
    @FindBy(id = "create-issue-dialog")
    private WebElement createIssueDialog;
    
    @FindBy(id = "qf-create-another")
    private WebElement chkCreateAnother;
    
    @FindBy(id = "qf-field-picker-trigger")
    private WebElement configureButton;

    @FindBy(id = "create-issue-submit")
    private WebElement submitIssueButton;
    
    @FindBy(css = "#create-issue-dialog .buttons a.cancel")
    private WebElement cancelLink;
    
//    @FindBy(css = ".aui-message a.issue-link")
    @FindBy(css = ".aui-message.success > a")
    private WebElement successMsgLink;
   
    public CreateIssueDialog typeSummary(String value) {
    	clearFieldAndType(summary, value);
    	return this;
    }
    
	public WebElement getSummaryField() {
		return summary;
	}

    public boolean isCreateAnotherChecked() {
    	return chkCreateAnother.isSelected();
    }
    
    public CreateIssueDialog checkCreateAnother(boolean newVal) {
    	if (newVal != isCreateAnotherChecked())
    		chkCreateAnother.click();
    	return this;
    }
    
	public CreateIssueDialog submitByBtnClickAndCreateAnother() {
		checkCreateAnother(true);
		submitIssueButton.click();
		return this;
	}
	public CreateIssueDialog submitAndCreateAnother() {
		checkCreateAnother(true);
		submitIssueButton.click();
		return this;
	}
	public IssuesHomePage submitAndCloseDialog() {
		checkCreateAnother(false);
		submitIssueButton.click();
    	return PageFactory.initElements(_driver, IssuesHomePage.class);
	}

	public void clickSubmitButton() {
		submitIssueButton.click();
	}

	public void submitFromSummaryField() {
		summary.submit();
	}
	
	public IssueDetailPage clickSuccessMsgLink() {
		successMsgLink.click();
		return new IssueDetailPage(_driver);
	}

	public WebElement getSuccessMsgLink() {
		return new WebDriverWait(_driver, 10)
//			.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".aui-message-success a")));
        	.until(ExpectedConditions.elementToBeClickable(successMsgLink));
//		WebElement successMsg = fluentWait(By.cssSelector());
//		return successMsgLink;
	}
	
    public void clearFieldAndType(WebElement field, String value) {
    	field.clear();
    	field.sendKeys(value);
    }
    
	@Override
	public boolean hasSubmitButton() {
		return submitIssueButton.isDisplayed();
	}

	@Override
	public boolean hasCancelLink() {
		return cancelLink.isDisplayed();
	}

	@Override
	public boolean hasConfigButton() {
		return configureButton.isDisplayed();
	}

	@Override
	public WebElement getSubmitButton() {
		return submitIssueButton;
	}

	@Override
	public WebElement getCancelButton() {
		return cancelLink;
	}

}
