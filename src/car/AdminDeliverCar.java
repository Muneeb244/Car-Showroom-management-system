package car;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminDeliverCar {
    boolean b;
    ArrayList<String> arrayList;
    String[] car_delete;
    int count;
    int counter;
    File file;
    String delivered;

    public AdminDeliverCar() {
        arrayList = new ArrayList<String>();
        car_delete = new String[0];
        b = false;
        count = 0;
        counter = 0;
        delivered = null;
    }

    protected boolean deletecar(String owner_name, String car_name, String model) {
        try {
            File file = new File("bookinginfo.txt");
            Scanner fes = new Scanner(file);
            while (fes.hasNextLine()) {
                String now = fes.nextLine();
                car_delete = now.split(" ");

                if (car_delete[1].equalsIgnoreCase(owner_name) && car_delete[7].equalsIgnoreCase(car_name) && car_delete[8].equalsIgnoreCase(model)) {
                    counter = count;
                    b = true;
                } else
                    count++;
                arrayList.add(now);
            }
            if(b) {
                delivered = arrayList.get(counter);
                arrayList.remove(counter);
                PrintWriter printWriter = new PrintWriter(file);
                for(String s: arrayList) {
                    printWriter.println(s);
                }
                printWriter.close();

            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        delivered();
        return b;
    }

    protected void delivered(){
        try{
            File file = new File("deliveryrecord.txt");
            FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(delivered);

            printWriter.close();
            fileWriter.close();

        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
}