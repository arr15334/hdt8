/**
  * Rodrigo Arriaza
  * Joice Miranda 
  */
class Paciente(nombre: String, enfermedad: String, prioridad: String) extends Comparable[Paciente]{
 // declaracion de variables con valores ingresados
  var name: String = nombre
  var _enfermedad: String = enfermedad
  var priority: String = prioridad

  //def nombre(): String = name
  //def enfermedad(): String = _enfermedad
  //def prioridad(): String = priority

  
     /**
     * @param no param
     * @return String nombre, String enfermedad, String priority
     * Devuelve el nombre, enfermedad y prioridad de un paciente
     */      
  override def toString(): String = {
    var cadena = ""
    cadena = nombre+ ", " + enfermedad + ", " + prioridad
    cadena
  }

  /**
     * @param Paciente paciente
     * @return int prioridad 
     * Devuelve el nivel de prioridad del paciente
     */
  override def compareTo(o: Paciente): Int = {
    priority.compareTo(o.priority)
    //o.prioridad().compareTo(priority)
  }
}
