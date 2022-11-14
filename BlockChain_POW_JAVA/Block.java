
// importing date to get timestamp
import java.util.Date;

// class block which is containing four parameters hash, prevoius hash, data and timestamp
// 1- hash is unique value for the block which calculated by calculatehash() function
// 2- previousHash is a hash for previous hash
// 3- data is a message must be transmitted
// 4- timestamp which is a unique value for each transaction (in miliseconds)
// 5- nonce which is an arbitrary number used in cryptography
public class Block {

	// defining attributes
	public String hash;
	public String previousHash;
	private String data;
	private long timeStamp;
	private int nonce;

	// constructor
	public Block(String data, String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		// generating a timestamp
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash();
	}

	// calculateHash function which is calculating hash value by encypt by SHA256
	// algorithm
	// and its is takeing in consederation : -previousHash, -timestamp, -data,
	// -nonce
	public String calculateHash() {
		String calculatedhash = Crypt.sha256(previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + data);
		return calculatedhash;
	}

	// mine block function
	// here the operation of prrof of work is executed
	// prefix is a number of digits we use in POW
	// prefixString is a String of zeros with length of prefix
	public String mineBlock(int prefix) {
		// defining prefix string
		String prefixString = new String(new char[prefix]).replace('\0', '0');
		// checks if first prefix digits of hash is equal to prefix string
		// this is a brute force search for needed hash
		// nonce is calculated after finding hash
		// this is called proof of work
		while (!hash.substring(0, prefix).equals(prefixString)) {
			nonce++;
			hash = calculateHash();
		}
		return hash;
	}

	// toString function
	public String toSting() {
		String s = "---------------------------\n";
		s += "hash : " + hash + "\n";
		s += "previousHash : " + previousHash + "\n";
		s += "data : " + data + "\n";
		s += "timeStamp : " + timeStamp + "\n";
		s += "nonce(proof of work) : " + nonce + "\n";
		s += "---------------------------\n";
		return s;
	}
}
// Thank you for reading my code
// regars : Muath Kasati
