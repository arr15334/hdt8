/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rodrigo Arriaza;
 */
public class VectorHeapTest {
    
    public VectorHeapTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
   
    /**
     * Para probar que funcione el metodo add, se anaden valores a un vector heap y se revisa si cambia el tamano del vectorheap
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        VectorHeap<Integer> instance = new VectorHeap();
        instance.add(5);
        instance.add(3);
        instance.add(1);
        int expResult = 3;
        int result = instance.size();
        assertEquals(expResult, result);
        //segunda prueba, cuando se anade, se debe anadir en la posicion correcta cada elemento
        expResult = 1; //en el heap el numero 1 es el de mayor prioridad aunque se haya anadido de ultimo al vectorheap, por lo tanto este es el expResult
        result = instance.getFirst();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

   
    /**
     * Metodo remove, remueve el elemento de mayor prioridad
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        VectorHeap<String> instance = new VectorHeap();
        instance.add("C");
        instance.add("A");
        instance.add("M");
        assertEquals(3, instance.size()); //el tamano actual es 3, porque hay 3 elementos en el vector
        String expResult = "A";
        String result = instance.remove();
        assertEquals(expResult, result);
        //como segunda prueba se comprueba que el tamano se haya reducido en uno
        assertEquals(2, instance.size());
    }

  
    
}
