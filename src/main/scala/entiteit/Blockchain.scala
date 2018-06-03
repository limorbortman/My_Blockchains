package entiteit

trait Blockchain {

  def newBlock(proof : Option[Long], previousHash : Option[Long]): Block // Creates a new Block and adds it to the chain

  def newTransaction(sender: String, recipient: String, amount: Long): Long //Creates a new transaction and adds it to the transactions

  def lastBlock(): Option[Block] //Returns the last Block in the chain

}

class BlockchainImpl(chain: Seq[Block] = Seq[Block](), transactions: Seq[Transaction] = Seq[Transaction]()) extends Blockchain {

  override def newBlock(proof : Option[Long], previousHash : Option[Long]): Block = {
    val prev = chain.last
    val newBlock = Block(chain.size + 1, System.currentTimeMillis(), transactions, proof, previousHash.getOrElse(prev.hashCode()))
    chain :+ newBlock
    transactions diff transactions //Reset the current list of transactions
    newBlock
  }

  override def newTransaction(sender: String, recipient: String, amount: Long): Long = {
    transactions :+ Transaction(sender, recipient, amount, chain.size - 1)
    chain.size
  }

  override def lastBlock(): Option[Block] = chain.lastOption
}
