package car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_AddCarGui implements GUIImplementer{

    // TEXT FIELDS
    protected JTextField t_carname;
    protected JTextField t_company;
    protected JTextField t_model;
    protected JTextField t_price;
    protected JTextField t_engine;

    // Labels
    private JLabel l_carname;
    private JLabel addcar;
    private JLabel l_company;
    private JLabel l_price;
    private JLabel l_model;
    private JLabel l_Engine;

    // BUTTON
    private JButton submit_button;
    private JButton clear_button;
    private JButton back_button;

    // Panels
    private JPanel panel;
    private JFrame Addcar_frame;

    public Admin_AddCarGui(){
        Addcar_frame = new JFrame("Add Car");
        panel = new JPanel(null);

        l_carname = new JLabel("Enter Car Name:");
        addcar = new JLabel("Add Car");
        l_company = new JLabel("Enter Company:");
        l_model = new JLabel("Enter Model:");
        l_price = new JLabel("Enter Price:");
        l_Engine = new JLabel("Enter Engine:");

        t_carname = new JTextField();
        t_company = new JTextField();
        t_model = new JTextField();
        t_price = new JTextField();
        t_engine = new JTextField();

        submit_button = new JButton("Add Car");
        clear_button = new JButton("Clear");
        back_button = new JButton("Back");
        Addcar_frame.setTitle("Add Car");


    }

    public void GUIInterface(){
        panel.setBackground(new Color(41, 48, 55));

        panel.setBackground(new Color(34, 41, 48));

        l_carname.setFont(new Font("Aerial", Font.BOLD, 20));
        addcar.setFont(new Font("Serif", Font.ITALIC, 35));
        l_company.setFont(new Font("Aerial", Font.BOLD, 20));
        l_model.setFont(new Font("Aerial", Font.BOLD, 20));
        l_price.setFont(new Font("Aerial", Font.BOLD, 20));
        l_Engine.setFont(new Font("Aerial", Font.BOLD, 20));

        addcar.setBounds(190, 10, 200, 50);
        l_carname.setBounds(20, 65, 200, 50);
        l_company.setBounds(20, 107, 200, 50);
        l_model.setBounds(20, 151, 200, 50);
        l_price.setBounds(20, 237, 200, 50);
        l_Engine.setBounds(20, 194, 200, 50);



        t_carname.setBounds(200, 77, 263, 30);
        t_company.setBounds(200, 120, 263, 30);
        t_model.setBounds(200, 163, 263, 30);
        t_price.setBounds(200, 250, 263, 30);
        t_engine.setBounds(200, 207, 263, 30);


        l_carname.setForeground(Color.orange);
        addcar.setForeground(Color.orange);
        l_company.setForeground(Color.orange);
        l_model.setForeground(Color.orange);
        l_price.setForeground(Color.orange);
        l_Engine.setForeground(Color.orange);


        panel.add(addcar);

        panel.add(l_carname);
        panel.add(l_company);
        panel.add(l_Engine);
        panel.add(l_model);
        panel.add(l_price);

        panel.add(t_carname);
        panel.add(t_company);
        panel.add(t_engine);
        panel.add(t_model);
        panel.add(t_price);

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
        submit_button.setBounds(35, 310, 120, 50);
        clear_button.setBounds(185, 310, 120, 50);
        back_button.setBounds(335, 310, 120, 50);

        panel.add(submit_button);
        panel.add(clear_button);
        panel.add(back_button);


        Addcar_frame.add(panel);
        Addcar_frame.setVisible(true);
        Addcar_frame.setLocationRelativeTo(null);
        Addcar_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Addcar_frame.setSize(500, 420);
        Addcar_frame.setResizable(false);
    }

    class CarHandler extends Component implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == clear_button){
                t_carname.setText("");
                t_company.setText("");
                t_engine.setText("");
                t_model.setText("");
                t_price.setText("");
            }
            if(e.getSource() == back_button){
                Addcar_frame.dispose();
                AdminMenuGui adminMenuGui =new AdminMenuGui();
                adminMenuGui.GUIInterface();
            }

            if(e.getSource() == submit_button){
                Admin_AddCar admin_addCar = new Admin_AddCar();
                if(admin_addCar.carAdd(t_carname.getText(), t_company.getText(), t_model.getText(), t_price.getText(), t_engine.getText())
                && !(t_carname.getText().equals("") || t_company.getText().equals("") || t_engine.getText().equals("")
                        || t_model.getText().equals("") || t_price.getText().equals(""))){
                    Addcar_frame.dispose();
                    JOptionPane.showMessageDialog(null, "Car added successully!!!");
                    AdminMenuGui adminMenuGui = new AdminMenuGui();
                    adminMenuGui.GUIInterface();
                }
                else {
                    Addcar_frame.dispose();
                    JOptionPane.showMessageDialog(null, "Enter valid details!!!");
                    AdminMenuGui adminMenuGui = new AdminMenuGui();
                    adminMenuGui.GUIInterface();
                }
            }
        }
    }

}