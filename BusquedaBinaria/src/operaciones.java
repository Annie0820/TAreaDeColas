import java.lang.reflect.Array;
import java.util.Arrays;

public class operaciones {
	public class metodos<T extends Comparable<T>>{

		private int capacity=0;
		private T[] array=null;
		private int contador=0;
		
		public metodos(Class<T> clase) {
			array = (T[])Array.newInstance(clase, capacity);
		}
		
		public metodos(Class<T> clase, int size) {
			this.capacity = size;
			array = (T[])Array.newInstance(clase, capacity);
		}
		
		public void add(T value){
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
		public T[] fnSortheap1()
		{
			T[] arreglocopia= Arrays.copyOf(array, array.length);
			return fnSortheap1(arreglocopia, arreglocopia.length-1);
		}
		
		private T[] fnSortheap1(T arr[], int arr2){
	        int i1 , o;
	        int lCh, rCh, mCh, root;
	        
	        T tmp;
	        
	        root = (arr2-1)/2;

	        for(o = root; o >= 0; o--)
	        {
	              for(i1= root;i1>=0;i1--)
	              {
	                    lCh = (2*i1)+1;
	                    rCh = (2*i1)+2;
	                    if((lCh <= arr2) && (rCh <= arr2))
	                    {
	                  	    if(arr[rCh].compareTo(arr[lCh])>0)
	                          //if(arr[rCh] >= arr[lCh])
	                          {
	                                mCh = rCh;
	                          }
	                          else
	                          {
	                                mCh = lCh;
	                          }
	                    }
	                    else
	                    {
	                          if(rCh > arr2)
	                          {
	                                mCh = lCh;
	                          }
	                          else
	                          {
	                                mCh = rCh;
	                          }
	                    }
	                    
	                    if(arr[i1].compareTo(arr[mCh])>0)
	                    {
	                  	  
	                          tmp = arr[i1];
	                          arr[i1] = arr[mCh];
	                          arr[mCh] = tmp;
	                    }
	              }
	        }
	        tmp = arr[0];
	        arr[0] = arr[arr2];
	        arr[arr2] = tmp;
	        return arr;
	 }

		public T[] seleccion() {
			
	        int i, j, pos;
	        T[] arreglo = Arrays.copyOf(array, array.length);
	        T menor, tmp, aux, aux1;
	        for (i = 0; i < arreglo.length - 1; i++) { // tomamos como menor el primero
	              menor = arreglo[i]; // de los elementos que quedan por ordenar
	              pos = i; // y guardamos su posición
	              for (j = i + 1; j < arreglo.length; j++){ // buscamos en el resto
	                    if (arreglo[j].compareTo(menor) <0 ) { // del array algún elemento
	                        menor = arreglo[j]; // menor que el actual
	                        pos = j;
	                    }
	              }
	              if (pos != i){ // si hay alguno menor se intercambia
	                  tmp = arreglo[i];
	                  arreglo[i] = arreglo[pos];
	                  arreglo[pos] = tmp;
	              }
	           }
	        return arreglo;
	       }
		
	    public T [] quick1(){
			T[] arreglo = Arrays.copyOf(array, array.length);
			return Metodoquick(arreglo,0,arreglo.length-1);
		}
		
		private T[] Metodoquick(T[] arreglo,int izq,int der){
		/*	T[] arreglo = Arrays.copyOf(array, array.length);
			int der = arreglo.length -1;
			int izq = 0;
			*/
			
			if(izq>=der)
				return arreglo;
			
			int i = izq, d = der;
			
			if (izq!=der){
				
				int pivote;
				T aux;
				pivote = izq;
				while(izq != der){
					while (arreglo[der].compareTo(arreglo[pivote] )>0)
						der --;
					while (arreglo[der].compareTo(arreglo[pivote] )>0)
						izq++;
					
					if (der!= izq){
						aux = arreglo[der];
						arreglo[der] = arreglo [izq];
						arreglo[izq] = aux;
					}
					if (izq == der){
						Metodoquick(arreglo, i, izq-1);
						Metodoquick(arreglo, izq+1, d);
					}
				}
				
			}else 
			return arreglo;
			
			return arreglo;
		}
		public T[] shellsorts()
		{
			T[] arreglocopia= Arrays.copyOf(array, array.length);
			return shellSort(arreglocopia);
		}
		private T[] shellSort(T arreglo[])
		{ 
			//Forma en la que funciona ShellSort
			//Este for mide los tamaños del arreglo que recibe
			for( int gap = array.length / 2; gap > 0; gap = gap == 2 ? 1 : (int) ( gap / 2.2 ) )
			{
				for( int i = gap; i < array.length; i++ )
				{ 
					//Crea una variable temporal que almacena el valor de <<i>> en ese momento
					T tmp = array[ i ]; 
					//Se crea <<j>> desde afuera porque se requiere fuera del 2do for
					int j; 
					//Este for ordena los numeros del arreglo
					for(j = i; j >= gap && tmp.compareTo(array[ j - gap ])>0 ; j -= gap )
					{ 
						array[ j ] = array[ j - gap ]; 
					} 
					array[ j ] = tmp; 
				} 
			}
			return array; 
		}
		public T[] coctails()
		{
			T[] arreglocopia= Arrays.copyOf(array, array.length);
			return coctail(arreglocopia);
		}
		private T[] coctail(T arreglo[]) 
		{ 
			int izquierda,derecha,ultimo;
			  izquierda = 1; 
			  derecha = arreglo.length; 
			  ultimo = arreglo.length-1; 
			
			  do{ 
			    for(int i=arreglo.length-1;i>0;i--){ 
			     //Burbuja hacia la izquierda 
			     //Los valores menores van a la izquierda 
			        if(arreglo[i-1].compareTo(arreglo[i])==1)
			        { 
			          T aux = arreglo[i]; //variable auxiliar para poder hacer intercambio de 
						arreglo[i] = arreglo[i-1]; //posicion 
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
	public T[] seleccionburbujas() {
			
	        int i, j, pos;
	        T[] arreglo = Arrays.copyOf(array, array.length);
	        T menor, tmp, aux, aux1;
	        for (i = 0; i < arreglo.length - 1; i++) { // tomamos como menor el primero
	              menor = arreglo[i]; // de los elementos que quedan por ordenar
	              pos = i; // y guardamos su posición
	              for (j = i + 1; j < arreglo.length; j++){ // buscamos en el resto
	                    if (arreglo[j].compareTo(menor) == 1 ) { // del array algún elemento
	                        menor = arreglo[j]; // menor que el actual
	                        pos = j;
	                    }
	              }
	              if (pos != i){ // si hay alguno menor se intercambia
	                  tmp = arreglo[i];
	                  arreglo[i] = arreglo[pos];
	                  arreglo[pos] = tmp;
	              }
	           }
	        return arreglo;
	       }
		
		public T[] ordenacionBurbuja(){
	        T[] arreglo = Arrays.copyOf(array, array.length);
	        for(int i=arreglo.length-1;i>0;i--){
	                for(int j=0;j<i;j++){
	                        if(arreglo[j].compareTo(arreglo[j+1])==1){
	                                T temp=arreglo[j];
	                                arreglo[j]=arreglo[j+1];
	                                arreglo[j+1]=temp;
	                        }
	                }
	        }
	        return arreglo;
	}

			public int val(){
				int[] aux=new int[capacity];
				int numMax=0;
				for (int i = 0; i < array.length; i++) {
					aux[i]=(int) array[i];
				}
				
				for (int i = 0; i < aux.length; i++) {
					if(numMax<=aux[i]){
						numMax=aux[i];
					}
				}
				return numMax;
				
			}
			
			   public  void sort() {
				   int[] a= new int[capacity];
				 
					for (int i = 0; i < array.length; i++) {
						a[i]=(int) array[i];
					}
					
				   int maxVal=val();
			      int [] bucket=new int[maxVal+1];
			 
			      for (int i=0; i<bucket.length; i++) {
			         bucket[i]=0;
			      }
			 
			      for (int i=0; i<a.length; i++) {
			         bucket[(int) a[i]]++;
			      }
			 
			      int outPos=0;
			      for (int i=0; i<bucket.length; i++) {
			         for (int j=0; j<bucket[i]; j++) {
			          a[outPos++]=i;
			         }
			      }
			      
		}
			   /*
			   public T radixSorts(){
					T[] arreglocopia= Arrays.copyOf(array, array.length);
					return radixSort(arreglocopia);
					
				}
			 	public T[] radixSort(T[] arr){
					 int i, j, x ;
					 boolean mover;
					T []a = Arrays.copyOf(array, array.length);
					
					
						for (x = Integer.SIZE -1; x >=0; x++) {
							
					    int[] auxiliar = new int[array.length];
					    	j=0;
					        for (i = 0; i < array.length; i++){
					        	 mover = arr[i]<< x >=0;
					        		if(x==0 ? !mover:mover){
					        			auxiliar[j]= arr[i];
					        			}else{
					        				arr[i-j]=arr[i];
					        			}
					        		for ( i = j; i < arr.length; i++) {
										auxiliar[i]=arr[i-j];
									}
					        		arr=auxiliar;
					        		}
				}
						return (T[]) a;
			*/		
	/*

			   public void ordenacionMergeSort(int vec[]){
			        if(vec.length<=1) return;
			        int mitad= vec.length/2;
			        int izq[]=Arrays.copyOfRange(vec, 0, mitad); 
			        int der[]=Arrays.copyOfRange(vec, mitad, vec.length); 
			        ordenacionMergeSort(izq); 
			        ordenacionMergeSort(der);  
			        combinarVector(vec, izq, der); //trae las combinaciones realizadas dentro de combinarVector
			}
				
				public void combinarVector(int v[], int izq[],int der[]){ 
			        int i=0; 			//Son las coordenadas que ocupan izq y der
			        int j=0; 
			        for(int k=0;k<v.length;k++){       //En esta parte los numeros dentro de izquiera y derecha se 
			                
			        		if(i>=izq.length){ 			// El for cubre el tamaño total de vector 
			                        v[k]=der[j];		
			                        j++;
			                        continue;
			                }
			        		
			                if(j>=der.length){			// el if 1ro y 2ro son los que estàn comparando las posiciones
			                        v[k]=izq[i];		// que ocupan izq y derecha (mostrar gift)
			                        i++;
			                        continue;
			                }
			                
			                if(izq[i]<der[j]){
			                        v[k]=izq[i];		//Esta parte es la que esta ordenando los nùmero por
			                        i++;				//para entregar la ordenacion del vector 
			                }else{
			                        v[k]=der[j];
			                        j++;
			                }
			        }
			}
				public void imprimirVector(int vec[]){
			        for(int i=0;i<vec.length;i++){ 
			                System.out.print(vec[i]+" "); 
			        }
				}
				
				public void mostrar(int vec[]){
					System.out.println("Vector original");
					imprimirVector(vec);
					System.out.println("\nVector ordenado");
					ordenacionMergeSort(vec); 
			        imprimirVector(vec); 
				}
				*/

			public int getContador() {
				return contador;
			}

			public void setContador(int contador) {
				this.contador = contador;
			}
					
			
							

	}
}
