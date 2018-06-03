package entiteit

case class Block(index : Long, timestamp: Long, transactions : Seq[Transaction], proof : Option[Long], previousHash : Long)
