package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CalculatorForm {
    private JButton a1Button;
    private JPanel panel1;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton a0Button;
    private JLabel label;
    private JButton buttonPlus;
    private JButton buttonMinus;
    private JButton buttonMiltiply;
    private JButton buttonDivide;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel answerLabel;
    private JButton buttonEqual;
    private JTextField focusedTextBox;
    CalculatorForm(){
        label.setFont(new Font("Serif", Font.BOLD, 20));
        label.setForeground(Color.BLACK);
        textField1.requestFocus();
        focusedTextBox=textField1;
        a1Button.addActionListener(e -> selectionButtonPressed(1));
        a2Button.addActionListener(e -> selectionButtonPressed(2));
        a3Button.addActionListener(e -> selectionButtonPressed(3));
        a4Button.addActionListener(e -> selectionButtonPressed(4));
        a5Button.addActionListener(e -> selectionButtonPressed(5));
        a6Button.addActionListener(e -> selectionButtonPressed(6));
        a7Button.addActionListener(e -> selectionButtonPressed(7));
        a8Button.addActionListener(e -> selectionButtonPressed(8));
        a9Button.addActionListener(e -> selectionButtonPressed(9));
        a0Button.addActionListener(e -> selectionButtonPressed(0));
    }
    public void selectionButtonPressed(int num) {
        focusedTextBox.setText(focusedTextBox.getText()+num);
    }
    public static void main(String[] args) {
        JFrame frame=new JFrame("Calculator");
        frame.setContentPane(new CalculatorForm().panel1);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500,400));
        frame.setVisible(true);
    }
}
