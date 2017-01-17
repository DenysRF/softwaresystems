package ss.week2.hotel;
 
import ss.week1.Password;
 
 
public class Safe {
 
    private boolean status;
    private boolean open;
    private Password passw;
    public Safe mainsafe;
   
    //@ private invariant passw != null;
    /* @ensures
     status = false;
     door = false;
    */
    //requires pass != null;   
   
    public Safe(String pass){
        passw = new Password();
        assert pass != null;
        passw.setWord("yoloswag",pass);
        status = false;
        open = false;
        }
   
    //@ requires text != null;
    //@ ensures isActive() == true || isActive() == false;
    public void activate(String text){
        assert status == false;
        status = passw.testWord(text) || status;
    }
   
    public void main(){
        mainsafe = new Safe("wachtwoord");
        mainsafe.open("wachtwoord");
       
    }
           
    /*@ ensures
     isActive() == true || isActive() == false &&
     isOpen() == true || isOpen() == false;
     */
    public void deactivate(){
        assert status == true;
        open = false;
        status = false;
    }
    //@ requires test != null;
    /*@ ensures
     !isOpen() || isOpen() == true;
     */
    public void open(String test){
        assert status == true;
        assert open == false;
        System.out.println(status);
        if (status == true && status == passw.testWord(test)){
            open = true;
            System.out.println("open" + open);
        }
        System.out.println("open" + open);
    }
    public void close(){
        assert open == true;
        open = false;
    }
   
    /*@ ensures
     isActive() == true || !isActive();
     */
    //@pure
    public boolean isActive(){
        if (status == true) {
            return true;
        }
        else{
        return false;
        }
       
    }
   
    /*@ ensures
     !isOpen() || isOpen() == true;
     */
    //@pure
    public boolean isOpen(){
        if (open == true){
            System.out.println(open);
            return true;
        }
        else{
        System.out.println("isopen" + open);
        return false;
        }
    }
   
   
 
   
    //@pure
    public String getPassword(){
        assert passw != null;
        return passw.password;
        }
}