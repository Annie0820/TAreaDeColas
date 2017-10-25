package app;

import listas.LinkedList;
import node.node;

public class App {

	public static void main(String[] args){
		LinkedList<String> names     = new LinkedList<String>();
		LinkedList<String> lastnames = new LinkedList<String>();
		LinkedList<Integer>ages      = new LinkedList<Integer>();
		
		
		names.AddBefore("Ana");
		names.AddBefore("Ricardos");
		names.AddLastRec("Laura");
		names.AddLastRec("Andrik");		
		names.addlast("Ricardos","Rotz");
		System.out.println("primer nodo");
		names.GetFirst();
		System.out.println("Ultimo nodo");
		names.getLast();
		System.out.println("Tamaño: ");
		names.size();
		names.Repllace("Ana", "Gaby");
		//names.removeFirst();
		names.IndexOf("Laura");
		names.Empty();
		names.RemmoveLast();
		names.RemoveAfter("Ricardos");
		names.ReIndex();
		names.Clear();
		names.pronter();
		//names.Listar(); es el mismo metodo de imprimir
	}
}
