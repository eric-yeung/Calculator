// Java program to create a simple calculator 
// with addButtonsic +, -, /, * using java swing elements 
  
import java.awt.event.*; 
import javax.swing.*; 
import java.awt.*; 
class calculator extends JFrame implements ActionListener { 
    // create a frame 
    static JFrame f; 
  
    // create a textfield 
    static JTextField l; 
  
    // store oprerator and operands 
    String s0, s1, s2, memory; 
  
    // default constrcutor 
    calculator() 
    { 
        s0 = s1 = s2 = ""; 
    } 
  
    // main function 
    public static void main(String args[]) 
    { 
        // create a frame 
        f = new JFrame("calculator"); 
  
        try { 
            // set look and feel 
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
        } 
        catch (Exception e) { 
            System.err.println(e.getMessage()); 
        } 
  
        // create a object of class 
        calculator c = new calculator(); 
  
        // create a textfield 
        l = new JTextField(16); 
  
        // set the textfield to non editable 
        l.setEditable(false); 
  
        // create number buttons and some operators 
        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, 
        addButton, subtractButton, divideButton, multiplyButton, decimalButton, 
        clearButton, equalsButton,
        memoryStoreButton, memoryRecallButton, memoryClearButton; 
  
        // create number buttons 
        b0 = new JButton("0"); 
        b1 = new JButton("1"); 
        b2 = new JButton("2"); 
        b3 = new JButton("3"); 
        b4 = new JButton("4"); 
        b5 = new JButton("5"); 
        b6 = new JButton("6"); 
        b7 = new JButton("7"); 
        b8 = new JButton("8"); 
        b9 = new JButton("9"); 
  
        // equals button 
        equalsButton = new JButton("="); 
  
        // create operator buttons 
        addButton = new JButton("+"); 
        subtractButton = new JButton("-"); 
        divideButton = new JButton("/"); 
        multiplyButton = new JButton("*"); 
        clearButton = new JButton("C");
        memoryStoreButton = new JButton("M");
        memoryClearButton = new JButton("MC");
        memoryRecallButton = new JButton("MR"); 
  
        // create . button 
        decimalButton = new JButton("."); 
  
        // create a panel 
        JPanel p = new JPanel(); 
  
        // add action listeners 
        multiplyButton.addActionListener(c); 
        divideButton.addActionListener(c); 
        subtractButton.addActionListener(c); 
        addButton.addActionListener(c); 

        b9.addActionListener(c); 
        b8.addActionListener(c); 
        b7.addActionListener(c); 
        b6.addActionListener(c); 
        b5.addActionListener(c); 
        b4.addActionListener(c); 
        b3.addActionListener(c); 
        b2.addActionListener(c); 
        b1.addActionListener(c); 
        b0.addActionListener(c); 

        decimalButton.addActionListener(c); 
        clearButton.addActionListener(c); 
        equalsButton.addActionListener(c);
        memoryStoreButton.addActionListener(c);
        memoryClearButton.addActionListener(c);
        memoryRecallButton.addActionListener(c);
  
        // add elements to panel 
        p.add(l); 
        p.add(addButton); 
        p.add(b1); 
        p.add(b2); 
        p.add(b3); 
        p.add(subtractButton); 
        p.add(b4); 
        p.add(b5); 
        p.add(b6); 
        p.add(multiplyButton); 
        p.add(b7); 
        p.add(b8); 
        p.add(b9); 
        p.add(divideButton); 
        p.add(decimalButton); 
        p.add(b0); 
        p.add(clearButton); 
        p.add(equalsButton); 
        p.add(memoryStoreButton);
        p.add(memoryClearButton);
        p.add(memoryRecallButton);

        // set addButtonckground of panel 
        //  p.setaddButtonckground(Color.blue);
  
        // add panel to frame 
        f.add(p); 
  
        f.setSize(230, 220); 
        f.show(); 
    } 
    public void actionPerformed(ActionEvent e) 
    { 
        String s = e.getActionCommand(); 
  
        // if the value is a number 
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') 
        { 
            // if operand is present then add to second no 
            if (!s1.equals("")) 
                s2 = s2 + s; 
            else
                s0 = s0 + s; 
  
            // set the value of text 
            l.setText(s0 + s1 + s2); 
        }

        else if (s.charAt(0) == 'C') 
        { 
            // clear the one letter 
            s0 = s1 = s2 = ""; 
  
            // set the value of text 
            l.setText(s0 + s1 + s2); 
        } 
        
        else if(s.charAt(0) == 'M')
        {
            if(memory == "")
            {
                memory = s0;
            }
        }
        else if(s.equals("MR"))
        {
            s0 = memory;
            l.setText(s0 + s1 + s2);
        }
        
        else if (s.charAt(0) == '=') 
        { 
  
            double answer; 
  
            // store the value in 1st 
            if (s1.equals("+")) 
                answer = (Double.parseDouble(s0) + Double.parseDouble(s2)); 
            else if (s1.equals("-")) 
                answer = (Double.parseDouble(s0) - Double.parseDouble(s2)); 
            else if (s1.equals("/")) 
                answer = (Double.parseDouble(s0) / Double.parseDouble(s2)); 
            else
                answer = (Double.parseDouble(s0) * Double.parseDouble(s2)); 
  
            // set the value of text 
            l.setText(s0 + s1 + s2 + "=" + answer); 
  
            // convert it to string 
            s0 = Double.toString(answer); 
  
            s1 = s2 = ""; 
        } 
        else 
        { 
            // if there was no operand 
            if (s1.equals("") || s2.equals("")) 
                s1 = s; 
            // else evaluate 
            else 
            { 
                double answer; 
  
                // store the value in 1st 
                if (s1.equals("+")) 
                    answer = (Double.parseDouble(s0) + Double.parseDouble(s2)); 
                else if (s1.equals("-")) 
                    answer = (Double.parseDouble(s0) - Double.parseDouble(s2)); 
                else if (s1.equals("/")) 
                    answer = (Double.parseDouble(s0) / Double.parseDouble(s2)); 
                else
                    answer = (Double.parseDouble(s0) * Double.parseDouble(s2)); 
  
                // convert it to string 
                s0 = Double.toString(answer); 
  
                // place the operator 
                s1 = s; 
  
                // make the operand blank 
                s2 = ""; 
            } 
  
            // set the value of text 
            l.setText(s0 + s1 + s2); 
        } 
    } 
} 