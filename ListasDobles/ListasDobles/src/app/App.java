package app;

import LinkedList.LinkedListDouble;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListDouble<String> names     = new LinkedListDouble<String>();
		names.addstart("Azahel");
		names.addstart("Lilith");
		names.addend("Behemot");
		names.addstart("Leviatan");
		
		
		names.addbeffor("Azahel", "Bell");
		
		System.out.println("primer nodo");
		names.getFirst();
		System.out.println("Ultimo nodo");
		names.getLast();
		System.out.println("Tamaño: ");
		names.size();
		names.Reemplazar("Behemot", "Cerbero");
		names.RemoveFirst();
		names.IndexOf("Cerbero");
		names.Empty();
		names.RemoveLast();
		names.RemoveBefore("Lilith");
		names.RemoveAfter("Azahel");
		names.RemoveLast();
		names.Listar();
		names.search("Cerbero");
		names.Reindex();
		names.Clear();
		names.pronter();

	}

}
