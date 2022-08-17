package car;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_MenuGui implements GUIImplementer{
    private JFrame menu_frame;
    private JPanel panel;

    private JLabel name1;
    private JLabel name2;

    private JButton admin_button;
    private JButton user_button;
    private JButton exit_button;


    public Main_MenuGui() {
        menu_frame = new JFrame("Main Menu");
        panel = new JPanel(null);
        name1 = new JLabel("Welcome to");
        name2 = new JLabel("Car Showroom Management System");

        admin_button = new JButton("Admin");
        user_button = new JButton("Customer");
        exit_button = new JButton("Exit");



    }
    public void GUIInterface(){
        panel.setBackground(new Color(41, 48, 55));


        name1.setBounds(170, 15, 300, 30);
        name1.setForeground(Color.ORANGE);
        name1.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 30));
        name2.setBounds(25, 30, 450, 60);
        name2.setForeground(Color.ORANGE);
        name2.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 29));


        admin_button.setBounds(130, 100, 230, 60);
        user_button.setBounds(130, 190, 230, 60);
        exit_button.setBounds(185, 280, 120, 60);

        admin_button.setBackground(new Color(34, 41, 48));
        admin_button.setForeground(Color.orange);
        user_button.setBackground(new Color(34, 41, 48));
        user_button.setForeground(Color.orange);
        exit_button.setBackground(Color.orange);
        exit_button.setForeground(new Color(34, 41, 48));



        admin_button.setFont(new Font("SansSerif", Font.BOLD, 20));
        user_button.setFont(new Font("SansSerif", Font.BOLD, 20));
        exit_button.setFont(new Font("SansSerif", Font.BOLD, 20));

        admin_button.addActionListener(new menuHandler());
        user_button.addActionListener(new menuHandler());
        exit_button.addActionListener(new menuHandler());

        panel.add(name1);
        panel.add(name2);
        panel.add(admin_button);
        panel.add(user_button);
        panel.add(exit_button);



        menu_frame.add(panel);
        menu_frame.setSize(500, 400);
        menu_frame.setVisible(true);
        menu_frame.setLocationRelativeTo(null);
        menu_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu_frame.setResizable(false);
    }


    class menuHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == admin_button){
                menu_frame.dispose();

                Object adminLoginGui = new AdminLoginGui();
                if(adminLoginGui instanceof AdminLoginGui){
                    ((AdminLoginGui) adminLoginGui).GUIInterface();
                }

            }
            if(e.getSource() == user_button){
                menu_frame.dispose();
                User_MenuGui usermenu = new User_MenuGui();
                usermenu.GUIInterface();
            }
            if(e.getSource() == exit_button){
                System.exit(0);
            }
        }
    }
}
