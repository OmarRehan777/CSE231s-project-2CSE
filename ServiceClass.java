package FXproject;

import java.util.ArrayList;

public class ServiceClass {
    public ServiceClass (){};
    private ArrayList<OperationClass> servOperations  = new ArrayList<OperationClass>();
    
    public void addOperation( OperationClass operation ){
        this.servOperations.add(operation);
    };
    
    public ArrayList<OperationClass> getOperations (){
        return this.servOperations;
    }; 
}
