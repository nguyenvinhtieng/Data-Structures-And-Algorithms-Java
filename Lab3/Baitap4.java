public class Baitap4 {
	public static int Cau4a(int n){ // 2i+1
		if(n <= 0) return 0;
		if(n == 1 ) return 3;
		return 2*n+1+Cau4a(n-1);
	}
	public static int Cau4b(int n){ // i!
		if(n==1) return 1;
		int sum = 1;
		for (int i = 1; i <= n ; i ++){
			sum*=i;
		}
		return sum+Cau4b(n-1);
	}
	public static int Cau4c(int n){ // i!
		if(n==1) return 1;
		int sum = 1;
		for (int i = 1; i <= n ; i ++){
			sum*=i;
		}
		return sum*Cau4c(n-1);
	}
	public static int Cau4d(int n, int k){ // i!
		if(k > n || n <0 || k <0 ) return 0;
		if(n == k) return 1;
		return n*Cau4d(n-1,k);
	}
	public static int Cau4e(int n){ // i!
		if(n <= 0) return 0;
		if(n == 1 ) return 3;
		int sum =1;
		for(int i = 1 ; i <= n ; i++){
			sum*=2;
		}
		return sum +n*n+Cau4e(n-1);
	}
	
	public static void main(String[] args){
		System.out.println("Cau 4 a :"+Cau4a(3));
		System.out.println("Cau 4 b :"+Cau4b(3));		
		System.out.println("Cau 4 c :"+Cau4c(3));	
		System.out.println("Cau 4 d :"+Cau4d(3,2));	
		System.out.println("Cau 4 e :"+Cau4e(2));

	}
}













