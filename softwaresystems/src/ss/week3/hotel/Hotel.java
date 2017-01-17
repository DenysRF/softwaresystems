package ss.week3.hotel;
 
import ss.week3.hotel.Password;
import ss.week3.hotel.Room;
import ss.week3.hotel.Guest;
 
public class Hotel {
    private Password password;
    private Room[] rooms;
    private Guest[] guests;
    private String name;
    //@ private invariant password != null;
    
 
    public Hotel(String name){
        this.name = name;
        password = new Password();
        rooms = new Room[2];
        rooms[0] = new Room(111, new Safe ("password"));
        rooms[1] = new Room(112, new Safe ("password"));
        guests = new Guest[2];
       
       
    }
   
    public Room checkIn(String password, String name){
        Room r = null;
        if(this.password.testWord(password) && getFreeRoom() != null && getRoom(name) == null){
            Guest guest = new Guest (name);
            r = getFreeRoom();
            guest.checkin(r);
            for(Guest g: guests){
                if (g == null) {
                    g = guest;
                    break;
                }
            }
        }
        return r;
    }
 
    public void checkOut(String name){
        Room r = getRoom(name);
        if(r != null){
            r.getGuest().checkout();
        }
    }
 
    public Room getFreeRoom(){
        for(Room r: rooms){
            if (r.getGuest() == null){
                return r;
            }
        }
        return null;
    }
 
    public Room getRoom(String name){
        for(Room r: rooms){
            if (r.getGuest() != null && r.getGuest().getName().equals(name)){
                return r;
            }
        }
        return null;
    }
 
    public Password getPassword(){
        return password;
    }
 
    public String getName(){
        return name;
    }
 
    public String toString(){
        String result;
        result = "Hotel " + name + " has " + rooms.length + " rooms.";
        int i = 0;
        for(Room r: rooms){
            if(r.getGuest() != null){
                result += " One room has a guest named: " + r.getGuest().getName() + ".";
            }else{
                i ++;
            }
        }
        result += " There are " + i + " empty rooms.";
        return result;
    }
    
    public Bill getBill(String name, int nights, java.io.PrintStream theOutStream){
        Bill bill = new Bill(theOutStream);
        Room room = getRoom(name);
        if (room instanceof PricedRoom) {
            for (int i = 0; i <= nights; i++){
                PricedRoom r = (PricedRoom) room;
                bill.newItem(r);
                Safe safe = r.getSafe();
                if (safe instanceof PricedSafe){
                    PricedSafe s = (PricedSafe) safe;
                    bill.newItem(s);   
                }
               
            }
        return bill;
        }else{
        return null;
        }
    }
    
    
    
}