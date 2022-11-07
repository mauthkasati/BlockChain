// importing date to get timestamp
import java.util.Date;

// class block which is containing four parameters hash, prevoius hash, data and timestamp
// 1- hash is unique value for the block which calculated by calculatehash() function
// 2- previousHash is a hash for previous hash
// 3- data is a message must be transmitted
// 4- timestamp which is a unique value for each transaction (in miliseconds)
public class Block {
	// defining attributes
	public String hash;
	public String previousHash;
	private String data;
	private long timeStamp;
	
	// constructor
	public Block(String data, String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash();
	}
	
	// calculateHash function which is calculating hash value by encypt by SHA256 algorithm
	// and its is takeing in consederation : -previousHash, -timestamp, -data
	public String calculateHash() {
		String calculatedhash = crypt.sha256(previousHash + Long.toString(timeStamp) + data);
		return calculatedhash;
	}
	
	// toString function 
	@override
	public String toString() {
		String s = "---------------------------\n";
		s += "hash : " + hash + "\n";
		s += "previousHash : " + previousHash + "\n";
		s += "data : " + data + "\n";
		s += "timeStamp : " + timeStamp + "\n";
		s += "---------------------------\n";
		return s;
	}
}
// Thank you for reading my code
// regars : Muath Kasati
