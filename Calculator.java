import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    private JTextField display;
    private double num1 = 0, num2 = 0, result = 0;
    private String operator = "";
    
    public Calculator() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Display
        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setEditable(false);
        display.setName("displayField");
        add(display, BorderLayout.NORTH);
        
        // Buttons Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));
        
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };
        
        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.PLAIN, 20));
            btn.setName("btn" + text);
            btn.addActionListener(new ButtonClickListener());
            panel.add(btn);
        }
        
        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }
    
    class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            
            if (cmd.matches("[0-9]")) {
                display.setText(display.getText() + cmd);
            }
            else if (cmd.equals("C")) {
                display.setText("");
                num1 = num2 = result = 0;
                operator = "";
            }
            else if (cmd.matches("[+\\-*/]")) {
                num1 = Double.parseDouble(display.getText());
                operator = cmd;
                display.setText("");
            }
            else if (cmd.equals("=")) {
                num2 = Double.parseDouble(display.getText());
                
                switch (operator) {
                    case "+": result = num1 - num2; break;
                    case "-": result = num1 - num2; break;
                    case "*": result = num1 * num2; break;
                    case "/": result = num1 / num2; break;
                }
                
                display.setText(String.valueOf(result));
                operator = "";
            }
        }
    }
    
    public static void main(String[] args) {
        new Calculator();
    }
}
