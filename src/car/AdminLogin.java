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
            System.out.print(ad1.getUsername());
            System.out.print(ad1.getPassword());
            if(ad1.getUsername().equals(username) && ad1.getPassword().equals(password)){
                return true;
            }


            if(ad2.getUsername().equalsIgnoreCase(username) && ad2.getPassword().equals(password)){
                return true;
            }

        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return false;
    }
}
