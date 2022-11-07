// importing needed collections
import java.util.ArrayList;

// main class to test blockchain
public class App {
        // blockchain is an arraylist or linkedlist of blocks
        public static ArrayList<Block> blockchain = new ArrayList<Block>();

        // isChainValid is aboolean functions which validate the correction of blockchaining operation
        public static Boolean isChainValid() {
                // defining current and previous block
                Block currentBlock;
                Block previousBlock;
                
                // iterating  on each block in blockchain to check validity
                for (int i = 1; i < blockchain.size(); i++) {
                        // setting a value of current and previous block
                        currentBlock = blockchain.get(i);
                        previousBlock = blockchain.get(i - 1);
                        
                        // here is the first case to returning false : if current hash not equals the 
                        // calculated hash , so return false
                        if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                                System.out.println("Hashes are not equal");
                                return false;
                        }
                        
                        // here is the second case to returning false : if curent hash equals previous hash
                        // and this is not true ( a hash is unique value for every block ), so return false
                        if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                                System.out.println("Previous Hashes are not equal");
                                return false;
                        }
                }
                // otherwise : return true
                return true;
        }

        // main function to test blockchain
        public static void main(String[] args) {
                
                // defining a messages or transations must be transmitted via blockchain,
                // and adding this messages to blocks
                // then adding the into blockchain
                blockchain.add(new Block("First block", "0"));
                blockchain.add(new Block("Second block", blockchain.get(blockchain.size() - 1).hash));
                blockchain.add(new Block("Third block", blockchain.get(blockchain.size() - 1).hash));
                blockchain.add(new Block("Fourth block", blockchain.get(blockchain.size() - 1).hash));
                blockchain.add(new Block("Fifth block", blockchain.get(blockchain.size() - 1).hash));

                // testing blockchain and show its content
                for (int i = 0; i < blockchain.size(); i++) {
                        System.out.println(blockchain.get(i).toString());
                }

                // check validity of blockchain
                System.out.println(isChainValid() ? "Your BlockChain is Valid" : "Your BlockChain is not valid");
        }
}
// thank you for reading my code 
// regards : Muath kasati
