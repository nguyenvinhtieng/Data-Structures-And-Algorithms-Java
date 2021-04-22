public class Student {
    private String name;
    private double mathematics;
    private double programming;
    private double DSA1;


    public Student(){
        this.name = "";
        this.mathematics = 0;
        this.programming = 0;
        this.DSA1 = 0;
    }

    public Student(String name,double mathematics, double programming , double DSA1 ){
        this.name = name;
        this.mathematics = mathematics;
        this.programming = programming;
        this.DSA1 = DSA1;
    }

    public Student(Student t){
        this.name = t.name;
        this.mathematics = t.mathematics;
        this.programming = t.programming;
        this.DSA1 = t.DSA1;
    }

   

    public double getDtb(){
        return (this.mathematics + this.programming +this.DSA1) / 3 ;
    }
    @Override
    public String toString() {
        return "Student :"+this.name+"\nmathematics :"+this.mathematics+"\nprogramming :"+this.programming
        +"\nDSA1 :"+this.DSA1;
    }
}
    