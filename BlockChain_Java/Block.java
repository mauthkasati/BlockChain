import java.util.Date;

public class Block {
	public String hash;
	public String previousHash;
	private String data;
	private long timeStamp;

	public Block(String data, String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash();
	}

	public String calculateHash() {
		String calculatedhash = crypt.sha256(previousHash + Long.toString(timeStamp) + data);
		return calculatedhash;
	}

	public String toSting() {
		String s = "---------------------------\n";
		s += "hash : " + hash + "\n";
		s += "previousHash : " + previousHash + "\n";
		s += "data : " + data + "\n";
		s += "timeStamp : " + timeStamp + "\n";
		s += "---------------------------\n";
		return s;
	}
}
