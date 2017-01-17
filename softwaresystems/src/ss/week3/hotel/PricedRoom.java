package ss.week3.hotel;
 
public class PricedRoom extends Room implements Bill.Item {
    public double price;
    private String description;
   
    public PricedRoom(int roomnr, double roomprice, double safeprice){
        super(roomnr, new PricedSafe(safeprice));
        this.price = roomprice;
        description = "Room";
       
    }
 
    public double getAmount(){
        return price;
    }
    @Override
    public String toString(){
        return "the price of the room is:" + price;
    }
 
 
}