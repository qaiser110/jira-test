package utils;

import org.apache.xml.utils.URI;
import org.apache.xml.utils.URI.MalformedURIException;

public class Utils {
	private Utils() {
		throw new AssertionError();
	}
	
	public static String getIssueKeyFromUri(String href) {
    	URI uri = null;
		try {
			uri = new URI(href);
		} catch (MalformedURIException e) {
			e.printStackTrace();
		}
    	String[] segments = uri.getPath().split("/");
    	return segments[segments.length-1];
    }
    


}
