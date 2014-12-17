package issues;

import interfaces.SearchResults;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsListViewPage extends SearchResultsPage  
										implements SearchResults {

	public SearchResultsListViewPage(WebDriver driver) {
		super(driver);
		switchToListView();
		PageFactory.initElements(driver, this);
	}

	@Override
	public SearchResultsListViewPage findIssueByKey(String issueKey) {
		// TODO Auto-generated method stub
		return null;
	}


}
