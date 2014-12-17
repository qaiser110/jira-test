package interfaces;

import issues.SearchResultsPage;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface SearchResults {
    public SearchResultsPage findIssueByKey(String issueKey);
}
