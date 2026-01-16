package h2;

import java.util.Iterator;

public class H2_main {
    public static void main(String[] args) {
    	benchmark(10);
	}
    
    public static int fibonacci(int n) {
    	if(n == 1 || n == 2) {
    		return 1;
    	}
    	return fibonacci(n-1) + fibonacci(n-2);
    }
    
    public static int[] f = new int[1000];
    public static int fibonacciCached(int n) {
    	if(n == 1 || n == 2) {
    		return 1;
    	}
    	if(f[n] != 0) {
    		return f[n];
    	}
    	int n1 = fibonacci(n-1);
    	int n2 = fibonacci(n-2);
    	f[n-1] = n1;
    	f[n-2] = n2;
    	return n1 + n2;
    }
    
    public static int fibonacciFor(int n) {
    	int ergebnis = 2;
    	int ergebnis1 = 1;
    	int ergebnis2 = 1;
		for(int x = 3; x < n; x++) {
			ergebnis1 = ergebnis2;
			ergebnis2 = ergebnis;			
			ergebnis = ergebnis1 + ergebnis2;
		}
		return ergebnis;
	}
    
    public static void benchmark(int n){
    	Long time = System.nanoTime();
		System.out.println(fibonacci(n));
    	System.out.println(System.nanoTime() - time);
    
    	
    	Long timeb = System.nanoTime();
		System.out.println(fibonacciCached(n));
    	System.out.println(System.nanoTime() - timeb);
 
    	
    	Long timec = System.nanoTime();
		System.out.println(fibonacciFor(n));
    	System.out.println(System.nanoTime() - timec);
    }
    
}
