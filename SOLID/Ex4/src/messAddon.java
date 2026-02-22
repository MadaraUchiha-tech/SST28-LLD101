
public class messAddon implements addOnInterface{
    public AddOn getType(){
        return AddOn.MESS;
    }
    public double price(){
        return 1000.0;
    }
}