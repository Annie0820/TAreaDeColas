package app;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecimalBin(10);
	}
	
	public static void DecimalBin(int x){
		if (x<2) {
			System.out.print(x);
			return;
		} else {
			DecimalBin(x/2);
			System.out.print(x%2);
		}
	}

}
