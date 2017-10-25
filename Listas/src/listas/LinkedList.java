package listas;

import node.node;


public class LinkedList<T> {
	private node<T> sentinel=null;

	public LinkedList(){
		sentinel = new node<T>();
		sentinel.setIndex(-1);
	}
	
	public LinkedList(T value) {
		this();
		node<T> tmp = new node<T>(value);
		tmp.setIndex(0);
		sentinel.setNext(tmp);
	}
	
	public void AddBefore(T value) {
		node<T> tmp = sentinel.getNext();
		node<T> nuevo = new node<T>(value);
		nuevo.setNext(tmp);
		sentinel.setNext(nuevo);
		
	}
	
	public void AddLast(T value){
		node<T> tmp = sentinel;
		
		while (tmp.getNext()!=null) {
			tmp = tmp.getNext();
		}
		tmp.setNext(new node<T>(value));
	}
	
	public void AddLastRec(T value){
		node<T> tmp = sentinel.getNext();
		AddLastRec(tmp,value);
	}
	
	private void AddLastRec(node<T> tmp,T value){
		if(tmp.getNext() == null){
			tmp.setNext(new node<T>(value));
			return;
		}
		else{
			AddLastRec(tmp.getNext(), value);
		}
		
	}
	public node<T> search (T value){
		return search (value, sentinel);
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
	public boolean addbeffor(T value, T newvalue){
		node<T> tmp = sentinel;

		while(tmp.getNext()!= null && !tmp.getNext().getValue().equals(value)){
			tmp = tmp.getNext();
		}
		return (tmp.getNext()!=null)?addLast(new node<T>(newvalue),tmp):false;
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
	
	public boolean addlast(T value, node<T> nodo){
		node<T> finder = search(value);
		if (finder != null){
			return addLast(nodo, finder);
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
	
	public node<T> remmove (T value){
		node<T> tmp = sentinel;
		node<T> borrado = null;
		while(tmp.getNext() != null){
			if (tmp.getNext().getValue().equals(value)){
				borrado = tmp.getNext();
				tmp.setNext(tmp.getNext().getNext());
				return borrado;
			}
			else{
				tmp = tmp.getNext();
			}
		}
		return null;
	}
	
	public boolean remove (T value){
		node<T> tmp = sentinel;
		while(tmp.getNext() != null){
			if (tmp.getNext().getValue().equals(value)){
				tmp.setNext(tmp.getNext().getNext());
				return true;
			}
			else{
				tmp = tmp.getNext();
			}
		}
		return false;
	}
	
	public void printer() {
		printer(sentinel);
	}
	
	private void printer(node<T> tmp) {
		if (tmp.getNext()== null) {
			return;
		}
		else
			System.out.println(tmp.getNext().getValue());
		printer(tmp.getNext());
	}
	
	public void pronter() {
		node<T> tmp = sentinel;
		while (tmp.getNext()!=null) {
			tmp = tmp.getNext();
			System.out.println(tmp.getValue());
		}
	}
	
	/*************************************************************************************/
	
	
	public void Listar() {
		node<T> tmp = sentinel;
		int i = 0;
		while (tmp.getNext()!=null){		
			System.out.println(tmp.getNext());
		}
	}
	
	public void size(){
		node<T> tmp = sentinel;
		int tam = 0;
		while(tmp.getNext()!= null){
			tam++;
			tmp = tmp.getNext();
		}
		System.out.println(tam);
	}
	
	public void Clear(){
		sentinel = null;
		node<T> sentinelFinal = new node<T>();
		sentinelFinal = null;
		int corriente = 0;	
		//lista.clear();
	}
	
	/*
	public void RF() {
		node<T> tmp = sentinel;
		tmp = null;
	}*/
	
	public node <T> RemoveFirst()
	{
		node <T> tmp = sentinel;
		if (tmp != null)
			tmp = tmp.getNext();
		return tmp;
			
	}
	
	public node<T> removeFirst (){
		node<T> tmp = sentinel;
		node<T> borrado = null;
		borrado = tmp.getNext();
		return borrado;
	}
	
	public void Repllace(T value, T nuevoval){
		node <T> finder = search(value);
		if (finder != null) {
			finder.setValue(nuevoval);
			}
		}
	
	public void IndexOf(T value) {
		node <T> finder;
		ReIndex();
		finder = search(value);
		if (finder != null) {
			 System.out.println("El nodo: " + value + " la encontró el buscador en: " + finder.getIndex()); 
		}
	}
		
	public void GetFirst()
	{
		node <T> tmp = sentinel;
		if (tmp.getNext() != null)
		System.out.println(" " +tmp.getNext().getValue());		
	}
	
	public void getLast(){
		node <T> tmp = sentinel;
		while (tmp.getNext() != null){
			tmp = tmp.getNext();
		}
			System.out.println(tmp.getValue());
    }
	
	public String Empty(){
		node<T> tmp = sentinel;
		if (tmp.getNext() == null) {
			return "Lista vacía";
		}else {
			return "Lista completa, pero no te la voy a dar jaja";
		}
	}
	
	public void RemmoveLast(){
		node<T> tmp=sentinel;
		while(tmp.getNext()!=null){
			tmp = tmp.getNext();	
		}
		remove(tmp.getValue());
	}
	public void ReIndex() {
		node<T> tmp = sentinel;
		int i = 0;
		while (tmp.getNext()!=null){
			tmp.setIndex(i++);
			tmp.getNext();
		}
	}
	
	public void RemoveAfter(T value){
		node<T> finder;
		finder = search(value);
		if (finder != null) {
			remove(finder.getNext().getValue());
			}
		}
	
	public boolean RemoveBefore(T value){
		node<T> tmp = sentinel;
		while(tmp.getNext()!=null && !tmp.getNext().getValue().equals(value))
			tmp = tmp.getNext();
		return (tmp.getNext()!=null)?remove(tmp.getValue()):false;
	}
}
