package app;

public class Main {

	static Integer[] intArray = new Integer[]{28, 31, 4, 7, 2, 13};
	
	
	public static <T extends Comparable<T>> void burbuja(T[] v) {
	    boolean flag = true;
	    int s = v.length;
	    while (flag) {
	        flag = false;
	        s--;
	        for (int i = 0; i < s; i++) {
	            if (v[i].compareTo(v[i + 1]) > 0) {
	                T tmp = v[i];
	                v[i] = v[i + 1];
	                v[i + 1] = tmp;
	                flag = true;
	            }
	        }
	    }
	}
	
	public static void main(String[] args) {
		
		Sales sa = new Sales();
		sa.Menu();
		burbuja(intArray);

		System.out.println("Lista ordenada de días:");
		for (int i : intArray) {
		    System.out.println(i);
		}
		
		
	}

}
