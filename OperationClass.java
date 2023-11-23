package FXproject;

import java.util.ArrayList;

public class OperationClass {
    public OperationClass( ){};
    
    public OperationClass(String name){
        this.name = name ;
    };
    
    private String name ;
    private ArrayList<ObjectClass> objects = new ArrayList<ObjectClass>();
    
    public void addObject ( ObjectClass object ){
        this.objects.add(object);
    };
    
    public String getName (){
        return this.name;
    };
    
    public ArrayList<ObjectClass> getObjects(){
        return this.objects;
    };
    
    public void setName ( String name ){
        this.name = name;
    }; 
}
