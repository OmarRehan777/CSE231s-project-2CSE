package FXproject;

public class FieldClass {
    public FieldClass( ){};
    
    public FieldClass( String name , String valuesAllowed , String mandatory  ){
        this.name = name;
        this.type = "string";
        if( valuesAllowed.matches("")){ this.valuesAllowed = "all";}
        else {this.valuesAllowed = valuesAllowed;}
        this.mandatory = mandatory;
    };
    
    private String type;
    private String name;
    private String mandatory;
    private String valuesAllowed;
    
    public void setMandatory (String mandatory){
        this.mandatory = mandatory;
    };
    
    public void setAllowedValues (String valuesAllowed){
        this.valuesAllowed = valuesAllowed;
    };
    
    public String getName (){
        return this.name;
    };
    
    public String getMandatory ( ){
        return this.mandatory;
    };
    
    public String getAllowedValues (  ){
        return this.valuesAllowed;
    };
}
