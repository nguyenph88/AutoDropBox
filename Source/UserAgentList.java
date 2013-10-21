import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;


public class UserAgentList {
	private ArrayList<String> _userAgentList = new ArrayList<String>();
	private FileInputStream fstream;
	private String _currentUserAgent;
	
	
	public UserAgentList(){
		openFile();
		initializeList();
		randomizeUserAgent();
	}
	
	public void openFile(){
		try {
			fstream = new FileInputStream("UserAgents.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// This is when file is not Found
			e.printStackTrace();
		}
	}
	
	public void initializeList(){
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;

		//Read File Line By Line
		try {
			while ((strLine = br.readLine()) != null)   {
			  _userAgentList.add(strLine);
			}
		} catch (IOException e) {
			// cannot read file
			e.printStackTrace();
		}

		//Close the input stream
		try {
			br.close();
		} catch (IOException e) {
			// cannot close file
			e.printStackTrace();
		}
	}
	
	void randomizeUserAgent(){
		if (_userAgentList.isEmpty()){
			setCurrentUserAgent("Mozilla/5.0 (compatible; MSIE 8.0; Windows NT 6.0; Trident/4.0; Acoo Browser 1.98.744; .NET CLR 3.5.30729)");
		} else {
			Random r = new Random();
			int random = r.nextInt(getUserAgentListSize());
			setCurrentUserAgent(getUserAgentFromList(random));			
		}
	}
	
	String getRandomUserAgent(){
		if (_userAgentList.isEmpty()){
			return "Mozilla/5.0 (compatible; MSIE 8.0; Windows NT 6.0; Trident/4.0; Acoo Browser 1.98.744; .NET CLR 3.5.30729)";
		} else {
			Random r = new Random();
			int random = r.nextInt(getUserAgentListSize());
			return(getUserAgentFromList(random));			
		} 
	}
	
	int getUserAgentListSize(){
		return this._userAgentList.size();
	}
	
	String getUserAgentFromList(int where){
		return this._userAgentList.get(where);
	}
	
	ArrayList<String> getUserAgentList(){
		return this._userAgentList;
	}
	
	String getCurrentUserAgent(){
		return this._currentUserAgent;
	}
	
	void setCurrentUserAgent(String ua){
		this._currentUserAgent = ua;
	}
}
