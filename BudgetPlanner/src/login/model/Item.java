package login.model;

import java.util.Date;
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
            item.setItem(id,"new item",1,0,new Date(),"");
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
    private String userId = "";
    private String planId = "";
    private int type = 1;
    private double amount =0;
    private Date date = null;
    private String comment = "";
    private String name = "";
    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
    public static boolean has(String id) {
        
        return ITEMS.containsKey(id);
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
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    /**
     * @return the planId
     */
    public String getPlanId() {
        return planId;
    }

    /**
     * @param planId the planId to set
     */
    public void setPlanId(String planId) {
        this.planId = planId;
    }
    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
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
public void setItem(String id, String name,int type,double Amount,Date date,String comment) {
        this.id = id ;
        this.name = name ;
        this.date=date;
        this.amount=amount;
        this.type = type ;
        this.comment = comment ;
    }
}
