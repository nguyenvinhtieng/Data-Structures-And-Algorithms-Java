import java.util.Comparator;
 public class StudentComparator  {
    @Override
    public int compare(Object o1, Object o2)
    {
        double d1 = o1.getDtb();
        double d2 = o2.getDtb();

        double ratio = d1 - d2 ;
        if(ratio > 0) return 1;
        if(ratio < 0) return -1;
        return 0;
    }
 }
