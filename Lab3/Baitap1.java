public class Baitap1 {
	public static int Cau1a( int n ){ // tinh giai thua
		if(n == 1 ){
			return 1;
		}
		return n*Cau1a(n-1);
			
	}
	public static int Cau1b(int n , int x){ // tinh x mu n
		if (n == 1){
			return x;
		}
		return x*Cau1b(n-1,x);
	}
	public static int Cau1c(int n ){ // tinh so chu so
		if (n == 0){
			return 0;
		}
		return 1+Cau1c(n/10);
	}
	public static boolean Cau1d(int n ){ // kiem tra so nguyen to
	    if(n <2) return false;
		if(n == 2) return true;
		for (int i = 2 ; i < n ;i++){
			if(n % i == 0) return false;
		}
		return true;
	}
		public static int Cau1e(int a , int b ){ // UCLN cua hai so
		if(a <= 0 || b <= 0) return -1;
		int max = a;
		if(b > max ) max = b;
		for(int i =max ; i >= 1 ; i --){
			if(a % i == 0 && b % i ==0){
				return i;
			}
		}
		return -1;
		
		
	}
	public static void main(String[] args){
		System.out.println("Cau 1 a :"+Cau1a(3));
		System.out.println("Cau 1 b :"+Cau1b(3,2));
		System.out.println("Cau 1 c :"+Cau1c(12345));	
		if(Cau1d(7))
			System.out.println("Cau 1 d : la so nguyen to ");
		else
			System.out.println("Cau 1 d : khong la so nguyen to ");
		System.out.println("Cau 1 e :"+Cau1e(6,3));
		
	}
}













