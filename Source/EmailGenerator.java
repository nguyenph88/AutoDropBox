/**
 * Email generator based on first name _ last name
 */
import java.util.ArrayList;
import java.util.Random;


public class EmailGenerator {
    /**
     * Instances
     */
	private Random randomGenerator = new Random();
    private ArrayList<String> emailPostfix = new ArrayList<String>();
    
    /**
     * Constructor
     */
	public EmailGenerator(){
		initializePostfix();
	}
	
	/**
	 * initilize the array list which hold postfixes of email
	 */
	public void initializePostfix(){
		
		emailPostfix.add("@yahoo.com");
		emailPostfix.add("@gmail.com");
		emailPostfix.add("@qq.com");
		emailPostfix.add("@bbc.com");
		emailPostfix.add("@cnn.com");
		emailPostfix.add("@comcast.net");
		emailPostfix.add("@att.net");
	}
	
	/**
	 * Generate email addres based on first _ last name
	 * @param first: first name
	 * @param last: last name
	 * @return full email address
	 */
	public String generate(String first, String last){
		int index = randomGenerator.nextInt(emailPostfix.size());
		String full = first + last + randomGenerator.nextInt(500) + emailPostfix.get(index);
		return full;
	}
}
