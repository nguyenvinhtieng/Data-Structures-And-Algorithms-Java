public class Baitap2 {
	public static int Cau2a( int n ){ // tinh giai thua
		if(n == 1 ){
			return 1;
		}
		return n*Cau2a(n-1);
			
	}
	public static int Cau2b(int n , int x){ // tinh x mu n
		if (n == 1){
			return x;
		}
		return x*Cau2b(n-1,x);
	}
	public static int Cau2c(int n ){ // tinh so chu so
		if (n == 0){
			return 0;
		}
		return 1+Cau2c(n/10);
	}
	public static int Cau2d(int a , int b){ // UCLN
	    if(a == b ) return a;
		if(a > b ) return Cau2d(a-b,b);
		if(b > a) return Cau2d(a,b-a);
		return 0;
		
	}
	public static void main(String[] args){
		System.out.println("Cau 1 a :"+Cau2a(3));
		System.out.println("Cau 1 b :"+Cau2b(3,2));
		System.out.println("Cau 1 c :"+Cau2c(12345));	
		System.out.println("Cau 1 e :"+Cau2d(6,3));
		
	}
}













