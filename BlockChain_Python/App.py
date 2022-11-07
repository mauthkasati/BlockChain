# hashlib is module implements a common interface to many different secure hash and message digest algorithms.
import hashlib

# class Block which has four parameters transaction_list, previous_block_hash, block_data and block_hash
# 1- transaction_list is a list of messages or transactions we want to sned via blockchain
# 2- hash is a hash value for the current block
# 3- previous_block_hash is a hash value of previous block
# 4- block_data is a collection of transactions with previous hash
# note 1 : here i don't use a timestamp to calculate hash, just data and previous hash
# note 2 : i don't use timestamp in hashing because i don't know if it is take in consedration automatecly by functions or not
# Question : please explain the previous point? I will remind you in the lecture.
class Block:
    def __init__(self, previous_block_hash, transaction_list):
        self.previous_block_hash = previous_block_hash
        self.transaction_list = transaction_list

        self.block_data = "-".join(transaction_list)+"-"+previous_block_hash
        self.block_hash = hashlib.sha256(self.block_data.encode()).hexdigest()
        
# here I defined a transactions must be transmitted
t1 = "Muath sends 2 EC to Ali"
t2 = "Muath sends 3 EC to Mohammad"
t3 = "Abdullah sends 4.5 EC to Ali"
t4 = "Omar sends 2.9 EC to Shaker"
t5 = "Rami sends 19.1 EC to Samer"

# this is a blockchain which is a list of blocks
blockChain = []

# I devided transactions into three blocks as following 
initial_block = Block("start", [t1, t2])
second_block = Block(initial_block.block_hash, [t3])
third_block = Block(second_block.block_hash, [t4, t5])

# adding blocks into blockchain
blockChain.append(initial_block)
blockChain.append(second_block)
blockChain.append(third_block)

# testing of blockchain and print its content
for b in blockChain:
    print('---------------------------')
    print('\n')
    print(b.block_data)
    print('\n')
    print(b.block_hash)

# Thank you for reading my code and notes
# I wish I get a good mark
# regards : Muath Kasati
