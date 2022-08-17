package car;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AdminDeleteCarGui implements GUIImplementer{

    private JFrame showcar_frame;

    private JPanel panel;

    private JLabel l_car_num;
    private JLabel delete_car;

    protected JTextField t_car_num;

    private JComboBox c_quantity;

    protected JTextArea info_area;

    private JButton back_button;
    private JButton delete_button;
    private JButton clear_button;


    public AdminDeleteCarGui() {

        showcar_frame = new JFrame("Available cars");

        panel = new JPanel(null);

        clear_button = new JButton("Clear");
        delete_car=new JLabel("Delete Car");

        info_area = new JTextArea();
        l_car_num = new JLabel("Which car you wanna Delete?");

        t_car_num = new JTextField();

        t_car_num  = new JTextField();

        String[] quatity_num = {"1", "2", "3"};
        c_quantity = new JComboBox(quatity_num);

        back_button = new JButton("Back");

        delete_button = new JButton("Delete");

    }

    public void GUIInterface(){

        info_area.setBounds(0, 80, 700, 420);
        info_area.setBackground(new Color(34, 41, 48));
        info_area.setForeground(Color.orange);
        info_area.setFont(new Font("SansSerif", Font.PLAIN, 18));



        delete_car.setBounds(265,20,250,50);
        delete_car.setForeground(Color.orange);
        delete_car.setFont(new Font("Serif", Font.ITALIC, 35));





        l_car_num.setFont(new Font("SansSerif", Font.BOLD, 20));
        l_car_num.setBounds(180, 270, 500, 500);
        l_car_num.setForeground(Color.orange);



        t_car_num.setBounds(470, 505, 50, 30);




        back_button.setBounds(90, 580, 150, 50);
        back_button.setBackground(Color.orange);
        back_button.setForeground(new Color(34, 41, 48));
        back_button.setFont(new Font("SansSerif", Font.BOLD, 25));


        panel.setBackground(new Color(34, 41, 48));


        delete_button.setBounds(280, 580, 150, 50);
        delete_button.setBackground(Color.orange);
        delete_button.setForeground(new Color(34, 41, 48));
        delete_button.setFont(new Font("SansSerif", Font.BOLD, 25));


        clear_button.setBounds(470, 580, 150, 50);
        clear_button.setBackground(Color.orange);
        clear_button.setForeground(new Color(34, 41, 48));
        clear_button.setFont(new Font("SansSerif", Font.BOLD, 25));

        panel.add(info_area);
        panel.add(l_car_num);
        panel.add(t_car_num);
        panel.add(c_quantity);

        panel.add(back_button);
        panel.add(delete_button);
        panel.add(clear_button);
        panel.add(delete_car);

        showcar_frame.add(panel);
        showcar_frame.setSize(700, 700);
        showcar_frame.setVisible(true);
        showcar_frame.setResizable(false);
        showcar_frame.setLocationRelativeTo(null);
        showcar_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showCars();

        back_button.addActionListener(new ShowCar());
        clear_button.addActionListener(new ShowCar());
        delete_button.addActionListener(new ShowCar());


    }
    private void showCars(){
        File file = new File("cars.txt");
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
                AdminMenuGui customerMenuGUI=new AdminMenuGui();
                customerMenuGUI.GUIInterface();
            }

            if(e.getSource()==clear_button){
                t_car_num.setText("");

            }


            if(e.getSource() == delete_button){
                showcar_frame.dispose();
                AdminDeleteCarGui admin_carDeletion = new Admin_CarDeletion();
                if(((Admin_CarDeletion) admin_carDeletion).deleteCar(t_car_num.getText())){
                    JOptionPane.showMessageDialog(null, "Car deleted successfully!!!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid input!!!");
                }
                AdminMenuGui adminMenuGui = new AdminMenuGui();
                adminMenuGui.GUIInterface();
            }

        }
    }
}
