package FXproject;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import  jxl.Cell;
import  jxl.Sheet;
import  jxl.Workbook;
import  jxl.read.biff.BiffException;
import  jxl.write.*;
import  jxl.write.Number;

public class UtilityClass {
    private static   ServiceClass service = new ServiceClass();
    private static ArrayList<FieldClass> utilityFields = new ArrayList<FieldClass>();
    private static ArrayList<ObjectClass> utilityObjects = new ArrayList<ObjectClass>();
    private static ArrayList<OperationClass> utilityOperations = new ArrayList<OperationClass>();
    
    public static ArrayList<OperationClass> getUtilityOperations(){
        return utilityOperations ;
    };
    
    public static ArrayList<ObjectClass> getUtilityOpjects (){
        return utilityObjects ;
    };
    
    public static ArrayList<FieldClass> getUtilityFields(){
        return utilityFields ;
    };

    public static void main(String[] args) throws IOException, BiffException {
        File file = new File("XLS.xls");
        Workbook utilityWorkbook = Workbook.getWorkbook(file);
        Sheet utilitySheet = utilityWorkbook.getSheet(0);
        int rows = utilitySheet.getRows();
        int columns = utilitySheet.getColumns();
        
        for (int i = 0 ; i < rows ; i++){
            for (int j = 0 ; j < columns ; j++){
                Cell advCell = utilitySheet.getCell( j , i );
                String cellContent = advCell.getContents() ;
                
                if (cellContent.matches("(.*)Operation")){
                   String[] content1 = cellContent.split(" ");
                   utilityOperations.add(new OperationClass ( content1[0] ));
                   service.addOperation(utilityOperations.get(utilityOperations.size()-1));
                }
                else if ( cellContent.matches("/object(.*)") ){
                    String[] content2 = cellContent.split("/");
                    int length = content2.length;
                    Cell typeCell = utilitySheet.getCell( j+1 , i );
                    String typeContent = typeCell.getContents() ;
                    Cell mandatoryCell = utilitySheet.getCell( j+3 , i );
                    String mandatoryContent = mandatoryCell.getContents() ;
                    Cell valuesCell = utilitySheet.getCell( j+2 , i );
                    String valuesContent = valuesCell.getContents() ;
    
                    if( typeContent.matches("string") ){
                    utilityFields.add(new FieldClass( content2[length-1] , valuesContent , mandatoryContent ));
                    utilityObjects.get(utilityObjects.size()-1).addObjectField(utilityFields.get(utilityFields.size()-1));                 
                    }
                    else if( typeContent.matches("object(.*)") ){
                        if( cellContent.matches("/object(.*)") && !(cellContent.matches("/object(.*)object(.*)")) ){
                        utilityObjects.add( new ObjectClass( content2[1] , mandatoryContent ) );
                        (utilityOperations.get(utilityOperations.size()-1)).addObject(utilityObjects.get(utilityObjects.size()-1));
                        }
                        else if ( cellContent.matches("/object(.*)object(.*)") ){
                            for(int x = length ; x>2 ; x-- ){
                            utilityObjects.add( new ObjectClass( content2[x-1] , mandatoryContent ) ); 
                            utilityObjects.get(utilityObjects.size()-2).setChildObject(utilityObjects.get(utilityObjects.size()-1));                                    
                            utilityOperations.get( utilityOperations.size()-1).addObject(utilityObjects.get(utilityObjects.size()-1));                            
                            }
                        }
                    }
                }  
            }
        }
    }    
}
