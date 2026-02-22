public class gymAddon implements addOnInterface{
    public AddOn getType(){
        return AddOn.GYM;
    }
    public double price(){
        return 300.0;
    }
}