package car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class AdminShowBookedCarsGui implements GUIImplementer{
    protected String[] str = new String[0];
    protected JFrame showcar_frame;

    private JPanel panel;
    private JLabel booked_cars;

    protected JTextArea info_area;
    private JButton back_button;

    public AdminShowBookedCarsGui() {
        showcar_frame = new JFrame("Booked cars");

        panel = new JPanel(null);

        booked_cars=new JLabel("Booked Cars");
        info_area = new JTextArea();
        back_button = new JButton("Back");


    }

    public void GUIInterface(){
        booked_cars.setBounds(430,20,250,50);
        booked_cars.setForeground(Color.orange);
        booked_cars.setFont(new Font("Serif", Font.ITALIC, 35));


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
        panel.add(booked_cars);

        showcar_frame.add(panel);
        showcar_frame.setSize(1000, 600);
        showcar_frame.setVisible(true);
        showcar_frame.setResizable(false);
        showcar_frame.setLocationRelativeTo(null);
        showcar_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showBookedCars();

        back_button.addActionListener(new ShowCar());

    }

    private void showBookedCars(){
        File file = new File("bookinginfo.txt");
        try{
            Scanner fes = new Scanner(file);
            while(fes.hasNextLine()){
                info_area.append(fes.nextLine() + "\n");
            }
            fes.close();

        }
        catch(Exception e){
            System.out.println(e.toString());
        }
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
}
