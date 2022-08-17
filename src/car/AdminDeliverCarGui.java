package car;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AdminDeliverCarGui implements GUIImplementer{

    private JFrame showcar_frame;

    private JPanel panel;

    private JLabel lModel;
    private JLabel l_owner;
    private JLabel l_carname;
    private JLabel deliver_car;

    private JTextField t_model;
    private JTextField t_owner;
    private JTextField t_carname;


    protected JTextArea info_area;

    private JButton back_button;
    private JButton deliver_button;
    private JButton clear_button;


    public AdminDeliverCarGui() {

        showcar_frame = new JFrame("Available cars");

        panel = new JPanel(null);

        clear_button = new JButton("Clear");
        deliver_car=new JLabel("Deliver Car");

        info_area = new JTextArea();
        lModel = new JLabel("Model Name:");
        l_owner = new JLabel("Owner Name:");
        l_carname = new JLabel("Car Name:");

        t_model = new JTextField();
        t_carname = new JTextField();
        t_owner = new JTextField();


        back_button = new JButton("Back");

        deliver_button = new JButton("Deliver");

    }
    public void GUIInterface(){

        info_area.setBounds(0, 80, 1200, 300);
        info_area.setBackground(new Color(34, 41, 48));
        info_area.setForeground(Color.orange);
        info_area.setFont(new Font("SansSerif", Font.PLAIN, 18));



        deliver_car.setBounds(500,20,250,50);
        deliver_car.setForeground(Color.orange);
        deliver_car.setFont(new Font("Serif", Font.ITALIC, 35));


        lModel.setFont(new Font("SansSerif", Font.BOLD, 20));
        lModel.setBounds(400, 270, 500, 500);
        lModel.setForeground(Color.orange);

        l_carname.setFont(new Font("SansSerif", Font.BOLD, 20));
        l_carname.setBounds(400, 230, 500, 500);
        l_carname.setForeground(Color.orange);

        l_owner.setFont(new Font("SansSerif", Font.BOLD, 20));
        l_owner.setBounds(400, 190, 500, 500);
        l_owner.setForeground(Color.orange);

        t_model.setBounds(550, 505, 150, 30);
        t_carname.setBounds(550, 505-40, 150, 30);
        t_owner.setBounds(550, 505-80, 150, 30);

        back_button.setBounds(290, 580, 150, 50);
        back_button.setBackground(Color.orange);
        back_button.setForeground(new Color(34, 41, 48));
        back_button.setFont(new Font("SansSerif", Font.BOLD, 25));


        panel.setBackground(new Color(34, 41, 48));


        deliver_button.setBounds(480, 580, 150, 50);
        deliver_button.setBackground(Color.orange);
        deliver_button.setForeground(new Color(34, 41, 48));
        deliver_button.setFont(new Font("SansSerif", Font.BOLD, 25));


        clear_button.setBounds(670, 580, 150, 50);
        clear_button.setBackground(Color.orange);
        clear_button.setForeground(new Color(34, 41, 48));
        clear_button.setFont(new Font("SansSerif", Font.BOLD, 25));

        panel.add(info_area);
        panel.add(lModel);
        panel.add(l_carname);
        panel.add(l_owner);

        panel.add(t_carname);
        panel.add(t_model);
        panel.add(t_owner);

        panel.add(back_button);
        panel.add(deliver_button);
        panel.add(clear_button);
        panel.add(deliver_car);

        showcar_frame.add(panel);
        showcar_frame.setSize(1150, 700);
        showcar_frame.setVisible(true);
        showcar_frame.setResizable(false);
        showcar_frame.setLocationRelativeTo(null);
        showcar_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showCars();

        back_button.addActionListener(new ShowCar());
        clear_button.addActionListener(new ShowCar());
        deliver_button.addActionListener(new ShowCar());


    }
    private void showCars(){
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


    class ShowCar implements ActionListener {

        public void actionPerformed(ActionEvent e){
            if(e.getSource()==back_button){
                showcar_frame.dispose();
                AdminMenuGui adminMenuGui=new AdminMenuGui();
                adminMenuGui.GUIInterface();
            }

            if(e.getSource() == deliver_button){
                showcar_frame.dispose();
                AdminDeliverCar adminDeliverCar = new AdminDeliverCar();
                if(adminDeliverCar.deletecar(t_owner.getText(), t_carname.getText(), t_model.getText()) &&
                !(t_owner.getText().equals("") || t_carname.getText().equals("") || t_model.getText().equals(""))){

                    JOptionPane.showMessageDialog(null, "Order Delivered!!!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Enter valid details!!!");
                }
                AdminMenuGui adminMenuGui=new AdminMenuGui();
                adminMenuGui.GUIInterface();
            }

            if(e.getSource()==clear_button){
                t_model.setText("");
                t_carname.setText("");
                t_owner.setText("");
            }
        }
    }
}
