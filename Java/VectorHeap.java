
import java.util.Vector;
import java.util.PriorityQueue;

/**
 *
 * @author arriaza96
 * @param <E> el tipo de dato
 */
public class VectorHeap<E extends Comparable<E>> implements interfacePriorityQueue<E>
{

    /**
     *
     */
    protected Vector<E> data; // the data, kept in heap order
       // protected PriorityQueue<E> cola;
        
    /**
     *
     */
    public VectorHeap()
	// post: constructs a new priority queue
	{
		data = new Vector<E>();
	}
        
    /**
     *
     * @param v
     */
    public VectorHeap(Vector<E> v)
	// post: constructs a new priority queue from an unordered vector
	{
		int i;
		data = new Vector<E>(v.size()); // we know ultimate size
		for (i = 0; i < v.size(); i++)
		{ // add elements to heap
			add(v.get(i));
		}
	}

    /**
     *
     * @param i el numero del nodo
     * @return el padre del nodo
     */
    protected static int parent(int i)
	// pre: 0 <= i < size
	// post: returns parent of node at location i
	{
		return (i-1)/2;
	}

    /**
     *
     * @param i el numero de nodo
     * @return el nodo a la izquierda
     */
    protected static int left(int i)
	// pre: 0 <= i < size
	// post: returns index of left child of node at location i
	{
		return 2*i+1;
	}

    /**
     *
     * @param i
     * @return
     */
    protected static int right(int i)
	// pre: 0 <= i < size
	// post: returns index of right child of node at location i
	{
		return (2*i+1) + 1;
	}

    /**
     *
     * @param leaf la hoja que se quiere "percolar"
     */
    protected void percolateUp(int leaf)
	// pre: 0 <= leaf < size
	// post: moves node at index leaf up to appropriate position
	{
		int parent = parent(leaf);
		E value = data.get(leaf);
		while (leaf > 0 &&
		(value.compareTo(data.get(parent)) < 0))
		{
			data.set(leaf,data.get(parent));
			leaf = parent;
			parent = parent(leaf);
		}
		data.set(leaf,value);
	}

    /**
     *
     * @param value a ser anadido al vectorheap
     */
    public void add(E value)
	// pre: value is non-null comparable
	// post: value is added to priority queue
	{
		data.add(value);
		percolateUp(data.size()-1);
	}
        
    /**
     *
     */
    public void clear(){
            //cola.clear();
            data.clear();
        }

    /**
     *
     * @param root la cual debe ser empujada hacia abajo
     */
    protected void pushDownRoot(int root)
	// pre: 0 <= root < size
	// post: moves node at index root down
	// to appropriate position in subtree
	{
		int heapSize = data.size();
		E value = data.get(root);
		while (root < heapSize) {
			int childpos = left(root);
			if (childpos < heapSize)
			{
				if ((right(root) < heapSize) &&
				((data.get(childpos+1)).compareTo
				(data.get(childpos)) < 0))
				{
					childpos++;
				}
			// Assert: childpos indexes smaller of two children
			if ((data.get(childpos)).compareTo
				(value) < 0)
			{
				data.set(root,data.get(childpos));
				root = childpos; // keep moving down
			} else { // found right location
				data.set(root,value);
				return;
			}
			} else { // at a leaf! insert and halt
				data.set(root,value);
				return;
			}
		}
	}

    /**
     *
     * @return E el elemento de mayor prioridad, lo devuelve y elimina del vectorheap
     */
    public E remove()
	// pre: !isEmpty()
	// post: returns and removes minimum value from queue
	{
		E minVal = getFirst();
		data.set(0,data.get(data.size()-1));
		data.setSize(data.size()-1);
		if (data.size() > 1) pushDownRoot(0);
		return minVal;
	}

    /**
     *
     * @return muestra el elemento de mayor prioridad sin quitarlo de la lista
     */
    @Override
    public E getFirst() {
        return data.firstElement();
        //return cola.poll();
    }

    /**
     *
     * @return true si esta vacio, false si tiene al menos un elemento
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     *
     * @return el tamano del vectorheap
     */
    @Override
    public int size() {
        return data.size();
    }
    
}

