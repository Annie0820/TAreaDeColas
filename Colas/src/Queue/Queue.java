package Queue;

import java.util.Iterator;
import node.node;

public class Queue<T extends Comparable<T>> implements iQueue<T>, Iterable<T> {
	private int cont = 0, tamano = 0;
	private node<T> sentinel = null, tmp = null, nuevo = null;
	
	public Queue(){
		sentinel = new node<T>();
		sentinel.setIndex(-1);
	}
	
	public Queue(int tamano){
		this();
		tamano = 5;
	}

	@Override
	public void enQueue(T value) throws QueueFullException 
	{
		if (isFull()) throw new QueueFullException("Cola Llena Por De Quitar Elementos");
		tmp = sentinel.getNext();
		nuevo = new node<T>(value);
		if(isEmpty()){
			sentinel.setNext(nuevo);
			nuevo.setNext(nuevo);
		}
		else if(!isFull()){
			while(!tmp.getNext().equals(sentinel.getNext())) {
				tmp = tmp.getNext();
			}
			tmp.setNext(nuevo);
			nuevo.setNext(sentinel.getNext());
		}
		cont++;
	}

	@Override
	public T deQueue() throws QueueEmptyException {
		if (isEmpty()) throw new QueueEmptyException("Cola Vacia Por Favor De Llenar");
		return null;
	}
	
	private T deQueue(node <T> list){
		node <T> tmp =  list;	
		T nex = tmp.getNext().getValue();
		if(tmp.getNext()== null)
			return null;
		else
			tmp.setNext(tmp.getNext());
		cont--;
		return nex;
	}
	
	@Override
	public boolean isFull() {
		return (cont == tamano);
	}

	@Override
	public boolean isEmpty() {
		return (cont == 0);
	}

	@Override
	public T front() throws QueueEmptyException {
		if (isEmpty()) throw new QueueEmptyException("No existe ningún elemento");
		if(!isEmpty())
			return sentinel.getNext().getValue();
		return null;
	}
	
	@Override
	public T search(T value) throws QueueEmptyException {
		if (isEmpty()) throw new QueueEmptyException("No existe ningún elemento");
		return search(value, sentinel.getNext());
	}
	private T search(T value, node<T> list){
		if(list.getNext().getValue().equals(value)){
			return list.getNext().getValue();
		}
		return search(value, list.getNext());
	}

	@Override
	public int size() {
		return cont;
	}
	
	public void clear() {
		sentinel.setNext(null);
        cont = 0;
	}
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			node<T> tmp=sentinel;
			@Override
			public boolean hasNext() {
				System.out.println(tmp.getValue());
				tmp=tmp.getNext();
				return(tmp != null)?true:false;	
			}
			@Override
			public T next() {
				return tmp.getValue();
			}
		};
	}
}
