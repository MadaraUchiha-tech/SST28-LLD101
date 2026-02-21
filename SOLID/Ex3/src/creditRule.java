import java.util.*;
public class creditRule implements Non_eligibility{
    public void check(StudentProfile s,List<String> reasons) {
        if (s.earnedCredits < 20) {
            reasons.add("credits below 20");
        }
    }
}