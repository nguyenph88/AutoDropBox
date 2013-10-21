import org.openqa.selenium.firefox.FirefoxProfile;

public class Main {
	public static void main(String[] args) {
		
		// Well, this is actually made to work with firefox only
		AutoDropBox main = new AutoDropBox();
		//main.Start();
		main.testUserAgent();
	}
}
