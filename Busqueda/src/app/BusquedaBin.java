package app;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class BusquedaBin <T extends Comparable <T>> implements Iterable<T>  {
	private T[] data = null;
	private Class<T> type;
	int count = 0;
	
	public BusquedaBin(Class <T> type) {
		data = ((T[])Array.newInstance(type, 10));
		this.type = type;
	}
	public BusquedaBin(Class <T> type,int n) {
		data = ((T[])Array.newInstance(type, n));
		this.type = type;
	}
	
	public T get(int pos){
		return data[pos];
	}
	
	public void set(int ind, T tmp){
		data[ind] = tmp;
	}
	
	public int getLength(){
		return count;
	}
	
	public void addValue(T value){
		try {
			array[capacity] = value;
			capacity++;
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			array= Arrays.copyOf(array, array.length+1);
			array[capacity]=value;
			capacity++;			
		}
	}
	
	public void print(){
		for (int i = 0; i < count; i++) {
			System.out.println(data[i]);
		}
	}
	@Override
public Iterator<T> iterator() {
		return new Iterator<T>(){
			int i = 0;
			@Override
			public boolean hasNext() {	
					return i< count;
			}

			@Override
			public T next() {
				
					return data[i++];
				
			}
			
		};
	}
	
	private int capacity=0;
	private T[] array=null;
	private int contador=0;

	public T[] Coctail()
	{
		T[] arreglocopia= Arrays.copyOf(array, array.length);
		return Coctail(arreglocopia);
	}
	private T[] Coctail(T arreglo[]) 
	{ 
		int izquierda,derecha,ultimo;
		  izquierda = 1; 
		  derecha = arreglo.length; 
		  ultimo = arreglo.length-1; 
		
		  do{ 
		    for(int i=arreglo.length-1;i>0;i--){ 
		        if(arreglo[i-1].compareTo(arreglo[i])==1)
		        { 
		          T aux = arreglo[i];
					arreglo[i] = arreglo[i-1];
					arreglo[i-1] = aux; 
					ultimo = i; 
		        } 
		    } 
		    izquierda = ultimo+1; 
		    for(int j=1;j<arreglo.length;j++){ 
		    	if(arreglo[j-1].compareTo(arreglo[j])==1){ 
		    		T aux = arreglo[j]; 
		    		arreglo[j] = arreglo[j-1]; 
		    		arreglo[j-1] = aux; 
		    		ultimo = j; 
		    	} 
		    } 
		    derecha = ultimo-1; 
		  }while(derecha >= izquierda); 
		
		  for(int i=0;i<arreglo.length;i++){ 
			  System.out.println(arreglo[i]); 
		  }
		return arreglo; 
		} 
	
}