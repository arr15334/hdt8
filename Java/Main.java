
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;


/**
 *
 * @author Rodrigo Arriaza;
 */
public class Main {
    static VectorHeap<Paciente> elHeap = new VectorHeap();
    //static ArrayList<String> lospacientes = new ArrayList();
    static PriorityQueue<Paciente> lacola = new PriorityQueue();
    
    
    //utilizando la implementacion de VectorHeap ************************************
    //lee el archivo de pacientes.txt y los mete en la cola usando la implementacion con vectorheap
    public static void llenarFicha(){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\pacientes.txt"));
            String linea;
            while((linea = br.readLine()) != null)
            {
                //String tmp = br.readLine();
                String[] palabras = linea.split(", ");
                Paciente elpaciente = new Paciente(palabras[0], palabras[1], palabras[2]);
                elHeap.add(elpaciente);
            }
        } catch (IOException e) {
                e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    //muestra en orden de prioridad los pacientes del vector heap
    public static void mostrarFicha(){
        int j = elHeap.size();
        for (int i=0; i<j;i++){
            System.out.println(elHeap.remove().toString());
        }
    }
    //utilizando el JFC de PriorityQueue<E> ****************************************
    //lee un archivo de texto e ingresa los pacientes a la cola
    public static void llenarCola(){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\pacientes.txt"));
            String linea;
            while((linea = br.readLine()) != null)
            {
                String[] palabras = linea.split(", ");
                Paciente elpaciente = new Paciente(palabras[0], palabras[1], palabras[2]);
                lacola.add(elpaciente);
            }
        } catch (IOException e) {
                e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    //muestra en orden de prioridad los elementos de la cola
    public static void mostrarCola(){
        int j = lacola.size(); //guardo el tamano inicial de la cola 
        for(int i = 0; i<j; i++){
            System.out.println(lacola.poll().toString()); 
        }
    }
    public static void main (String[] args){
        System.out.println("Usando implementacion del vector heap: ");
        llenarFicha();
        mostrarFicha();
        System.out.println("");
        System.out.println("Usando PriorityQueue (JCF): ");
        llenarCola();
        mostrarCola();
               
    }           
}
