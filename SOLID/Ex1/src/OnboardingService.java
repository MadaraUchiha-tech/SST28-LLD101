import java.util.*;

public class OnboardingService {
    private final Saver db;
    private logger l;
    private Validator v;
    private Parser p;

    public OnboardingService(Saver db) {
        this.db = db;
        l=new logger();
        p=new Parser();
        v=new Validator();
    }

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        l.logInput(raw);

        Map<String,String> kv = p.parse(raw);

        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("email", "");
        String phone = kv.getOrDefault("phone", "");
        String program = kv.getOrDefault("program", "");

        // validation inline, printing inline
        List<String> error = v.validate(name,email,phone,program);
        if(!error.isEmpty()){
            l.logerrors(error);
            return;
        }

        String id = IdUtil.nextStudentId(db.count());
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);

        db.save(rec);

        l.logSuccess(id,db.count(),rec);
    }
}
