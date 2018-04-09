package login.model;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
public class PlanList {
    public final StringProperty id ;
    public final StringProperty name;
	public final StringProperty type;
	public final StringProperty comment;
        
    public PlanList(String id, String name,String type,String comment) {
        this.id = new SimpleStringProperty(id );
        this.name = new SimpleStringProperty(name) ;
        this.type = new SimpleStringProperty(type) ;
        this.comment = new SimpleStringProperty(comment) ;
    }
    public StringProperty idProperty() {
        return id;
    }
    
    public StringProperty nameProperty() {
        return name ;
    }
   public StringProperty typeProperty() {
        return type ;
    }
    public StringProperty commentProperty() {
        return comment ;
    }
}