import java.io.*;

public class Portals {
    Portals(){}
    Portals(String abc){
        try{
            FileWriter fw = new FileWriter("D:\\java files\\Automobile Sales Management System\\a\\b\\c\\d\\e\\Number of Portals.txt");
            fw.write("new portal for "+abc+" successfully created!\n");
            fw.close();
        }catch(IOException r){
            String errorValue = String.valueOf(r.getStackTrace());
            Errors er = new Errors(errorValue);
        }
    }
}


