package FXproject;

import java.io.IOException;
import java.util.ArrayList;
import jxl.read.biff.BiffException;

public class TestingBeforeGUI {
        private static ArrayList <String> guiOperations = new ArrayList <String>();
        private static ArrayList <String> guiObjects = new ArrayList <String>();
        
        public static ArrayList <String> getGuiOperations (){
                return TestingBeforeGUI.guiOperations;
        };
        
        public static ArrayList <String> getGuiObjects (){
                return TestingBeforeGUI.guiObjects;
        };
        
        public static void addOperation(){
                for(int x = 0 ; x < UtilityClass.getUtilityOperations().size() ; x++  ){
                        String operation = "" ;
                        operation = operation + UtilityClass.getUtilityOperations().get(x).getName() + " operation" + "\n\n" ;
                        guiOperations.add(operation);
                }
        };
        
         
        public static void addGuiObject (){  
                for( int i = 0 ; i < UtilityClass.getUtilityOpjects().size()  ; i++ ){
                String object = "" ;
                object = object + UtilityClass.getUtilityOpjects().get(i).getName() +"\n\n\n\n" + "object name: " + UtilityClass.getUtilityOpjects().get(i).getName() + "\n" + "mandatory: " + UtilityClass.getUtilityOpjects().get(i).getMandatory() +"\n\n" ;
                
                if ( !(UtilityClass.getUtilityOpjects().get(i).getChildObject() == null) ){
                        object =  object + "child object name: "  + UtilityClass.getUtilityOpjects().get(i).getChildObject().getName() + "\n\n" ;
                }
                        
                object = object + "\n\n\n" + "Object fields:" + "\n\n\n" ;

                for( int j = 0 ; j < UtilityClass.getUtilityOpjects().get(i).getFields().size() ; j++ ){
                        object = object + UtilityClass.getUtilityOpjects().get(i).getFields().get(j).getName() + "\n" + "allowed values: " + UtilityClass.getUtilityOpjects().get(i).getFields().get(j).getAllowedValues() +  "\n"+"mandatory: "  +  UtilityClass.getUtilityOpjects().get(i).getFields().get(j).getMandatory() + "\n\n";                                             
                }
                        
                object = object + "\n\n"+"Type of all object fields is STRING" ;
                guiObjects.add(object);
                }
        };
        
        public static void main(String[] args) throws IOException, BiffException {
                UtilityClass.main(null);
                addOperation();
                addGuiObject();
                System.out.println(guiObjects.size());
                System.out.println(guiOperations.size());                
        }
}
