package login.model;

import java.util.HashMap;
import java.util.Map;
/**
 * Plan Model.
 * 
 * @author Deepak Csac, Quanling Chen, Harika Badugu
 * @version     1.0
 * @since       2018-03-05
 */
public class Plan {

    private static final Map<String, Plan> PLANS = new HashMap<String, Plan>();

    public static Plan of(String id) {
        Plan plan = PLANS.get(id);
        if (plan == null) {
            plan = new Plan(id);
            //PLANS.put(id, plan);
            
            //Plan p=Plan.of(id);
        plan.setPlan(id,"new plan",1,"");
        PLANS.put(id, plan);
        }
        return plan;
    }
    public static Plan off(String id) {
        Plan plan = PLANS.get(id);
        if (plan != null) {
            //plan = new Plan(id);
            PLANS.remove(id);
        }
        return plan;
    }
    public static boolean has(String id) {
        
        return PLANS.containsKey(id);
    }
    private Plan(String id) {
        this.id = id;
    }
    private String id;

    public String getId() {
        return id;
    }
    private int type = 1;
    private String name ="";
    private String comment = "";
    private String userId = "";

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }
public void setPlan(String id, String name,int type,String comment) {
        this.id = id ;
        this.name = name ;
        this.type = type ;
        this.comment = comment ;
    }
    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
    public int getSize(){
        return PLANS.size();
    }
}
