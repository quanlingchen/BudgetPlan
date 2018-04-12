package login.security;

import java.util.HashMap;
import java.util.Map;
import login.model.Plan;
/**
 * Planner.
 * 
 * @author Deepak Csac, Quanling Chen, Harika Badugu
 * @version     1.0
 * @since       2018-03-05
 */

public class Planner {
    private Map<String, Plan> PLANS = new HashMap<>();
    public Map<String, Plan> getAll(){
        return PLANS;
    }

    public boolean removePlan(String user){
        if (PLANS.containsKey(user)) {
            PLANS.remove(user);
            return true;
        }
        return false;
    }
    public boolean addPlan(String id){
        if (PLANS.containsKey(id)) 
            return false;
        Plan p = Plan.of(id);
        p.setPlan(id,"new plan",1,"");
        PLANS.put(id, p);
        return true;
    }
    public boolean isExist(String user){
        
        return PLANS.containsKey(user);
    }
    
    public void setPlan(String id, Plan pl){
        
        if( PLANS.containsKey(id)){
            PLANS.put(id, pl);
        }
    }
    
    private static Planner instance = null;
    protected Planner() {
       /*
      //read database for password
      // Exists only to defeat instantiation.
      Plan p = Plan.of("1");
        p.setPlan("1","abc",1,"taoyan");
        
      PLANS.put("1", p);
      Plan p1=Plan.of("2");
        p1.setPlan("2","bbc",0,"regular");
      PLANS.put("2", p1);
      DBManager d= new DBManager();
        //d.connect();
      try
      {
          
            for (User temp : d.getPlan(id)) {
                User.of(temp.getId()).setAnswer(temp.getAnswer());
                User.of(temp.getId()).setQuiz(temp.getQuiz());
                User.of(temp.getId()).setEmail(temp.getEmail());
                 User.of(temp.getId()).setPassword(temp.getPassword());
                //Authenticator.getInstance().addUser(temp.getId());
            }
            
      }catch (Exception ex){
          System.out.println("Fail to load. main");
      }*/

   }
   public static Planner getInstance() {
      if(instance == null) {
         instance = new Planner();
      }
      return instance;
   }
}
