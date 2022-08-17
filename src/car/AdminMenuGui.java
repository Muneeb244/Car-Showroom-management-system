package car;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenuGui implements GUIImplementer{
    private JFrame admin_menu_frame;
    private JPanel panel;

    private JLabel admin_menu;

    private JButton showCar_button;
    private JButton addCar_button;
    private JButton showCustomers;
    private JButton ShowBookedCars_button;
    private JButton deliverCar_button;
    private JButton Show_deliverCar_button;
    private JButton deleteCar_button;
    private JButton logout;

    public AdminMenuGui() {
        showCar_button = new JButton();
        addCar_button=new JButton();
        showCar_button=new JButton();
        ShowBookedCars_button=new JButton();
        deliverCar_button=new JButton();
        deleteCar_button=new JButton();
        logout=new JButton();

        showCar_button = new JButton("Show Cars ");
        addCar_button = new JButton("Add Car");
        showCustomers = new JButton("Show Customers");
        ShowBookedCars_button = new JButton("Show Booked Cars");
        deliverCar_button = new JButton("Deliver Car");
        Show_deliverCar_button= new JButton("Show Delivered Cars");
        deleteCar_button= new JButton("Delete Cars");
        logout= new JButton("Logout");

        admin_menu_frame = new JFrame("Admin Menu");
        panel = new JPanel(null);

        admin_menu = new JLabel("Admin Menu");

    }

    public void GUIInterface(){

        panel.setBackground(new Color(41, 48, 55));


        admin_menu.setBounds(150, 30, 300, 30);
        admin_menu.setForeground(Color.ORANGE);
        admin_menu.setFont(new Font("Serif", Font.ITALIC, 40));



        showCar_button.setBounds(125, 100, 250, 60);
        addCar_button.setBounds(125, 190, 250, 60);
        showCustomers.setBounds(125, 280, 250, 60);
        ShowBookedCars_button.setBounds(125, 370, 250, 60);
//        back_button.setBounds(175, 460, 150, 60);
        deliverCar_button.setBounds(125, 460, 250, 60);
        Show_deliverCar_button.setBounds(125, 540, 250, 60);
        deleteCar_button.setBounds(125, 630, 250, 60);
        logout.setBounds(165, 720, 170, 60);

        showCar_button.setBackground(new Color(34, 41, 48));
        showCar_button.setForeground(Color.orange);
        addCar_button.setBackground(new Color(34, 41, 48));
        addCar_button.setForeground(Color.orange);
        showCustomers.setBackground(new Color(34, 41, 48));
        showCustomers.setForeground(Color.orange);
        ShowBookedCars_button.setBackground(new Color(34, 41, 48));
        ShowBookedCars_button.setForeground(Color.orange);
        deleteCar_button.setBackground(new Color(34, 41, 48));
        deleteCar_button.setForeground(Color.orange);
        logout.setBackground(Color.orange);
        logout.setForeground(new Color(34, 41, 48));
        deliverCar_button.setBackground(new Color(34, 41, 48));
        deliverCar_button.setForeground(Color.orange);
        Show_deliverCar_button.setBackground(new Color(34, 41, 48));
        Show_deliverCar_button.setForeground(Color.orange);

        showCar_button.setFont(new Font("SansSerif", Font.BOLD, 20));
        addCar_button.setFont(new Font("SansSerif", Font.BOLD, 20));
        showCustomers.setFont(new Font("SansSerif", Font.BOLD, 20));
        ShowBookedCars_button.setFont(new Font("SansSerif", Font.BOLD, 20));
        deliverCar_button.setFont(new Font("SansSerif", Font.BOLD, 20));
        Show_deliverCar_button.setFont(new Font("SansSerif", Font.BOLD, 20));
        deleteCar_button.setFont(new Font("SansSerif", Font.BOLD, 20));
        logout.setFont(new Font("SansSerif", Font.BOLD, 20));

        showCar_button.addActionListener(new menuHandler());
        addCar_button.addActionListener(new menuHandler());
        showCustomers.addActionListener(new menuHandler());
        ShowBookedCars_button.addActionListener(new menuHandler());
        deliverCar_button.addActionListener(new menuHandler());
        Show_deliverCar_button.addActionListener(new menuHandler());
        deleteCar_button.addActionListener(new menuHandler());
        logout.addActionListener(new menuHandler());

        panel.add(admin_menu);
        panel.add(showCustomers);
        panel.add(addCar_button);
        panel.add(ShowBookedCars_button);
        panel.add(showCar_button);
        panel.add(deliverCar_button);
        panel.add(Show_deliverCar_button);
        panel.add(deleteCar_button);
        panel.add(logout);

        admin_menu_frame.add(panel);
        admin_menu_frame.setSize(500, 900);
        admin_menu_frame.setVisible(true);
        admin_menu_frame.setLocationRelativeTo(null);
        admin_menu_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        admin_menu_frame.setResizable(false);
    }

    class menuHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == showCar_button){
                admin_menu_frame.dispose();
                Admin_ShowCarGUI showCarGUI = new Admin_ShowCarGUI();
                showCarGUI.GUIInterface();
            }

            if(e.getSource() == addCar_button){
                admin_menu_frame.dispose();
                Admin_AddCarGui admin_addCarGui = new Admin_AddCarGui();
                admin_addCarGui.GUIInterface();
            }

            if(e.getSource() == showCustomers){
                admin_menu_frame.dispose();
                Admin_ShowCustomerGui admin_showCustomerGui = new Admin_ShowCustomerGui();
                admin_showCustomerGui.GUIInterface();
            }

            if(e.getSource() == deleteCar_button){
                admin_menu_frame.dispose();
                AdminDeleteCarGui adminDeleteCarGui = new AdminDeleteCarGui();
                adminDeleteCarGui.GUIInterface();
            }

            if(e.getSource() == ShowBookedCars_button){
                admin_menu_frame.dispose();
                AdminShowBookedCarsGui adminShowBookedCarsGui = new AdminShowBookedCarsGui();
                adminShowBookedCarsGui.GUIInterface();

            }

            if(e.getSource() == deliverCar_button){
                admin_menu_frame.dispose();
                AdminDeliverCarGui adminDeliverCarGui = new AdminDeliverCarGui();
                adminDeliverCarGui.GUIInterface();
            }

            if(e.getSource() == Show_deliverCar_button){
                admin_menu_frame.dispose();
                AdminShowDeliveredCarsGui adminShowDeliveredCarsGui = new AdminShowDeliveredCarsGui();
                adminShowDeliveredCarsGui.GUIInterface();
            }

            if(e.getSource() == logout){
                admin_menu_frame.dispose();
                Main_MenuGui main_menuGui =new Main_MenuGui();
                main_menuGui.GUIInterface();
            }

        }
    }
}

