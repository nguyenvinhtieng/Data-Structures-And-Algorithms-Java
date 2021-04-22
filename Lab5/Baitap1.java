import java.util.*;
import java.lang.Math;
public class Baitap1{
	public static double prod_recur(int a, int b){
		if(b == 0) return 0;
		return a+prod_recur(a,b-1);
	}
	public static int maxDigit(int n){
		if(n == 0) return 0;
		if(n%10 > maxDigit(n/10)) return n%10;
		return maxDigit(n/10);
	}
	public static int bin2dec(int n, int exp){
		if(n == 0 )
			return 0;
		
		return (n%10)*(int)Math.pow(2,exp) + bin2dec(n/10,exp+1);
		

	}
	
	public static int maxElement(int a[], int n){
		if(n == 0) return 0;
		if(a[n] >= maxElement(a,n-1)) return a[n];
		return maxElement(a,n-1);
	}
	public static int search(int a[], int n, int key){
		if(n == 0) return -1;
		if(a[n] == key) return n;
		return search(a,n-1,key);
	}
	/// Bai 2
	public static int cau2a(int n){
		if(n == 1) return 2;
		
		return (int)Math.pow(2,n)+cau2a(n-1);
	}
	public static double cau2b(int n){
		if(n == 0) return 1/2;
		return (n+1)/2 +cau2b(n-1);
	}
	/* public static double cau2c(int n){
		if(n == 1) return 1;
		
		return (n+1)/2 +cau2b(n-1);
	} */
	
	public static void main(String[] args){
		int a[] = {1,2,3,4,5,6};
		// Bai 1
		System.out.println(prod_recur(2,3));
		System.out.println(bin2dec(1100,0));
		System.out.println(maxDigit(986123));
		System.out.println(maxElement(a,5));
		System.out.println(search(a,5,2));
		//Bai 2
		System.out.println(cau2a(6));
		System.out.println(cau2b(6));
		//System.out.println(cau2c(6));

		
	}
}

























