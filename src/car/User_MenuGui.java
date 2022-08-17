package car;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User_MenuGui implements GUIImplementer{
    private JFrame user_menu_frame;
    private JPanel panel;

    private JLabel name1;
    private JLabel name2;

    private JButton singin_button;
    private JButton signup_button;
    private JButton back_button;


    public User_MenuGui() {
        user_menu_frame = new JFrame("Customer Menu");
        panel = new JPanel(null);

        name1 = new JLabel("Welcome to");

        singin_button = new JButton("Sign In");
        signup_button = new JButton("Sign Up");
        back_button = new JButton("Back");
        name2 = new JLabel("Car Showroom Management System");


    }

    public void GUIInterface(){
        panel.setBackground(new Color(41, 48, 55));


        name1.setBounds(170, 15, 300, 30);
        name1.setForeground(Color.ORANGE);
        name1.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 30));

        name2.setBounds(25, 30, 450, 60);
        name2.setForeground(Color.ORANGE);
        name2.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 29));

        singin_button.setBounds(130, 100, 230, 60);
        signup_button.setBounds(130, 190, 230, 60);
        back_button.setBounds(185, 280, 120, 60);

        singin_button.setBackground(new Color(34, 41, 48));
        singin_button.setForeground(Color.orange);
        signup_button.setBackground(new Color(34, 41, 48));
        signup_button.setForeground(Color.orange);
        back_button.setBackground(Color.orange);
        back_button.setForeground(new Color(34, 41, 48));

        singin_button.setFont(new Font("SansSerif", Font.BOLD, 20));
        signup_button.setFont(new Font("SansSerif", Font.BOLD, 20));
        back_button.setFont(new Font("SansSerif", Font.BOLD, 20));

        singin_button.addActionListener(new menuHandler());
        signup_button.addActionListener(new menuHandler());
        back_button.addActionListener(new menuHandler());

        panel.add(name1);
        panel.add(name2);
        panel.add(singin_button);
        panel.add(signup_button);
        panel.add(back_button);



        user_menu_frame.add(panel);
        user_menu_frame.setSize(500, 400);
        user_menu_frame.setVisible(true);
        user_menu_frame.setLocationRelativeTo(null);
        user_menu_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    class menuHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == singin_button){
                user_menu_frame.dispose();
                SignInGUI signin = new SignInGUI();
                signin.GUIInterface();
            }
            if(e.getSource() == signup_button){
                user_menu_frame.dispose();
                SignUpGUI signup = new SignUpGUI();
                signup.GUIInterface();
            }

            if(e.getSource() == back_button){
                user_menu_frame.dispose();
                Main_MenuGui main_menu = new Main_MenuGui();
                main_menu.GUIInterface();
            }
        }
    }
}
