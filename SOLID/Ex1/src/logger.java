import java.util.*;
public class logger{
    void logInput(String raw){
        System.out.println("INPUT: " + raw);
    }
    void logerrors(List<String> errors){
        System.out.println("ERROR: cannot register");
        for (String e : errors) System.out.println("- " + e);
    }
    void logSuccess(String a,int b,StudentRecord c){
        System.out.println("OK: created student " + a);
        System.out.println("Saved. Total students: " + b);
        System.out.println("CONFIRMATION:");
        System.out.println(c);
    }
}