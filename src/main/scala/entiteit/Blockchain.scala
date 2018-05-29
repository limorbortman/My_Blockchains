package entiteit

trait Blockchain {

  def newBlock(): Unit // Creates a new Block and adds it to the chain

  def newTransaction(sender: String, recipient: String, amount: Long): Long //Creates a new transaction and adds it to the transactions

  def lastBlock(): Option[Block] //Returns the last Block in the chain

}

class BlockchainImpl(chain: Seq[Block] = Seq[Block](), transactions: Seq[Transaction] = Seq[Transaction]()) extends Blockchain {

  override def newBlock(): Unit = chain :+ new Block()

  override def newTransaction(sender: String, recipient: String, amount: Long): Long = {
    transactions :+ new Transaction(sender, recipient, amount, chain.size - 1)
    chain.size
  }

  override def lastBlock(): Option[Block] = chain.lastOption
}
