package car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class ShowCarGUI extends CarShower implements GUIImplementer{
    protected JFrame showcar_frame;

    private JLabel show_cars;

    private JPanel panel;

    protected JTextArea info_area;
    private JButton back_button;

    public ShowCarGUI() {
        showcar_frame = new JFrame("Available cars");

        panel = new JPanel(null);

        show_cars=new JLabel("Available Cars");
        info_area = new JTextArea();

        back_button = new JButton("Back");



    }

    public void GUIInterface(){
        show_cars.setBounds(250,20,250,50);
        show_cars.setForeground(Color.orange);
        show_cars.setFont(new Font("Serif", Font.ITALIC, 35));


        info_area.setBounds(0, 80, 700, 400);
        info_area.setBackground(new Color(34, 41, 48));
        info_area.setForeground(Color.orange);
        info_area.setFont(new Font("SansSerif", Font.PLAIN, 18));

        panel.setBackground(new Color(34, 41, 48));


        back_button.setBounds(275, 490, 150, 50);
        back_button.setBackground(Color.orange);
        back_button.setForeground(new Color(34, 41, 48));
        back_button.setFont(new Font("SansSerif", Font.BOLD, 25));

        panel.add(info_area);
        panel.add(back_button);
        panel.add(show_cars);

        showcar_frame.add(panel);
        showcar_frame.setSize(700, 600);
        showcar_frame.setVisible(true);
        showcar_frame.setResizable(false);
        showcar_frame.setLocationRelativeTo(null);
        showcar_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showCars();

        back_button.addActionListener(new ShowCarHandler());
    }

    protected void showCars(){
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

    class ShowCarHandler implements ActionListener{

        public void actionPerformed(ActionEvent e){
            if(e.getSource()==back_button){
                showcar_frame.dispose();
                CustomerMenuGUI customerMenuGUI=new CustomerMenuGUI();
                customerMenuGUI.GUIInterface();
            }
        }
    }
}