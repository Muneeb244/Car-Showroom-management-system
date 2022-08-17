package car;

import java.io.File;
import java.util.Scanner;

public class CancelOrder extends CancelOrderGui {
    private String[] str;
    private boolean b = false;

    public CancelOrder() {
        str = new String[0];
    }

    protected boolean booked_car_checker() {
        try {
            File file = new File("bookinginfo.txt");
            Scanner fes = new Scanner(file);
            while (fes.hasNextLine()) {
                String now = fes.nextLine();
                str = now.split(" ");
                if (CustomerRecord.str[3].equalsIgnoreCase(str[1]) && CustomerRecord.str[1].equalsIgnoreCase(str[3])) {
                    b = true;
                }
            }
            fes.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return b;
    }
}
