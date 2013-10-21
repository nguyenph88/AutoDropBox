import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;


public class SockList {
	private ArrayList<String> _sockList = new ArrayList<String>();
	private FileInputStream fstream;
	private String _currentSock;
	private String _sockIP;
	private int _sockPort;
	
	
	public SockList(){
		openFile();
		initializeList();
		randomizeSockList();
	}
	
	public void openFile(){
		try {
			fstream = new FileInputStream("Socks.txt");
		} catch (FileNotFoundException e) {
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
			  _sockList.add(strLine);
	
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

	
	void randomizeSockList(){
		Random r = new Random();
		int random = r.nextInt(getSockListSize());
		setCurrentSock(getSockFromList(random));			
	}
	
	String getRandomSock(){
		Random r = new Random();
		int random = r.nextInt(getSockListSize());
		return(getSockFromList(random));			
		 
	}
	
	int getSockListSize(){
		return this._sockList.size();
	}
	
	String getSockFromList(int where){
		return this._sockList.get(where);
	}
	
	ArrayList<String> getSockList(){
		return this._sockList;
	}
	
	String getCurrentSock(){
		return this._currentSock;
	}
	
	void setCurrentSock(String ua){
		this._currentSock = ua;
	}
	
	String getSockIP(){
		return this._sockIP;
	}
	
	int getSockPort(){
		return this._sockPort;
	}
	
	void splitSock(String sock){
		if (sock.contains(":")) {
			String[] parts = sock.split(":");
			this._sockIP = parts[0]; // IP
			this._sockPort = Integer.parseInt(parts[1]); // PORT
		} else {
		    throw new IllegalArgumentException("Not a valid sock");
		}
	}
}
