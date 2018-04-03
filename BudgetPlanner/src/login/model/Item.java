package login.model;

import java.util.HashMap;
import java.util.Map;
/**
 * Item Model.
 * 
 * @author Deepak Csac, Quanling Chen, Harika Badugu
 * @version     1.0
 * @since       2018-03-05
 */
public class Item {

    private static final Map<String, Item> ITEMS = new HashMap<String, Item>();
    public int getSize(){
        return ITEMS.size();
    }
    public static Item of(String id) {
        Item item = ITEMS.get(id);
        if (item == null) {
            item = new Item(id);
            ITEMS.put(id, item);
        }
        return item;
    }
    public static Item off(String id) {
        Item item = ITEMS.get(id);
        if (item != null) {
            //item = new Item(id);
            ITEMS.remove(id);
        }
        return item;
    }
    private Item(String id) {
        this.id = id;
    }
    private String id;

    public String getId() {
        return id;
    }
    private int type = 1;
    private String amount ="";
    private String date = "";
    private String comment = "";
    private String name = "";
    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the phone to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
