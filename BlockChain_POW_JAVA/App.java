
// importing needed collections
import java.util.ArrayList;

// main class to test blockchain
public class App {
        // blockchain is an arraylist or linkedlist of blocks
        public static ArrayList<Block> blockChain = new ArrayList<>();

        // isChainValid is aboolean functions which validate the correction of
        // blockchaining operation
        public static Boolean isChainValid() {
                // defining current and previous block
                Block currentBlock;
                Block previousBlock;

                // iterating on each block in blockchain to check validity
                for (int i = 1; i < blockChain.size(); i++) {
                        currentBlock = blockChain.get(i);
                        previousBlock = blockChain.get(i - 1);

                        // here is the first case to returning false : if current hash not equals the
                        // calculated hash , so return false
                        if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                                System.out.println("Hashes are not equal");
                                return false;
                        }
                        // here is the second case to returning false : if curent hash equals previous
                        // hash
                        // and this is not true ( a hash is unique value for every block ), so return
                        // false
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
                // defining prefix and prefix string equals to 4, "0000" as test
                int prefix = 4;
                String prfixString = "0000";

                // adding first block after do POW
                Block firstBlock = new Block("Muath Sends 1 $ to Bitcoin",
                                "0000");
                firstBlock.mineBlock(prefix);
                if (firstBlock.calculateHash().substring(0, prefix).equals(prfixString)) {
                        blockChain.add(firstBlock);
                } else {
                        System.out.println("the block can't be mined");
                }

                // adding second block after do POW
                Block secondBlock = new Block("Muath Sends 2 $ to Bitcoin",
                                blockChain.get(blockChain.size() - 1).calculateHash());
                secondBlock.mineBlock(prefix);
                if (secondBlock.calculateHash().substring(0, prefix).equals(prfixString)) {
                        blockChain.add(secondBlock);
                } else {
                        System.out.println("the block can't be mined");
                }

                // adding third block after do POW
                Block thirdBlock = new Block("Muath Sends 3 $ to Bitcoin",
                                blockChain.get(blockChain.size() - 1).calculateHash());
                thirdBlock.mineBlock(prefix);
                if (thirdBlock.calculateHash().substring(0, prefix).equals(prfixString)) {
                        blockChain.add(thirdBlock);
                } else {
                        System.out.println("the block can't be mined");
                }

                // testing blockchain and show its content
                for (int i = 0; i < blockChain.size(); i++) {
                        System.out.println(blockChain.get(i).toSting());
                }
                System.out.println("----------------------------------------------");

                // check validity of blockchain
                System.out.println(isChainValid() ? "Your BlockChain is Valid" : "Your BlockChain is not valid");
        }
}
