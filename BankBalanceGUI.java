import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankBalanceGUI extends JFrame {
    private double balance = 0.0;

    private JTextField inputField;
    private JLabel balanceLabel;

    public BankBalanceGUI() {
        setTitle("Bank Balance Application");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        inputField = new JTextField();
        panel.add(new JLabel("Enter amount: "));
        panel.add(inputField);

        balanceLabel = new JLabel("Current balance: $0.00");
        panel.add(balanceLabel);

        JPanel buttonPanel = new JPanel();
        JButton showButton = new JButton("Show Balance");
        JButton deposiButton = new JButton("Deposit");
        JButton withdrawButton = new JButton ("Withdraw");
        JButton exitButton = new JButton ("Exit");

        buttonPanel.add(showButton);
        buttonPanel.add(deposiButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(exitButton);

        panel.add(buttonPanel);

        add(panel);

        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                balanceLabel.setText("Current balance: $" + String.format("%.2f", balance));

            }
         });

         deposiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(inputField.getText());
                    if (amount >= 0) {
                        balance += amount;
                        balanceLabel.setText("Deposit Successful! New balance: $" + String.format("%.2f", balance));
                    } else {
                        JOptionPane.showMessageDialog(null, "Enter a positive amount.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Number.");
                }
            }
        });
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(inputField.getText());
                    if (amount >= 0 && amount <= balance) {
                        balance -= amount;
                        balanceLabel.setText("Withdraw successfull! New balance: $" + String.format("%.2f", balance));
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid amount or insufficient funds.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid number.");
                }
            }
        });

     exitButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Final Balance: $" + String.format("%.2f", balance));
            System.exit(0);
        }
    });
}
public static void main(String[] args) {
    BankBalanceGUI gui = new BankBalanceGUI();
    gui.setVisible(true);
}
}

    


                
                   
                    
                
            
        
    

