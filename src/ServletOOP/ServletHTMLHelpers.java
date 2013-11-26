package ServletOOP;
import javax.servlet.http.*;

public class ServletHTMLHelpers {
	//Time savers

	  public static String headWithTitle(String title) {
	    return("<!DOCTYPE html>\n" +
	           "<html>\n" +
	           "<head><title>" + title + "</title></head>\n");
	  }
}
