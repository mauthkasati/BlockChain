
// importing MessageDigest which is required
import java.security.MessageDigest;

// class crypt containing SHA256 ecryption algorithm
public class Crypt {
	// defining SHA256 function
	public static String sha256(String input) {
		// using try/catch to handle exceptions can be occured, exactly runtime
		// exception
		try {
			// sha is an object of tyoe MessageDigest
			MessageDigest sha = MessageDigest.getInstance("SHA-256");

			// i is just an itaration
			int i = 0;

			// sha encrypts an input in UTF-8 (encoding system for Unicode), and storing it
			// in an array of bytes
			byte[] hash = sha.digest(input.getBytes("UTF-8"));

			// hexHash is a hash in hexa_decimal
			StringBuffer hexHash = new StringBuffer();

			// iterating on hash array
			while (i < hash.length) {
				// hex is a hexa_decimal of every hash
				// anding hash with 0xff (256 in hexa_decimal) is to handle values more than 256
				String hex = Integer.toHexString(0xff & hash[i]);

				// appends zero if length() of string is one
				if (hex.length() == 1) {
					hexHash.append('0');
				}
				// other appends hex
				hexHash.append(hex);
				i++;
			}
			return hexHash.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
// Thank You for reading my code
// regards : Muath kasati
