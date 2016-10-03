import java.util
//import java.util.Vector

//
  // Rodrigo Arriaza
  // Joice Miranda 
  //
  
class VectorHeap[T <: Comparable[T] ] extends interfacePriorityQueue[T]{
  protected var data : util.Vector[T] = new util.Vector[T]()

    //
     //  param no param 
     //  return  E 
     // devuelce el valor minino del priority queue
     //
  override def getFirst: T = {
    data.firstElement()
  }

    //
     //  param no param 
     //  return  E minVal
     // devuelve y retira el valor minino del queue
     //
  override def remove(): T = {
    val minVal: T = getFirst
    data.set(0,data.get(data.size()-1))
    data.setSize(data.size()-1)
    if (data.size() > 1) pushDownRoot(0)
    minVal
  }

	//
     //  param E value 
     //  return  no return 
     // agrega valor al priority queue
     //   
  override def add(value: T): Unit = {
    data.add(value)
    percolateUp(data.size()-1)
  }

    //
     //  param no param 
     //  return  boolean inf
     // informa si esta lleno el vector 
     //
  override def isEmpty: Boolean = {
    data.isEmpty
  }

     //
     //  param no param 
     //  return  int tam
     // devuelve el tamanno del vecto
     //
  override def size(): Int = {
    data.size()
  }

     //  param no param
     //  
     // borra los datos de cola y data  
     // 
  override def clear(): Unit = {
    data.clear()
  }
  
    //
     //  param int i 
     //  return int i
     // Devuelve el numero de ubicacion del padre del nodo i
     //  
  def parent(i: Int): Int = {
    (i-1)/2
  }
  
  //
     //  param int i
     //  return int 
     // Devuelve el numero de ubicacion del nodo hijo izquierdo del nodo i 
     //  
  def left(i: Int): Int= {
    2*i+1
  }
  
   //
     //  param int i
     //  return int 
     // Devuelve el numero de ubicacion del nodo hijo derecho del nodo i 
     // 
  def right(i: Int): Int = {
    (2*i+1)+1
  }
  
   //
     //  param int leaf
     //  return  no return 
     // mueve al nodo a la ubicacion correcta 
     //     
  def percolateUp(leaf: Int) = {
    var _parent : Int = parent(leaf)
    val value : T = data.get(leaf)
    var _leaf : Int = leaf
    while (_leaf > 0 &&
      (value.compareTo(data.get(_parent)) < 0))
    {
      data.set(_leaf,data.get(_parent))
      _leaf = _parent
      _parent = parent(_leaf)
    }
    data.set(_leaf,value)
  }
  
  
	//
     //  param int root
     //  return  no return 
     // mueve al nodo raíz índice de abajo a la posición adecuada en el subárbol
     // 
  def pushDownRoot(root : Int) : Unit ={
    val heapSize: Int = data.size()
    val value: T = data.get(root)
    var _root: Int = root
    while (_root < heapSize) {
      var childpos: Int = left(_root)
      if (childpos < heapSize)
      {
        if ((right(_root) < heapSize) &&
          (data.get(childpos + 1).compareTo(data.get(childpos)) < 0))
        {
          childpos=childpos+1
        }
        // Assert: childpos indexes smaller of two children
        if (data.get(childpos).compareTo(value) < 0)
        {
          data.set(_root,data.get(childpos))
          _root = childpos; // keep moving down
        } else { // found right location
          data.set(_root,value)
          return
        }
      } else { // at a leaf! insert and halt
        data.set(_root,value)
        return
      }
    }
  }
}
