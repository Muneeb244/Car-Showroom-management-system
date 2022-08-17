package car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class AdminShowDeliveredCarsGui implements GUIImplementer{
    protected String[] str = new String[0];
    protected JFrame showcar_frame;

    private JPanel panel;
    private JLabel delivered_cars;

    protected JTextArea info_area;
    private JButton back_button;

    public AdminShowDeliveredCarsGui() {
        showcar_frame = new JFrame("Delivered cars");

        panel = new JPanel(null);

        delivered_cars=new JLabel("Delivered Cars");
        info_area = new JTextArea();
        back_button = new JButton("Back");


    }

    public void GUIInterface(){
        delivered_cars.setBounds(410,20,250,50);
        delivered_cars.setForeground(Color.orange);
        delivered_cars.setFont(new Font("Serif", Font.ITALIC, 35));


        info_area.setBounds(0, 90, 1000, 400);
        info_area.setBackground(new Color(34, 41, 48));
        info_area.setForeground(Color.orange);
        info_area.setFont(new Font("SansSerif", Font.PLAIN, 16));

        panel.setBackground(new Color(34, 41, 48));


        back_button.setBounds(430, 490, 150, 50);
        back_button.setBackground(Color.orange);
        back_button.setForeground(new Color(34, 41, 48));
        back_button.setFont(new Font("SansSerif", Font.BOLD, 25));

        panel.add(info_area);
        panel.add(back_button);
        panel.add(delivered_cars);

        showcar_frame.add(panel);
        showcar_frame.setSize(1000, 600);
        showcar_frame.setVisible(true);
        showcar_frame.setResizable(false);
        showcar_frame.setLocationRelativeTo(null);
        showcar_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        back_button.addActionListener(new ShowCar());
        DeliveryShow();

    }


    class ShowCar implements ActionListener{

        public void actionPerformed(ActionEvent e){
            if(e.getSource()==back_button){
                showcar_frame.dispose();
                AdminMenuGui adminMenuGui=new AdminMenuGui();
                adminMenuGui.GUIInterface();
            }
        }
    }

    public void DeliveryShow(){
        try{
            File file = new File("deliveryrecord.txt");
            Scanner fes = new Scanner(file);
            while(fes.hasNextLine()){
                info_area.append(fes.nextLine() + "\n");
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
