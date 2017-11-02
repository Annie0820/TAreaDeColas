package LinkedList;

import node.node;

public class LinkedListDouble<T> {
	private node<T> start = null, end = null;
	
	public LinkedListDouble(){
		start = new node<T>();
		start.setIndex(-1);
		end = new node<T>();
		end.setIndex(-1);
	}
	
	public LinkedListDouble(T value){
		this();
		start.setNext(new node<T>(value));
		start.getNext().setIndex(0);
		end.setBack(start.getNext());
	}
	
	public void addstart(T value){
		node<T> tmp = start.getNext();
		start.setNext(new node<T>(value));
		if (tmp == null){
			start.getNext().setIndex(0);
			end.setBack(start.getNext());
		} 
		else{
			start.getNext().setNext(tmp);
			tmp.setBack(start.getNext());
		}
	}
	
	public void addend(T value){
		node<T> tmp = end.getBack();
		end.setBack(new node<T>(value));
		if (tmp == null){
			end.getBack().setIndex(0);
			start.setNext(end.getBack());
		} 
		else{
			end.getBack().setBack(tmp);
			tmp.setNext(end.getBack());
		}
	}
	
	public node<T> search (T value){
		return search (value, start);
	}
	private node<T> search (T value, node<T> lista){
		if (lista.getNext() == null){
			return null;
		}
		if(lista.getNext().getValue().equals(value)){
			return lista.getNext();
		}
		return search(value, lista.getNext());
	}
	
	
	
	public void Reindex(){
		node<T> tmp = start;
		int i = 0;
		while (tmp.getNext()!=null) {
			tmp = tmp.getNext();
			tmp.setIndex(i);
			i++;
		}
	}
	
	public void pronter() {
		node<T> tmp = start;
		while (tmp.getNext()!=null) {
			tmp = tmp.getNext();
			System.out.println(tmp.getValue());
		}
	}
	
	
	public void Listar() {
		node<T> tmp = start;
		int i = 0;
		while (tmp.getNext()!=null){		
			System.out.println(tmp.getNext());
		}
	}
	
	public void size(){
		node<T> tmp = start;
		int tam = 0;
		while(tmp.getNext()!= null){
			tam++;
			tmp = tmp.getNext();
		}
		System.out.println(tam);
		Reindex();
	}
	
	public void Clear(){
		node<T> tmp = new node<T>();
		node<T> tmp2 = new node<T>();
		tmp = start;
		tmp2 = end;
		if (tmp.getNext()!=null){
			tmp.setBack(null);
		}else if (tmp2.getBack()!=null) {
			
		}
		Reindex();
		//lista.clear();
	}
	
	public void getLast(){
		node <T> tmp = start;
		node <T> tmp2 = start;
		while (tmp.getNext() != null){
			tmp = tmp.getNext();
		}
			System.out.println(tmp2.getBack().getValue());
    }
	
	public void getFirst(){
		node <T> tmp = start;
		node <T> tmp2 = start;
		while (tmp.getNext() != null){
			tmp = tmp.getNext();
		}
			System.out.println(tmp.getValue());
    }
	
	public String Empty(){
		node<T> tmp = start;
		if (tmp.getNext() == null) {
			return "Lista vacía";
		}else {
			return "Lista completa, pero no te la voy a dar jaja";
		}
	}
	
	public void Reemplazar(T value, T newValue){
		search(value).setValue(newValue);
		Reindex();
	}
	
	public boolean addbeffor(T value, T newvalue){
		node<T> tmp = start;

		while(tmp.getNext()!= null && !tmp.getNext().getValue().equals(value)){
			tmp = tmp.getNext();
		}
		
		return (tmp.getNext()!=null)?addLast (new node<T>(newvalue),tmp):false;
	}
	
	public boolean addlast(T value, T newvalue){
		node<T> finder = search(value);
		if(finder != null){
			return addLast(new node<T>(newvalue),finder);
		}
		else{
			return false;
		}
		
		
	}
	
	private boolean addLast (node<T> nodo, node<T> finder){
		nodo.setNext(finder.getNext());
		finder.setNext(nodo);
		
		return true;
	}

	public void printerfinal() {
		node<T> tmp = end;
		while (tmp.getBack()!=null) {
			tmp = tmp.getBack();
			System.out.println(tmp.getValue());
		}
	}
	public void RemoveFirst(){		
		node <T> tmp = start;
		if (tmp != null)
			tmp.setNext(start.getNext().getNext());
	}
	
	public void RemoveLast(){		
		node <T> tmp2 = end;
		if (tmp2.getBack() != null)
			tmp2.setBack(end.getBack().getBack());
	}
	
	public boolean IndexOf(T value) {
		node <T> finder;
		Reindex();
		finder = search(value);
		if (finder != null) {
			 System.out.println("El nodo: " + value + " la encontró el buscador en: " + finder.getIndex()); 
		}
		return false;
	}
	
	public boolean RemoveBefore(T value){
		node<T> tmp = start;
		while(tmp.getNext()!=null && !tmp.getNext().getValue().equals(value))
			tmp = tmp.getNext();
		return false;
	}
	public void RemoveAfter(T value){
		node<T> finder;
		finder = search(value);
		if (finder != null) {
			search(finder.getNext().getValue());
			}
		}
}