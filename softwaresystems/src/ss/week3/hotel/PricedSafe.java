package ss.week3.hotel;
import ss.week3.hotel.Safe;
 
public class PricedSafe extends Safe implements Bill.Item{
    public double price;
   
    public PricedSafe(double price){
        super("treedddd");
        this.price = price;
       
    }
    public double getAmount(){
        return price;
   
    }
    public String toString(){
            return "the price is:" + price;
    }
   
 
}