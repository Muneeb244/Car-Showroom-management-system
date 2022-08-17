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

public class BookCarGUI extends Bookedcars implements GUIImplementer{
    SimpleDateFormat formatDate;
    Date now;
    String currentTime;

    private JFrame showcar_frame;

    private JPanel panel;

    private JLabel l_car_num;
    private JLabel qty;
    private JLabel book_car;

    private JTextField t_car_num;

    private JComboBox c_quantity;

    protected JTextArea info_area;

    private JButton back_button;
    private JButton book_button;
    private JButton clear_button;

    private String combo_selected = "1";
    protected static String[] price_str;


    public BookCarGUI() {
        formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        now = new Date();
        currentTime = formatDate.format(now);

        showcar_frame = new JFrame("Available cars");

        panel = new JPanel(null);

        clear_button = new JButton("Clear");
        book_car=new JLabel("Book Car");

        info_area = new JTextArea();
        l_car_num = new JLabel("Which car you wanna book?");

        qty=new JLabel("Quantity:");
        t_car_num = new JTextField();

        t_car_num  = new JTextField();

        String[] quatity_num = {"1", "2", "3"};
        c_quantity = new JComboBox(quatity_num);

        back_button = new JButton("Back");

        book_button = new JButton("Book");

    }
    public void GUIInterface(){

        info_area.setBounds(0, 80, 700, 420);
        info_area.setBackground(new Color(34, 41, 48));
        info_area.setForeground(Color.orange);
        info_area.setFont(new Font("SansSerif", Font.PLAIN, 18));



        book_car.setBounds(265,20,250,50);
        book_car.setForeground(Color.orange);
        book_car.setFont(new Font("Serif", Font.ITALIC, 35));





        l_car_num.setFont(new Font("SansSerif", Font.BOLD, 20));
        l_car_num.setBounds(95, 270, 500, 500);
        l_car_num.setForeground(Color.orange);

        qty.setFont(new Font("SansSerif", Font.BOLD, 20));
        qty.setBounds(455, 270, 500, 500);
        qty.setForeground(Color.orange);


        t_car_num.setBounds(375, 505, 50, 30);



        c_quantity.setBounds(555, 505, 50, 30);
        c_quantity.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){

                    combo_selected = (String)e.getItem();

                }
            }
        });



        back_button.setBounds(90, 580, 150, 50);
        back_button.setBackground(Color.orange);
        back_button.setForeground(new Color(34, 41, 48));
        back_button.setFont(new Font("SansSerif", Font.BOLD, 25));


        panel.setBackground(new Color(34, 41, 48));


        book_button.setBounds(280, 580, 150, 50);
        book_button.setBackground(Color.orange);
        book_button.setForeground(new Color(34, 41, 48));
        book_button.setFont(new Font("SansSerif", Font.BOLD, 25));


        clear_button.setBounds(470, 580, 150, 50);
        clear_button.setBackground(Color.orange);
        clear_button.setForeground(new Color(34, 41, 48));
        clear_button.setFont(new Font("SansSerif", Font.BOLD, 25));

        panel.add(info_area);
        panel.add(l_car_num);
        panel.add(t_car_num);
        panel.add(c_quantity);
        panel.add(qty);

        panel.add(back_button);
        panel.add(book_button);
        panel.add(clear_button);
        panel.add(book_car);

        showcar_frame.add(panel);
        showcar_frame.setSize(700, 700);
        showcar_frame.setVisible(true);
        showcar_frame.setResizable(false);
        showcar_frame.setLocationRelativeTo(null);
        showcar_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showCars();

        back_button.addActionListener(new ShowCar());
        clear_button.addActionListener(new ShowCar());
        book_button.addActionListener(new ShowCar());


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

    protected boolean price_getter(){
        boolean b = false;
        try{
            File f = new File("cars.txt");
            Scanner fes = new Scanner(f);
            while(fes.hasNextLine()){
                price_str = fes.nextLine().split(" ");
                if(price_str[0].replace(".", "").equals(t_car_num.getText())){
                    b = true;
                    break;
                }
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return b;
    }

    class ShowCar implements ActionListener {

        public void actionPerformed(ActionEvent e){
            if(e.getSource()==back_button){
                showcar_frame.dispose();
                CustomerMenuGUI customerMenuGUI=new CustomerMenuGUI();
                customerMenuGUI.GUIInterface();
            }

            if(e.getSource()==clear_button){
                t_car_num.setText("");

            }

            if(e.getSource() == book_button){
                if(booked(t_car_num.getText(), combo_selected) && price_getter()){
                    currentTime = CustomerRecord.nameValidation(currentTime);
                    String booking[] = CustomerRecord.str;

                    File file = new File("bookinginfo.txt");
                    try{
                        FileWriter fileWriter = new FileWriter(file, true);
                        BufferedWriter buff = new BufferedWriter(fileWriter);
                        String str = "Owner: " + booking[3] + " ID: " + booking[1] + " Phone_no.: " + booking[7] + " " +
                                getCar_info() + " Price: " + price_str[8] + " at: " + currentTime;

                        buff.newLine();
                        fileWriter.write(str);

                        buff.close();
                        fileWriter.close();

                    }
                    catch(Exception v){
                        System.out.println("getting here");
                        System.out.println(v.toString());
                    }
                    JOptionPane.showMessageDialog(null, "You car has been booked :)");
                    showcar_frame.dispose();
                    CustomerMenuGUI customerMenuGUI = new CustomerMenuGUI();
                    customerMenuGUI.GUIInterface();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Such car does not exist");
                }
            }

        }
    }
}
