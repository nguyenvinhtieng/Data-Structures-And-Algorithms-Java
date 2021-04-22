import java.util.Arrays;

 public class Test 
 {
    public static void print(Fraction[] arr) {
        for(Fraction f : arr) {
        System.out.print(f + "\t");
        }
        System.out.println();
    }
    public static void selectionsort(Fraction a[] ,FractionComparator f){
        for(int i = a.length -1 ;i >=1 ;i--){
            int min_index = i;
            for(int j =0;j < i;j++){
                if(f.compare(a[j],a[min_index]) >0)
                    min_index=j;
            }
            Fraction temp = new Fraction(a[min_index]);
            a[min_index] = a[i];
            a[i] = temp;
        }
        print(a);
    }

    public static void bubblesort(Fraction a[] ,FractionComparator f){
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length - i; j++) {
                if (f.compare(a[j],a[j+1]) >0) {
                    Fraction temp = new Fraction(a[j]);
                    a[j] = a[j+1]; 
                    a[j+1] = temp; 
                }
            }
        }
        print(a);
    }

    public static void insertionsort(Fraction a[] ,FractionComparator f){
        for (int i = 1;i<a.length;i++) { 
            Fraction next = new Fraction(a[i]);
            int j;  
            for (j=i-1; j>=0 && f.compare(a[j],next) >0; j--)
                a[j+1] = a[j];

            a[j+1] = next;  

        }
    print(a);

    }
    public static void main(String[] args) {
        Fraction[] fraction = new Fraction[5];
        fraction[0] = new Fraction(5, 6);
        fraction[1] = new Fraction(1, 2);
        fraction[2] = new Fraction(7, 3);
        fraction[3] = new Fraction(3, 5);
        fraction[4] = new Fraction(2, 3);

        System.out.println("Fraction before sort is : ");
        print(fraction);
        System.out.println("Fraction after sort by Selection sort is : ");
        selectionsort(fraction ,new FractionComparator());
        System.out.println("Fraction after sort by Bubblesort sort is : ");
        bubblesort(fraction ,new FractionComparator());
        System.out.println("Fraction after sort by Intertion sort is : ");
        insertionsort(fraction ,new FractionComparator());
        }
 }
