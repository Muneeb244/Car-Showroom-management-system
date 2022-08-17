package car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;


public class CancelOrderGui extends Admin_CarDeletion implements GUIImplementer{
    protected String[] str = new String[0];
    protected JFrame showcar_frame;

    private JPanel panel;

    private JLabel cancel_car;

    private JLabel question;
    private JLabel l_car_name;
    private JLabel l_car_model;

    protected JTextField t_car_name;
    protected JTextField t_car_model;

    protected JTextArea info_area;
    private JButton back_button;
    private JButton cancel_button;
    private JButton clear_button;


    public CancelOrderGui() {
        showcar_frame = new JFrame("Cancel Car Order");
        panel = new JPanel(null);

        info_area = new JTextArea();

        cancel_car=new JLabel("Cancel Order");

        question = new JLabel("Which Order do you want to Cancel?");

        l_car_name = new JLabel("Enter Car Name:");
        t_car_name = new JTextField();

        l_car_model = new JLabel("Enter Car Model:");
        t_car_model = new JTextField();


        t_car_name = new JTextField();
        t_car_model  = new JTextField();


        back_button = new JButton("Back");

        cancel_button = new JButton("Cancel");

        clear_button = new JButton("Clear");

    }

    public void GUIInterface() {
        info_area.setBounds(0, 80, 700, 350);
        info_area.setBackground(new Color(34, 41, 48));
        info_area.setForeground(Color.orange);
        info_area.setFont(new Font("SansSerif", Font.PLAIN, 16));

        cancel_car.setBounds(265, 20, 250, 50);
        cancel_car.setForeground(Color.orange);
        cancel_car.setFont(new Font("Serif", Font.ITALIC, 35));

        question.setFont(new Font("Serif", Font.ITALIC, 25));
        question.setBounds(170, 190, 500, 500);
        question.setForeground(Color.orange);

        l_car_name.setFont(new Font("SansSerif", Font.BOLD, 20));
        l_car_name.setBounds(210, 230, 500, 500);
        l_car_name.setForeground(Color.orange);

        l_car_model.setFont(new Font("SansSerif", Font.BOLD, 20));
        l_car_model.setBounds(210, 270, 500, 500);
        l_car_model.setForeground(Color.orange);

        t_car_name.setBounds(390, 468, 100, 30);

        t_car_model.setBounds(390, 508, 100, 30);

        back_button.setBounds(90, 580, 150, 50);
        back_button.setBackground(Color.orange);
        back_button.setForeground(new Color(34, 41, 48));
        back_button.setFont(new Font("SansSerif", Font.BOLD, 25));

        panel.setBackground(new Color(34, 41, 48));

        cancel_button.setBounds(280, 580, 150, 50);
        cancel_button.setBackground(Color.orange);
        cancel_button.setForeground(new Color(34, 41, 48));
        cancel_button.setFont(new Font("SansSerif", Font.BOLD, 25));

        clear_button.setBounds(470, 580, 150, 50);
        clear_button.setBackground(Color.orange);
        clear_button.setForeground(new Color(34, 41, 48));
        clear_button.setFont(new Font("SansSerif", Font.BOLD, 25));

        panel.add(info_area);
        panel.add(l_car_name);
        panel.add(t_car_name);
        panel.add(l_car_model);
        panel.add(t_car_model);
        panel.add(question);

        panel.add(back_button);
        panel.add(cancel_button);
        panel.add(clear_button);
        panel.add(cancel_car);

        showcar_frame.add(panel);
        showcar_frame.setSize(700, 700);
        showcar_frame.setVisible(true);
        showcar_frame.setResizable(false);
        showcar_frame.setLocationRelativeTo(null);
        showcar_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        back_button.addActionListener(new ShowCar());
        clear_button.addActionListener(new ShowCar());
        cancel_button.addActionListener(new ShowCar());
        ShowBookedCarsGui showBookedCarsGui = new ShowBookedCarsGui();

        displayingCars();
    }

    class ShowCar implements ActionListener {

        public void actionPerformed(ActionEvent e){

            if(e.getSource() == cancel_button){
                if(deleteCar(t_car_name.getText(), t_car_model.getText())){
                    JOptionPane.showMessageDialog(null, "Your order has beeen cancelled!!!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Such order does not exist!!!");
                }
                CustomerMenuGUI customerMenuGUI = new CustomerMenuGUI();
                customerMenuGUI.GUIInterface();
                showcar_frame.dispose();
            }
            if(e.getSource()==back_button){
                showcar_frame.dispose();
                CustomerMenuGUI customerMenuGUI=new CustomerMenuGUI();
                customerMenuGUI.GUIInterface();
            }

            if(e.getSource()==clear_button){
                t_car_name.setText("");
                t_car_model.setText("");

            }


        }
    }
    protected void displayingCars(){
        try{
            File file = new File("bookinginfo.txt");
            Scanner fes = new Scanner(file);
            while(fes.hasNextLine()){
                String now = fes.nextLine();
                str = now.split(" ");
                if(CustomerRecord.str[3].equalsIgnoreCase(str[1]) && CustomerRecord.str[1].equalsIgnoreCase(str[3])){
                    info_area.append(str[2] + " " + str[3] + " " + str[6] + " " +  str[7] + " " + str[8] + " " +
                            str[9] + " " + str[10] + " " + str[11] + " " + Integer.parseInt(str[12])*Integer.parseInt(str[10]) + "\n");

                }
            }
            fes.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
}