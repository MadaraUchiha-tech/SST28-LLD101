public class laundryAddon implements addOnInterface{
    public AddOn getType(){
        return AddOn.LAUNDRY;
    }
    public double price(){
        return 500.0;
    }
}