package car;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Admin_AddCar extends Admin_AddCarGui{
    protected boolean carAdd(String name, String company, String model, String price, String engine){
        name = CustomerRecord.nameValidation(name);
        company = CustomerRecord.nameValidation(company);
        model = CustomerRecord.nameValidation(model);
        price = CustomerRecord.nameValidation(price);
        engine = CustomerRecord.nameValidation(engine);


        String[] str = new String[0];
        try{
            int temp = Integer.parseInt(price);
        }
        catch (Exception e) {
            return false;
        }

        try{
            File file = new File("cars.txt");
            FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            Scanner fes = new Scanner(file);
            while(fes.hasNextLine()){
                str = fes.nextLine().split(" ");

            }
            fes.close();
            int num = Integer.parseInt(str[0].replace(".", ""));
            num++;
            String carinfo = num+"." + " Name: " + name + " Company: " + company + " Model: " + model + " Price: " + price + " Engine: " + engine + "CC";

            printWriter.println(carinfo);

            printWriter.close();
            fileWriter.close();

            return true;
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return false;
    }
}
