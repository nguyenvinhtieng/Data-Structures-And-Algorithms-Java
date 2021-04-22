public class Baitap3 {
	public static boolean checkPrime(int n, int d){
		if(n < 2 ) return false;
		if(n == 2) return true;
		if(d == n) return true;
		if(n % d == 0) return false;
		return checkPrime(n,d+1);
	}
	public static void main(String[] args){
		if(checkPrime(4,2))
			System.out.println("la so nguyen to ");
		else
			System.out.println("khong la so nguyen to ");
		
		
	}
}













