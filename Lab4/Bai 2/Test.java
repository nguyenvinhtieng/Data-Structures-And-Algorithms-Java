import java.util.Arrays;

 public class Test 
 {
    public static void print(Student[] arr) {
        for(Student f : arr) {
        System.out.print(f + "\t");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Student[] student = new Student[3];
        student[0] = new Student("Nguyen Van A", 6 ,7,10);
        student[1] = new Student("Nguyen Van B", 7 ,9,10);
        student[2] = new Student("Nguyen Van C", 5 ,10,10);
        
        print(student);

       
        }
 }
