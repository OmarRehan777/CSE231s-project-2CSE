package FXproject;

import java.util.ArrayList;

public class ObjectClass {
    int getObjectFields;
    public ObjectClass(){};
    
    public ObjectClass( String name , String mandatory ){
        this.name = name ;
        this.type = "object";
        this.mandatory = mandatory;
    };
    
    private String type;
    private String name;
    private ObjectClass ChildObject ;
    private String mandatory ;
    private ArrayList <FieldClass> fields = new ArrayList <FieldClass>();

    public void setMandatory( String mandatory ){
        this.mandatory = mandatory;
    };
    
    public void addObjectField( FieldClass field ){
        this.fields.add(field) ;
    };
    
    public void setChildObject( ObjectClass ChildObject ){
        this.ChildObject = ChildObject;
    };
    
    public String getMandatory(){
        return this.mandatory;
    };
    
    public ArrayList<FieldClass> getFields(){
        return this.fields;
    };
    
    public ObjectClass getChildObject(){
        return this.ChildObject;
    };
    
    public String getName() {     
        return this.name;
    }
}
