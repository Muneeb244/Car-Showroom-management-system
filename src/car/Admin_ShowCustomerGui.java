package car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class Admin_ShowCustomerGui implements GUIImplementer{
    protected JFrame showcustomer_frame;

    private JLabel show_customers;

    private JPanel panel;
    protected JTextArea info_area;
    private JButton back_button;

    public Admin_ShowCustomerGui() {
        showcustomer_frame = new JFrame("Customers");
        panel = new JPanel(null);

        show_customers = new JLabel("Customers");
        info_area = new JTextArea();

        back_button = new JButton("Back");

    }

    public void GUIInterface() {
        show_customers.setBounds(450, 20, 250, 50);
        show_customers.setForeground(Color.orange);
        show_customers.setFont(new Font("Serif", Font.ITALIC, 35));


        info_area.setBounds(0, 80, 1100, 400);
        info_area.setBackground(new Color(34, 41, 48));
        info_area.setForeground(Color.orange);
        info_area.setFont(new Font("SansSerif", Font.PLAIN, 16));

        panel.setBackground(new Color(34, 41, 48));


        back_button.setBounds(475, 490, 150, 50);
        back_button.setBackground(Color.orange);
        back_button.setForeground(new Color(34, 41, 48));
        back_button.setFont(new Font("SansSerif", Font.BOLD, 25));

        panel.add(info_area);
        panel.add(back_button);
        panel.add(show_customers);

        showcustomer_frame.add(panel);
        showcustomer_frame.setSize(1100, 600);
        showcustomer_frame.setVisible(true);
        showcustomer_frame.setResizable(false);
        showcustomer_frame.setLocationRelativeTo(null);
        showcustomer_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showCustomers();

        back_button.addActionListener(new ShowCar());
    }

    private void showCustomers() {
        File file = new File("customer.txt");
        try {
            Scanner fes = new Scanner(file);
            while (fes.hasNextLine()) {
                info_area.append(fes.nextLine() + "\n");
            }
            fes.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    class ShowCar implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == back_button) {
                showcustomer_frame.dispose();
                AdminMenuGui adminMenuGui = new AdminMenuGui();
                adminMenuGui.GUIInterface();
            }
        }
    }

}