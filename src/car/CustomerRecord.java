package car;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class CustomerRecord {
    protected String f_name;
    protected String l_name;
    protected int id;
    protected String phone_no;
    protected String gender;
    protected String address;
    protected String CNIC;
    File f;
    Random random;
    protected static String[] str;

    public CustomerRecord(){
        f_name = null;
        l_name = null;
        phone_no = null;
        gender = null;
        address = null;
        f = new File("customer.txt");
        random = new Random();
        id = random.nextInt(10000)+1;
        str = new String[0];
    }


    protected void signUp(){
        try{

            FileWriter fileWriter = new FileWriter(f, true);
            BufferedWriter buff = new BufferedWriter(fileWriter);
            String str = "ID: " + id + " Name: " + f_name + "_" + l_name + " Gender: " + gender +  " Phone_Number: " + phone_no +
                    " Address: " + address + " CNIC: " + CNIC;

            buff.newLine();
            fileWriter.write(str);

            buff.close();
            fileWriter.close();


        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }

    protected boolean signIN(String fname, String lname, Long cnic){
        boolean b = false;
        String check = fname + "_" + lname;
        try{
            Scanner fes = new Scanner(f);
            while(fes.hasNextLine()){
                str = fes.nextLine().split(" ");
                //System.out.println(Long.parseLong(str[11])); 
                if(Long.parseLong(str[11]) == cnic && check.equalsIgnoreCase(str[3])){
                	//out.println(str[3]+ check);
                    b = false;
                    break;
                }
                else b = true;
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return b;
    }

    protected static String nameValidation(String str){
        for(int i = 0; i<=str.length()-1; i++){
            if(str.charAt(i) == ' '){
                str = str.replace(" ", "_");
            }
        }
        return str;
    }



    public String[] getStr() {
        System.out.println(str.length);
        return str;
    }

    public String toString(){
        return ("\nFirst Name: "+f_name+"\nLast Nama: "+l_name+"\nID: "+id+"\nCNIC: "+CNIC+"\nPhone No.: "+phone_no+"\nAddress: "+address);
    }
}