package ss.week3.hotel;
/**
 *
 * @author Sander, Denys
 *@version 1.0
 */
 
public class Guest {
    /** create @param name with type String
     */
    private String name;
    /** create @param room with type Room from Room.java
     */
    private Room room;
   
    /** creates a new guest with the name @param name
     */
    public Guest(String name){
        this.name = name;
    }
   
    /** return the name of the guest
    @return name
     */
    public String getName(){
        return name;
    }
    /** return the room the guest is staying in
     *
     * @return the @param room
     */
    public Room getRoom(){
        return room ;
    }
    /** function to check into a room */
    public boolean checkin(Room r) {
        /**check if we have a room or not, if room != null the guest already has a room */
        if (room != null) {
            return false;
        }
        /**check if the room is occupied, if (r.getGuest() != null, the room is already occupied*/
        if (r.getGuest() != null) {
            return false;
        }
        /** else set room to r and set room.setguest to guest*/
       
        room = r;
        room.setGuest(this);
        return true;
    }
    /** function to checkout of a room */
   
    public boolean checkout(){
        /** if the room == null, the room isnt taken so we cant checkout*/
       
        if (room == null){
            return false;
        }
        /** else set the guest of the room to null and set room of the guest to null*/
        room.setGuest(null);
        room = null;
       
        return true;
    }
   
    @Override
    /** return the name and room of the guest*/
 
    public String toString(){
        return "Guest: " + name + "\nRoom: " + room.getNumber();
    }
 
}