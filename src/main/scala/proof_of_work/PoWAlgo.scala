package proof_of_work

/**
  * Find the number p so when hashed its product with the previous block’s solution comes out a number that ends with 7
  */
class PoWAlgo {
  def giveSomeProf(lastProof: Long): Long = getProf(0, lastProof)

  def validProf(candidate: Long, lastProof: Long): Boolean = (candidate * lastProof).hashCode() % 10 == 7

  private def getProf(candidate: Long, lastProof: Long): Long = if (validProf(candidate, lastProof)) candidate else getProf(candidate + 1, lastProof)

}
