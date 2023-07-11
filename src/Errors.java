import java.io.FileWriter;
import java.io.IOException;
import java.time.*;

class Errors{
    Errors(String abc){
        try{
            FileWriter fw = new FileWriter("D:\\java files\\Automobile Sales Management System\\a\\b\\c\\d\\e\\Errors.txt");
            LocalDateTime currenttime = LocalDateTime.now();
            fw.write(abc + " "+ currenttime + "\n");
        }catch(IOException r){
            String errorlabel = String.valueOf(r.getStackTrace());
            System.out.println(errorlabel);

        }
    }
}