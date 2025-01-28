import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Writer extends Vehicle {
    /*private String name_of_file;
    Writer(String username){
        this.name_of_file = username;
    }*/
Writer(){}
    Writer(String vehicletype, String company, String name, String VIN, String prodyear, String price, String username ){
        write(vehicletype, company,name,VIN, prodyear,price, username);//this overrides the abstract method "write" in abstract class Vehicle.
    }
    /*public void logout(){
        this.name_of_file = null;
    }*/
    void write(String vehicletype, String company, String name, String VIN, String prodyear, String price, String name_of_file) {
        try {
            Date currentDate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
            String formattedDate = dateFormat.format(currentDate);
            System.out.println(formattedDate);
            FileOutputStream fos = new FileOutputStream("\\a\\b\\c\\d\\e\\"+name_of_file+".csv",true);
            PrintWriter fw = new PrintWriter(fos);
            fw.printf("%s,%s,%s,%s,%s,%s,%s\n",vehicletype,company,name,VIN,prodyear,price,formattedDate);
            fw.close();
        }catch(IOException r){
            String a = String.valueOf(r.getStackTrace());
            Errors er = new Errors(a);
        }
    }

}

