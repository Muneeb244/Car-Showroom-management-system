package car;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class AdminLogin{
    protected boolean admin_credentials(String username, String password){
        try{
            FileInputStream fileInputStream = new FileInputStream("admininfo.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Admin ad1 = (Admin)objectInputStream.readObject();
            Admin ad2 = (Admin)objectInputStream.readObject();
            
            String Password = ad1.getPassword();
            String UserName = ad1.getUsername();
            username.replaceAll("\n", "");
            password.replaceAll("\n", "");
            UserName.replaceAll("\n", "");
            Password.replaceAll("\n","");
            
            password= Password;
            System.out.print(UserName);
            System.out.print(Password);
            System.out.println(username);
            System.out.println(password);
            
            if(UserName.equals(username) && Password.equals(password)){
                return true;
            }
            if(ad2.getUsername().equals(username) && ad2.getPassword().equals(password)){
                return true;
            }
           

        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return false;
    }
}
