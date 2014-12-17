package interfaces;

import org.openqa.selenium.WebElement;

public interface Form {
	
	boolean hasSubmitButton();
	boolean hasCancelLink();

	WebElement getSubmitButton();
	WebElement getCancelButton();
	
}
