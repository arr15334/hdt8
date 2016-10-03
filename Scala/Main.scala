import scala.collection.mutable
import scala.io.Source

/**
  * Rodrigo Arriaza
  * Joice Miranda 
  */
object Main {
	// se declaran las variables 
    var lacola: mutable.PriorityQueue[Paciente] = new mutable.PriorityQueue[Paciente]()
    var elheap: VectorHeap[Paciente] = new VectorHeap()

//metodo para crear una ficha de paciente leyendo el archivo de texto
// param no parametros
// return no retunr		
  def crearFicha()= {
    val filename = "pacientes.txt"
    for (line <- Source.fromFile(filename).getLines) {
      val palabras: Array[String] = line.split(", ")
      val elpaciente: Paciente = new Paciente(palabras(0), palabras(1), palabras (2))
      lacola.+=(elpaciente)
    }
  }
  //metodo para mostrar la ficha del paciente
  // param no parametros
  // return no retunr
  def mostrarFicha()= {
    val j : Int = lacola.size-1
    val lacola2: mutable.PriorityQueue[Paciente] = lacola.reverse //es necesario guardarlo al reves, porque en scala dequeue funciona al reves que en java
    //var i : Int = 0
    for ( i <- 0 to j) {

      println(lacola2.dequeue().toString())
    }
  }
  //usando implementacion vector heap
  // param no parametros
  // return no retunr
  def crearVFicha()= {
    val filename = "pacientes.txt"
    for (line <- Source.fromFile(filename).getLines) {
      val palabras: Array[String] = line.split(", ")
      val elpaciente: Paciente = new Paciente(palabras(0), palabras(1), palabras (2))
      elheap.add(elpaciente)
    }
  }
  
  //metodo que muestra la ficha del paciente utilizando vector heap
  def mostrarvFicha()= {
    val j : Int = elheap.size()-1
    for ( i <- 0 to j) {
      println(elheap.remove().toString())
    }
  }

  def main(args: Array[String]): Unit = {
    println("Usando la coleccion de Scala")
    crearFicha()
    mostrarFicha()
    println("")
    println("Usando Vector Heap")
    crearVFicha()
    mostrarvFicha()
  }
}
