package car;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerMenuGUI implements GUIImplementer{
    private JFrame Customer_menu_frame;
    private JPanel panel;

    private JLabel customer_menu;

    private JButton showCar_button;
    private JButton bookCar_button;
    private JButton cart;
    private JButton cancel_order_button;
    private JButton back_button;

    public CustomerMenuGUI() {
        showCar_button = new JButton();
        bookCar_button=new JButton();
        showCar_button=new JButton();
        cancel_order_button=new JButton();
        back_button=new JButton();

        showCar_button = new JButton("Show Available Cars ");
        bookCar_button = new JButton("Book Car");
        cart = new JButton("Show Cart");
        cancel_order_button = new JButton("Cancel Order");
        back_button = new JButton("Sign out");

        Customer_menu_frame = new JFrame("Customer Menu");
        panel = new JPanel(null);

        customer_menu = new JLabel("Customer Menu");

    }

    public void GUIInterface(){

        panel.setBackground(new Color(41, 48, 55));


        customer_menu.setBounds(150, 30, 300, 30);
        customer_menu.setForeground(Color.ORANGE);


//        customer_menu.setForeground(new Color(31, 31, 31));

        customer_menu.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 30));



        showCar_button.setBounds(125, 100, 250, 60);
        bookCar_button.setBounds(125, 190, 250, 60);
        cart.setBounds(125, 280, 250, 60);
        cancel_order_button.setBounds(125, 370, 250, 60);
        back_button.setBounds(175, 460, 150, 60);

        showCar_button.setBackground(new Color(34, 41, 48));
        showCar_button.setForeground(Color.orange);
        bookCar_button.setBackground(new Color(34, 41, 48));
        bookCar_button.setForeground(Color.orange);
        cart.setBackground(new Color(34, 41, 48));
        cart.setForeground(Color.orange);
        cancel_order_button.setBackground(new Color(34, 41, 48));
        cancel_order_button.setForeground(Color.orange);
        back_button.setBackground(Color.orange);
        back_button.setForeground(new Color(34, 41, 48));

        showCar_button.setFont(new Font("SansSerif", Font.BOLD, 20));
        bookCar_button.setFont(new Font("SansSerif", Font.BOLD, 20));
        cart.setFont(new Font("SansSerif", Font.BOLD, 20));
        cancel_order_button.setFont(new Font("SansSerif", Font.BOLD, 20));
        back_button.setFont(new Font("SansSerif", Font.BOLD, 20));

        showCar_button.addActionListener(new menuHandler());
        bookCar_button.addActionListener(new menuHandler());
        cart.addActionListener(new menuHandler());
        cancel_order_button.addActionListener(new menuHandler());
        back_button.addActionListener(new menuHandler());

        panel.add(customer_menu);
        panel.add(cart);
        panel.add(bookCar_button);
        panel.add(cancel_order_button);
        panel.add(showCar_button);
        panel.add(back_button);

        Customer_menu_frame.add(panel);
        Customer_menu_frame.setSize(500, 600);
        Customer_menu_frame.setVisible(true);
        Customer_menu_frame.setLocationRelativeTo(null);
        Customer_menu_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Customer_menu_frame.setResizable(false);
    }

    class menuHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == showCar_button){
                Customer_menu_frame.dispose();
                ShowCarGUI showCarGUI = new ShowCarGUI();
                showCarGUI.GUIInterface();
            }

            if(e.getSource() == bookCar_button){
                Customer_menu_frame.dispose();

                Bookedcars bookedcars = new BookCarGUI();
                if(bookedcars instanceof BookCarGUI){
                    ((BookCarGUI) bookedcars).GUIInterface();
                }
            }

            if(e.getSource() == cart){
                Customer_menu_frame.dispose();
                ShowCar showCar = new ShowCar();
                if(showCar.showingCars()){
                    ShowBookedCarsGui showBookedCarsGuiCarGUI = new ShowBookedCarsGui();
                    showBookedCarsGuiCarGUI.GUIInterface();
                }
                else{
                    JOptionPane.showMessageDialog(null, "No car booked to show");
                    CustomerMenuGUI customerMenuGUI = new CustomerMenuGUI();
                    customerMenuGUI.GUIInterface();
                }
            }

            if(e.getSource() == cancel_order_button){
                Customer_menu_frame.dispose();

                CancelOrder cancelOrder = new CancelOrder();
                if(cancelOrder.booked_car_checker()){
                    CancelOrderGui cancelOrderGui = new CancelOrderGui();
                    cancelOrderGui.GUIInterface();
                }
                else{
                    JOptionPane.showMessageDialog(null, "No car booked to cancel!!!");
                    CustomerMenuGUI customerMenuGUI = new CustomerMenuGUI();
                    customerMenuGUI.GUIInterface();
                }
            }
            if(e.getSource() == back_button){
                JOptionPane.showMessageDialog(null, "You are sign out successfully!!!");
                Customer_menu_frame.dispose();
                User_MenuGui user_menu = new User_MenuGui();
                user_menu.GUIInterface();
            }
        }
    }
}
