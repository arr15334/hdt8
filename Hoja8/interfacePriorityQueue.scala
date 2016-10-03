/**
  * Rodrigo Arriaza
  * Joice Miranda 
  */
trait interfacePriorityQueue[T] {
  def getFirst: T
  def remove(): T
  def add(value: T): Unit
  def isEmpty: Boolean
  def size(): Int
  def clear(): Unit
}
