package entiteit

import java.util.Date

case class Block(index : Long, timestamp: Date, transactions : Seq[Transaction], proof : Option[Long], previousHash : Long)
