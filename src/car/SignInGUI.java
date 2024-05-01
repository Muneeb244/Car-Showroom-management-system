package car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInGUI extends CustomerRecord implements GUIImplementer{
    private JFrame signin_frame;
    private JPanel panel;

    private JLabel l_firstname;
    private JLabel signin;
    private JLabel l_lastname;
    private JLabel l_id;

    private JTextField t_firstname;
    private JTextField t_lastname;
    private JTextField t_id;

    private JButton submit_button;
    private JButton clear_button;
    private JButton back_button;



    public SignInGUI(){
        signin_frame = new JFrame("Sign In");
        panel = new JPanel(null);

        signin = new JLabel("Sign In");
        l_firstname = new JLabel("Enter first name:");
        l_lastname = new JLabel("Enter last name:");
        l_id = new JLabel("Enter login Cnic:");

        submit_button = new JButton("Sign In");
        clear_button = new JButton("Clear");
        back_button = new JButton("Back");

        t_firstname = new JTextField();
        t_lastname = new JTextField();
        t_id = new JTextField();

    }

    public void GUIInterface(){
        panel.setBackground(new Color(41, 48, 55));

        l_firstname.setForeground(Color.ORANGE);
        signin.setForeground(Color.ORANGE);
        l_lastname.setForeground(Color.ORANGE);
        l_id.setForeground(Color.ORANGE);

        signin.setFont(new Font("Serif", Font.ITALIC, 35));
        l_firstname.setFont(new Font("Aerial", Font.BOLD, 20));
        l_lastname.setFont(new Font("Aerial", Font.BOLD, 20));
        l_id.setFont(new Font("Aerial", Font.BOLD, 20));

        signin.setBounds(170, 10, 200, 50);
        l_firstname.setBounds(10, 64, 200, 50);
        l_lastname.setBounds(10, 107, 200, 50);
        l_id.setBounds(10, 151, 200, 50);
        t_firstname.setBounds(180, 77, 250, 30);
        t_lastname.setBounds(180, 120, 250, 30);
        t_id.setBounds(180, 163, 250, 30);
        submit_button.setBounds(25, 210, 100, 50);
        clear_button.setBounds(165, 210, 100, 50);
        back_button.setBounds(310, 210, 100, 50);

        submit_button.setBackground(Color.orange);
        submit_button.setForeground(new Color(34, 41, 48));
        clear_button.setBackground(Color.orange);
        clear_button.setForeground(new Color(34, 41, 48));
        back_button.setBackground(Color.orange);
        back_button.setForeground(new Color(34, 41, 48));

        submit_button.setFont(new Font("SansSerif", Font.BOLD, 20));
        clear_button.setFont(new Font("SansSerif", Font.BOLD, 20));
        back_button.setFont(new Font("SansSerif", Font.BOLD, 20));
        submit_button.addActionListener(new SigninHandler());
        clear_button.addActionListener(new SigninHandler());
        back_button.addActionListener(new SigninHandler());


        panel.add(signin);
        panel.add(l_firstname);
        panel.add(t_firstname);
        panel.add(l_lastname);
        panel.add(t_lastname);
        panel.add(l_id);
        panel.add(t_id);

        panel.add(submit_button);
        panel.add(clear_button);
        panel.add(back_button);

        signin_frame.add(panel);
        signin_frame.setSize(450, 310);
        signin_frame.setLocationRelativeTo(null);
        signin_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signin_frame.setResizable(false);
        signin_frame.setVisible(true);

    }

    class SigninHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                if(e.getSource() == submit_button){
                    String userf_name = nameValidation(t_firstname.getText());
                    String userl_name = nameValidation(t_lastname.getText());
                    if(signIN(userf_name, userl_name, Long.parseLong(t_id.getText()))){
                        JOptionPane.showMessageDialog(null, "Invalid Login details!!!");
                    }
                    else{
                        signin_frame.dispose();
                        CustomerMenuGUI customerMenuGUI = new CustomerMenuGUI();
                        customerMenuGUI.GUIInterface();
                    }
                }
                if(e.getSource() == clear_button){
                    t_firstname.setText("");
                    t_lastname.setText("");
                    t_id.setText("");
                }
                if(e.getSource() == back_button){
                    signin_frame.dispose();
                    User_MenuGui user_menu = new User_MenuGui();
                    user_menu.GUIInterface();
                }
            }
            catch (NumberFormatException v){
                JOptionPane.showMessageDialog(null, "Wrong input!!!\nEnter id in integer form");
            }
            catch (Exception z){
                System.out.println(z.toString());
            }
        }
    }
}
