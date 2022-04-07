import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorForm implements FocusListener {
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
    private JButton buttonMultiply;
    private JButton buttonDivide;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel answerLabel;
    private JButton a00Button;
    private JButton buttonPoint;
    private JButton buttonDelete;
    private JButton buttonC;
    private JTextField focusedTextBox;
    CalculatorForm(){
        label.setFont(new Font("Serif", Font.BOLD, 20));
        label.setForeground(Color.BLACK);
        textField1.requestFocus();
        focusedTextBox=textField1;
        textField1.addFocusListener(this);
        textField2.addFocusListener(this);
        textField3.addFocusListener(this);
        textField4.addFocusListener(this);
        a1Button.addActionListener(e -> selectionButtonPressed("1"));
        a2Button.addActionListener(e -> selectionButtonPressed("2"));
        a3Button.addActionListener(e -> selectionButtonPressed("3"));
        a4Button.addActionListener(e -> selectionButtonPressed("4"));
        a5Button.addActionListener(e -> selectionButtonPressed("5"));
        a6Button.addActionListener(e -> selectionButtonPressed("6"));
        a7Button.addActionListener(e -> selectionButtonPressed("7"));
        a8Button.addActionListener(e -> selectionButtonPressed("8"));
        a9Button.addActionListener(e -> selectionButtonPressed("9"));
        a0Button.addActionListener(e -> selectionButtonPressed("0"));
        a00Button.addActionListener(e -> selectionButtonPressed("00"));
        buttonPlus.addActionListener(e -> operationButtonPressed('+'));
        buttonMinus.addActionListener(e -> operationButtonPressed('-'));
        buttonMultiply.addActionListener(e -> operationButtonPressed('*'));
        buttonDivide.addActionListener(e -> operationButtonPressed('/'));
        buttonPoint.addActionListener(e -> selectionButtonPressed("."));
        buttonC.addActionListener(e -> CButtonPressed());
        buttonDelete.addActionListener(e -> DeleteButtonPressed());

    }

    public void DeleteButtonPressed() {
        if (focusedTextBox.getText().length()>0) {
            focusedTextBox.setText(focusedTextBox.getText().substring(0,focusedTextBox.getText().length()-1));
        }
    }
    public void CButtonPressed() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
    }
    public void selectionButtonPressed(String num) {
        focusedTextBox.setText(focusedTextBox.getText()+num);
    }
    public void operationButtonPressed(char sign)
    {
        if(EmptyTextBox(textField1,textField2,textField3,textField4))
        {
            try
            {
                Client client = new Client(Float.parseFloat(textField1.getText()),Float.parseFloat(textField3.getText()),Float.parseFloat(textField2.getText()),Float.parseFloat(textField4.getText()),sign);
                answerLabel.setText(client.Calculate());
            }
            catch (Exception e)
            {
                answerLabel.setText("Please, enter the right values!");
            }
        }
        else
        {
            answerLabel.setText("Please, fill all fields before choosing operation!");
        }
    }
    public static void main(String[] args) {
        JFrame frame=new JFrame("Calculator");
        frame.setContentPane(new CalculatorForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500,400));
        frame.setVisible(true);
    }

    @Override
    public void focusGained(FocusEvent e) {
        Object obj = e.getSource();
        if(obj instanceof JTextField)
        {
            focusedTextBox=(JTextField) obj;
        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    public boolean EmptyTextBox(JTextField f1, JTextField f2, JTextField f3, JTextField f4)
    {
        return !f1.getText().isEmpty() && !f2.getText().isEmpty() && !f3.getText().isEmpty() && !f4.getText().isEmpty();
    }
}
