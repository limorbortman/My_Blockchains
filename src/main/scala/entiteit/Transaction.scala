package entiteit

case class Transaction(sender: String, recipient: String, amount: Long, blockIndex : Long)
