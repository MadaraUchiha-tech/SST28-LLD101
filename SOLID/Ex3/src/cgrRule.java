import java.util.*;
public class cgrRule implements Non_eligibility{
    public void check(StudentProfile s,List<String> reasons) {
        if (s.cgr < 8.0) {
            reasons.add("CGR below 8.0");
        }
    }
}