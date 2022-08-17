package car;

import java.io.File;
import java.util.Scanner;

public class ShowCar extends ShowCarGUI{
    private String[] str;
    private boolean b = false;

    protected boolean showingCars(){
        try{
            File file = new File("bookinginfo.txt");
            Scanner fes = new Scanner(file);
            while(fes.hasNextLine()){
                String now = fes.nextLine();
                str = now.split(" ");
                if(CustomerRecord.str[3].equalsIgnoreCase(str[1]) && CustomerRecord.str[1].equalsIgnoreCase(str[3])){
                    info_area.append(now + "\n");

                    b = true;
                }
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return b;
    }

}
