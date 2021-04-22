import java.util.*;
import java.lang.Math;
public class Baitap5 {
	public static double Cau5(int n,int luythua){ // change DEC to BIN
		if(n == 0 ) return 0;
		int k = n/2;
		return (n%2)* Math.pow(10,luythua) + Cau5(k,luythua+1);
		
	}
	
	public static void main(String[] args){
		System.out.print("Nhap n:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println("Cau 5 :"+(int) Cau5(n,0));
		

	}
}













