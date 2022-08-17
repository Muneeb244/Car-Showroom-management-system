package car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLoginGui extends AdminLogin implements GUIImplementer{
    private JFrame Login_frame;
    private JPanel panel;

    private JLabel l_name;
    private JLabel login;
    private JLabel l_password;

    protected JTextField t_name;
    protected JPasswordField t_password;

    private JButton submit_button;
    private JButton clear_button;
    private JButton back_button;



    public AdminLoginGui(){
        Login_frame = new JFrame("Login");
        panel = new JPanel(null);

        login = new JLabel("Login");
        l_name = new JLabel("Enter Username:");
        l_password = new JLabel("Enter Password:");

        submit_button = new JButton("Login");
        clear_button = new JButton("Clear");
        back_button = new JButton("Back");

        t_name = new JTextField();
        t_password = new JPasswordField();

    }

    public void GUIInterface(){
        panel.setBackground(new Color(41, 48, 55));

        l_name.setForeground(Color.ORANGE);
        login.setForeground(Color.ORANGE);
        l_password.setForeground(Color.ORANGE);

        login.setFont(new Font("Serif", Font.ITALIC, 35));
        l_name.setFont(new Font("Aerial", Font.BOLD, 20));
        l_password.setFont(new Font("Aerial", Font.BOLD, 20));

        login.setBounds(185, 20, 200, 50);
        l_name.setBounds(20, 85, 200, 50);
        l_password.setBounds(20, 132, 200, 50);
        t_name.setBounds(190, 100, 220, 30);
        t_password.setBounds(190, 145, 220, 30);
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

        submit_button.addActionListener(e->{


            try {
                if(admin_credentials(t_name.getText(), String.valueOf(t_password.getPassword()))){
                    Login_frame.dispose();
                    JOptionPane.showMessageDialog(null, "Login Successfull!!!");
                    AdminMenuGui adminMenuGui = new AdminMenuGui();
                    adminMenuGui.GUIInterface();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid login details!!!");
                    Login_frame.dispose();
                    Main_MenuGui main_menuGui = new Main_MenuGui();
                    main_menuGui.GUIInterface();
                }
            }
            catch (Exception n){
                System.out.println(n.toString());
            }
        });

        clear_button.addActionListener(e->{
            if(e.getSource() == clear_button){
                t_name.setText("");
                t_password.setText("");
            }
        });

        back_button.addActionListener(e->{
            if(e.getSource() == back_button){
                Login_frame.dispose();
                Main_MenuGui main_menuGui=new Main_MenuGui();
                main_menuGui.GUIInterface();
            }
        });



        panel.add(login);
        panel.add(l_name);
        panel.add(t_name);
        panel.add(l_password);
        panel.add(t_password);

        panel.add(submit_button);
        panel.add(clear_button);
        panel.add(back_button);

        Login_frame.add(panel);
        Login_frame.setSize(450, 310);
        Login_frame.setLocationRelativeTo(null);
        Login_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Login_frame.setResizable(false);
        Login_frame.setVisible(true);

    }

}
