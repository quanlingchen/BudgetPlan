package login.model;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
public class ItemList {
    public final StringProperty id ;
    public final StringProperty name;
	public final StringProperty type;
        
	public final StringProperty date;
	public final StringProperty amount;
	public final StringProperty comment;
        
    public ItemList(String id, String name,String type,String amount,String date,String comment) {
        this.id = new SimpleStringProperty(id );
        this.name = new SimpleStringProperty(name) ;
        this.type = new SimpleStringProperty(type) ;
        this.date = new SimpleStringProperty(date) ;
        this.amount = new SimpleStringProperty(amount) ;
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
    public StringProperty amountProperty() {
        return amount ;
    }
    public StringProperty dateProperty() {
        return date ;
    }
    public StringProperty commentProperty() {
        return comment ;
    }
}