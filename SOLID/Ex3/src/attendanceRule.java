import java.util.*;
public class attendanceRule implements Non_eligibility{
    public void check(StudentProfile s,List<String> reasons) {
        if (s.attendancePct < 75) {
            reasons.add("attendance below 75");
        }
    }
}