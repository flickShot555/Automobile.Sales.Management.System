import javax.security.auth.login.CredentialNotFoundException;
import java.io.*;
import java.nio.Buffer;
import java.util.*;

class Credentials extends Portals{
    private String username, password;
    static String path;
    Credentials(){}
    Credentials(String abc){
        super(abc);
        if(abc.equals("Login"))
            System.out.println("Login constructor run");
        else
            System.out.println("signup constructor run");
    }
    public void setUsername(String Username){
        this.username = Username;
    }
    public void setPassword(String Password){
        this.password = Password;
    }
    public void WriteToFile(){
        String a = this.username;
        String b = this.password;

        try{
            File FLE = new File("D:\\java files\\Automobile Sales Management System\\" +
                    "a\\b\\c\\d\\e\\Credentials.csv");
            //FLE.createNewFile();
            path = FLE.getAbsolutePath();
            if(!FLE.exists()){
                File obj = new File("D:\\java files\\Automobile Sales Management System\\" +
                        "a\\b\\c\\d\\e\\" +
                        "Credentials.csv");
                FileOutputStream fle = new FileOutputStream("D:\\java files\\Automobile Sales Management System\\" +
                        "a\\b\\c\\d\\e\\Credentials.csv",true);
                PrintWriter pen = new PrintWriter(fle);
                String first = "Usernames"; String second = "Passwords";
                pen.printf("%s,%s",first,second);
                pen.printf("%s,%s\n",a,b);
                System.out.println("successfully written");
                pen.close();
            }
            FileOutputStream fos = new FileOutputStream("D:\\java files\\Automobile Sales Management System\\" +
                    "a\\b\\c\\d\\e\\Credentials.csv",true);
            PrintWriter pen = new PrintWriter(fos);
            pen.printf("%s,%s\n",a,b);
            System.out.println("successfully written");
            pen.close();
        }catch(IOException e){
            //String error = String.valueOf(e.getStackTrace());
            String errorvalue = String.valueOf(e.getStackTrace());
            Errors er = new Errors(errorvalue);
        }
    }

    public boolean verify(String Username, String Password){
        String username = Username,password = Password;
        boolean check = false;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("D:\\java files\\Automobile Sales Management System\\" +
                    "a\\b\\c\\d\\e\\Credentials.csv"));
            String line;
            while((line = br.readLine())!=null){
                String arr[] = line.split(",");
                if((arr[0].equals(username)) && (arr[1].equals(password))){
                    check = true;
                    break;
                }
            }

        }catch(IOException r)
        {
            String errorvalue = String.valueOf(r.getStackTrace());
            Errors er = new Errors(errorvalue);
        }
        if(check)
            return true;
        else
            return false;
    }

    public void delete(String path){
        boolean a = false;
        File obj = new File(path);
        obj.delete();
        if(obj.exists())
            a = true;
        if(a){
            System.out.println("the file did not delete");
        }
        else
            System.out.println("the file has been deleted!");

    }

}