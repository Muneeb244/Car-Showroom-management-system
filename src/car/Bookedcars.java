package car;

import java.io.File;
import java.util.Scanner;

public class Bookedcars {

    private String car_info;

    public String getCar_info() {
        return car_info;
    }

    protected boolean booked(String match, String combo_selected){
        String str[] = new String[0];
        boolean b = false;
        match+=".";
        try{
            File file = new File("cars.txt");
            Scanner fes = new Scanner(file);
            while(fes.hasNextLine()){
                String now = fes.nextLine();
                str = now.split(" ");
                if(str[0].equals(match)){
                    car_info = "Car_name: " + str[2] + " " + str[6] + " Quantity: " + combo_selected;
                    b = true;
                    break;
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        return b;
    }
}
