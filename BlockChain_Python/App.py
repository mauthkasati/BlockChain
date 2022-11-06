import hashlib

class Block:
    def __init__(self, previous_block_hash, transaction_list):
        self.previous_block_hash = previous_block_hash
        self.transaction_list = transaction_list

        self.block_data = "-".join(transaction_list)+"-"+previous_block_hash
        self.block_hash = hashlib.sha256(self.block_data.encode()).hexdigest()

t1 = "Muath sends 2 EC to Ali"
t2 = "Muath sends 3 EC to Mohammad"
t3 = "Abdullah sends 4.5 EC to Ali"
t4 = "Omar sends 2.9 EC to Shaker"
t5 = "Rami sends 19.1 EC to Samer"

blockChain = []

initial_block = Block("start", [t1, t2])
second_block = Block(initial_block.block_hash, [t3])
third_block = Block(second_block.block_hash, [t4, t5])

blockChain.append(initial_block)
blockChain.append(second_block)
blockChain.append(third_block)

#print(initial_block.block_data)

for b in blockChain:
    print('---------------------------')
    print('\n')
    print(b.block_data)
    print('\n')
    print(b.block_hash)
