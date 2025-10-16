import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    JTextField text;
    JButton[] numbers = new JButton[10];
    JButton add, sub, mul, div, eq, clr;
    double num1, num2, result;
    char operator;

    public Calculator() {
        setTitle("Calculator");
        setSize(300, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        text = new JTextField();
        add(text, "North");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,4,5,5));

        for(int i=0;i<10;i++) {
            numbers[i] = new JButton(""+i);
            numbers[i].addActionListener(this);
        }

        add = new JButton("+"); sub = new JButton("-"); 
        mul = new JButton("*"); div = new JButton("/"); 
        eq = new JButton("="); clr = new JButton("C");

        JButton[] ops = {add, sub, mul, div, eq, clr};
        for(JButton b: ops) b.addActionListener(this);

        panel.add(numbers[7]); panel.add(numbers[8]); panel.add(numbers[9]); panel.add(add);
        panel.add(numbers[4]); panel.add(numbers[5]); panel.add(numbers[6]); panel.add(sub);
        panel.add(numbers[1]); panel.add(numbers[2]); panel.add(numbers[3]); panel.add(mul);
        panel.add(numbers[0]); panel.add(clr); panel.add(eq); panel.add(div);

        add(panel, "Center");
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++) {
            if(e.getSource()==numbers[i]) {
                text.setText(text.getText()+i);
                return;
            }
        }
        if(e.getSource()==add) { num1=Double.parseDouble(text.getText()); operator='+'; text.setText(""); }
        if(e.getSource()==sub) { num1=Double.parseDouble(text.getText()); operator='-'; text.setText(""); }
        if(e.getSource()==mul) { num1=Double.parseDouble(text.getText()); operator='*'; text.setText(""); }
        if(e.getSource()==div) { num1=Double.parseDouble(text.getText()); operator='/'; text.setText(""); }
        if(e.getSource()==eq) { 
            num2=Double.parseDouble(text.getText());
            switch(operator) {
                case '+': result=num1+num2; break;
                case '-': result=num1-num2; break;
                case '*': result=num1*num2; break;
                case '/': result=num1/num2; break;
            }
            text.setText(""+result);
        }
        if(e.getSource()==clr) text.setText("");
    }

    public static void main(String[] args) { new Calculator(); }
}
