package car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpGUI extends CustomerRecord implements GUIImplementer{

    // TEXT FIELDS
    private JTextField t_firstname;
    private JTextField t_lastname;
    private JTextField t_phone_number;
//    private JTextField t_gender;
    private JTextField t_address;
    private JTextField t_CNIC;

    // Labels
    private JLabel l_firstname;
    private JLabel signup;
    private JLabel l_lastname;
    private JLabel l_phone_number;
    private JLabel l_gender;
    private JLabel l_address;
    private JLabel l_CNIC;

    // Checkbox
    private JRadioButton male_radio;
    private JRadioButton female_radio;


    // BUTTON
    private JButton submit_button;
    private JButton clear_button;
    private JButton back_button;

    private ButtonGroup group;

    // Panels
    private JPanel panel;
    private JFrame signup_frame;

    public SignUpGUI(){
        signup_frame = new JFrame("Sign Up");
        panel = new JPanel(null);

        l_firstname = new JLabel("Enter First Name:");
        signup = new JLabel("Sign Up");
        l_lastname = new JLabel("Enter Last Name:");
        l_phone_number = new JLabel("Enter Phone No :");
        l_gender = new JLabel("Enter Gender:");
        l_address = new JLabel("Enter Address:");
        l_CNIC = new JLabel("Enter CNIC:");

        t_firstname = new JTextField();
        t_lastname = new JTextField();
        t_phone_number = new JTextField();
        t_address = new JTextField();
        t_CNIC = new JTextField();

        male_radio  = new JRadioButton("Male");
        female_radio  = new JRadioButton("Female");

        submit_button = new JButton("Sign Up");
        clear_button = new JButton("Clear");
        back_button = new JButton("Back");
        signup_frame.setTitle("Sign Up");

        group = new ButtonGroup();


    }

    public void GUIInterface(){
        panel.setBackground(new Color(41, 48, 55));

        panel.setBackground(new Color(34, 41, 48));

        l_firstname.setFont(new Font("Aerial", Font.BOLD, 20));
        signup.setFont(new Font("Serif", Font.ITALIC, 35));
        l_lastname.setFont(new Font("Aerial", Font.BOLD, 20));
        l_phone_number.setFont(new Font("Aerial", Font.BOLD, 20));
        l_gender.setFont(new Font("Aerial", Font.BOLD, 20));
        l_address.setFont(new Font("Aerial", Font.BOLD, 20));
        l_CNIC.setFont(new Font("Aerial", Font.BOLD, 20));

        signup.setBounds(190, 10, 200, 50);
        l_firstname.setBounds(20, 65, 200, 50);
        l_lastname.setBounds(20, 107, 200, 50);
        l_phone_number.setBounds(20, 151, 200, 50);
        l_CNIC.setBounds(20, 194, 200, 50);
        l_address.setBounds(20, 237, 200, 50);
        l_gender.setBounds(20, 282, 200, 50);

        t_firstname.setBounds(200, 77, 263, 30);
        t_lastname.setBounds(200, 120, 263, 30);
        t_phone_number.setBounds(200, 163, 263, 30);
//        t_gender.setBounds(200, 207, 263, 30);
        t_address.setBounds(200, 250, 263, 30);
        t_CNIC.setBounds(200, 207, 263, 30);

        male_radio.setBounds(200, 293, 80, 30);
        female_radio.setBounds(320, 293, 100, 30);
        male_radio.setBackground(new Color(34, 41, 48));
        female_radio.setBackground(new Color(34, 41, 48));
        male_radio.setForeground(Color.orange);
        female_radio.setForeground(Color.orange);
        male_radio.setFont(new Font("Aerial", Font.PLAIN, 20));
        female_radio.setFont(new Font("Aerial", Font.PLAIN, 20));

        l_firstname.setForeground(Color.orange);
        signup.setForeground(Color.orange);
        l_lastname.setForeground(Color.orange);
        l_phone_number.setForeground(Color.orange);
        l_gender.setForeground(Color.orange);
        l_address.setForeground(Color.orange);
        l_CNIC.setForeground(Color.orange);


        group.add(male_radio);
        group.add(female_radio);

        panel.add(signup);

        panel.add(l_firstname);
        panel.add(l_lastname);
        panel.add(t_firstname);
        panel.add(t_lastname);


        panel.add(l_phone_number);
        panel.add(l_gender);
        panel.add(t_phone_number);
        panel.add(male_radio);
        panel.add(female_radio);

        panel.add(l_address);
        panel.add(l_CNIC);
        panel.add(t_address);
        panel.add(t_CNIC);

        // Adding Action listners
        submit_button.addActionListener(new CarHandler());
        clear_button.addActionListener(new CarHandler());
        back_button.addActionListener(new CarHandler());


        submit_button.setBackground(Color.orange);
        submit_button.setForeground(new Color(34, 41, 48));
        clear_button.setBackground(Color.orange);
        clear_button.setForeground(new Color(34, 41, 48));
        back_button.setBackground(Color.orange);
        back_button.setForeground(new Color(34, 41, 48));

        submit_button.setFont(new Font("SansSerif", Font.BOLD, 20));
        clear_button.setFont(new Font("SansSerif", Font.BOLD, 20));
        back_button.setFont(new Font("SansSerif", Font.BOLD, 20));
        submit_button.setBounds(35, 350, 120, 50);
        clear_button.setBounds(185, 350, 120, 50);
        back_button.setBounds(335, 350, 120, 50);

        panel.add(submit_button);
        panel.add(clear_button);
        panel.add(back_button);


        signup_frame.add(panel);
        signup_frame.setVisible(true);
        signup_frame.setLocationRelativeTo(null);
        signup_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signup_frame.setSize(500, 450);
        signup_frame.setResizable(false);
    }

    class CarHandler extends Component implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == submit_button){

                f_name = nameValidation(t_firstname.getText());
                l_name = nameValidation(t_lastname.getText());

                phone_no = nameValidation(t_phone_number.getText());
                address = nameValidation(t_address.getText());
                CNIC = nameValidation(t_CNIC.getText());

                if(male_radio.isSelected()){
                    gender = "male";
                }
                else{
                    gender = "female";
                }

                if(t_firstname.getText().equals("") || t_lastname.getText().equals("") || t_phone_number.getText().equals("")
                        || t_address.getText().equals("") || t_CNIC.getText().equals("") || gender == null){
                    JOptionPane.showMessageDialog(null, "Enter valid details!!!");
                    signup_frame.dispose();
                    SignUpGUI signUpGUI = new SignUpGUI();
                    signUpGUI.GUIInterface();

                }
                else{
                    signUp();
                    JOptionPane.showMessageDialog(null, "Customer details added\nYour generated id is: " + id);
                    signup_frame.dispose();
                    User_MenuGui user_menu = new User_MenuGui();
                    user_menu.GUIInterface();
                }
            }
            if(e.getSource() == clear_button){
                t_firstname.setText("");
                t_lastname.setText("");
                t_address.setText("");
                t_CNIC.setText("");
                t_phone_number.setText("");
            }
            if(e.getSource() == back_button){
                signup_frame.dispose();
                User_MenuGui user_menu = new User_MenuGui();
                user_menu.GUIInterface();
            }
        }
    }

}