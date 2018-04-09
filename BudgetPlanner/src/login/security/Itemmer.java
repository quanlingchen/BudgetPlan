package login.security;

import java.util.HashMap;
import java.util.Map;
import login.model.Item;
import java.util.Date;
/**
 * Itemner.
 * 
 * @author Deepak Csac, Quanling Chen, Harika Badugu
 * @version     1.0
 * @since       2018-03-05
 */

public class Itemmer {
    private final String DB_URL = "jdbc:derby:BudgetDB;create=true";
    private final  String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private final  String TABLE_NAME = "students";

    private Map<String, Item> ITEMS = new HashMap<>();
    public Map<String, Item> getAll(){
        return ITEMS;
    }
    /*
    public  boolean validate(String id, String password){
        String validUserPassword = ITEMS.get(user);
        return validUserPassword != null && validUserPassword.equals(password);
    }*/
    public boolean removeItem(String user){
        if (ITEMS.containsKey(user)) {
            ITEMS.remove(user);
            return true;
        }
        return false;
    }
    public boolean addItem(String id){
        if (ITEMS.containsKey(id)) 
            return false;
        Item p=Item.of(id);
        Date date=new Date();
        p.setItem(id,"new plan",1,0, date,"");
        ITEMS.put(id, p);
        return true;
    }
    public boolean isExist(String user){
        
        return ITEMS.containsKey(user);
    }
    
    public void setItem(String id, Item pl){
        
        if( ITEMS.containsKey(id)){
            ITEMS.put(id, pl);
        }
    }
    
    private static Itemmer instance = null;
   protected Itemmer() {
      //read database for password
      // Exists only to defeat instantiation.
      Date date=new Date();
      Item p = Item.of("1");
        p.setItem("1","aaa",1,35, date,"taoyan");
      ITEMS.put("1", p);
      Item p1=Item.of("2");
        p1.setItem("2","ccc",0,44, date,"regular");
      ITEMS.put("2", p1);

   }
   public static Itemmer getInstance() {
      if(instance == null) {
         instance = new Itemmer();
      }
      return instance;
   }
}
