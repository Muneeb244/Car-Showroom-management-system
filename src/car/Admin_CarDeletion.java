package car;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin_CarDeletion extends AdminDeleteCarGui{
    ArrayList<String> arrayList;
    String[] deletion;
    int count;
    int counter;
    File file;

    public Admin_CarDeletion(){
        arrayList = new ArrayList<>();
        deletion = new String[0];
        count = 0;
        counter = 0;
        file = new File("cars.txt");
    }

    protected boolean car_Deletion(String del){

        boolean b = false;
        try{
            Scanner fes = new Scanner(file);
            while(fes.hasNextLine()){
                String now = fes.nextLine();
                deletion = now.split(" ");
                String temp = deletion[0].replace(".", "");
                if(temp.equals(del)){
                    counter = count;
                    b = true;
                }
                else
                    count++;
                arrayList.add(now);
            }

        }
        catch (Exception e){
            System.out.println(e.toString());
        }

        return b;
    }

    protected boolean deleteCar(String del){
        if(car_Deletion(del)){
            arrayList.remove(counter);
            String[] temp = new String[0];
            int num = 1;
            String str;
            for(int i = 0; i<=arrayList.size()-1; i++){
                str = "";
                temp = arrayList.get(i).split(" ");
                for(int j = 1; j<=temp.length-1; j++){
                    str += temp[j] + " ";
                }

                str = num + ". " +  str;
                arrayList.set(i, str.trim());
                num++;
            }
            return arraylist_writer(arrayList, file);
        }
        else{
            return false;
        }

    }

    protected boolean deleteCar(String name, String id){
        boolean b = false;
        try{
            File file = new File("bookinginfo.txt");
            Scanner fes = new Scanner(file);
            while(fes.hasNextLine()){
                String now = fes.nextLine();
                deletion = now.split(" ");
                if((CustomerRecord.str[3].equalsIgnoreCase(deletion[1]) && CustomerRecord.str[1].equalsIgnoreCase(deletion[3])) &&
                        (deletion[7].equalsIgnoreCase(name) && deletion[8].equalsIgnoreCase(id))) {

                    counter = count;
                    b = true;
                }
                else
                    count++;
                arrayList.add(now);
            }
            if(b) {
                arrayList.remove(counter);
                PrintWriter printWriter = new PrintWriter(file);
                for(String s: arrayList) {
                    printWriter.println(s);
                }
                printWriter.close();

            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return b;
    }

    protected boolean arraylist_writer(ArrayList list, File file){

        try{

            FileWriter temp = new FileWriter(file);
            temp.write("");

            FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for(int i = 0; i<=list.size()-1; i++){
                printWriter.println(list.get(i));
            }

            printWriter.close();
            fileWriter.close();


            return true;
        }
        catch (Exception e){
            System.out.println(e.toString());
        }

        return false;
    }
}
