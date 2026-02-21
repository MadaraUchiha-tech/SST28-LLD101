import java.util.*;
public class disciplineRule implements Non_eligibility{
    public void check(StudentProfile s,List<String> reasons) {
        if (s.disciplinaryFlag != LegacyFlags.NONE) {
            reasons.add("disciplinary flag present");
        }
    }
}