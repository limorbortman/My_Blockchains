package entiteit

trait Blockchain {

  def newBlock(): Unit // Creates a new Block and adds it to the chain

  def newTransaction() : Unit //Creates a new transaction and adds it to the transactions

  def lastBlock () : Option[Block] //Returns the last Block in the chain

}

class BlockchainImpl(chain: Seq[Block] = Seq[Block](), transactions: Seq[Transaction] = Seq[Transaction]()) extends Blockchain {

  override def newBlock(): Unit = chain :+ new BlockImpl()

  override def newTransaction(): Unit = transactions :+ new TransactionImpl()

  override def lastBlock(): Option[Block] = chain.lastOption
}
