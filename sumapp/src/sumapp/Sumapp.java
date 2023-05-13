               
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumapp;

import java.awt.*;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Sumapp extends JFrame implements ActionListener{
    JLabel label1,label2,label3;
    JTextField field1,field2;
    JTextArea output;
    JButton button1,b2;
    String str1,str2,str3;
   
          int sum, num1,num2;
    
    
    Sumapp(){
        this.setLayout(new FlowLayout());
        this.setLayout(null);
        this.setTitle("Sum app:");
        this.getContentPane().setBackground(new Color(0xfff345f));
        
        //labels.
        
        label1=new JLabel("Number1");
        label2=new JLabel("Number2");
        label3=new JLabel("The Output sum is:");
        
        
        //fields
        
        field1=new JTextField();
        field2=new JTextField();
       output=new JTextArea();
        
        
        //buttons
        
        button1=new JButton("Add");
        b2=new JButton("Multiply");
        //add to component frame
        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(field1);
        this.add(field2);
        this.add(output);
        this.add(button1);
        this.add(b2);
        //bounds.
        label1.setBounds(20, 20, 90, 70);
        label2.setBounds(20, 60, 90, 70);
        label3.setBounds(20, 200, 120, 70);
        
        field1.setBounds(80 , 40, 70, 20);
        field2.setBounds(80 , 80, 70, 20);
        output.setBounds(130,225,70,20);
        
        //button.
        button1.setBounds(40, 140, 60, 20);
        b2.setBounds(120,140,90,20);
        
        this.setSize(420, 420);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        field1.addActionListener(this);
            button1.addActionListener(this);
            b2.addActionListener(this);
    }
  

  
    

    
    public static void main(String[] args) {
        new Sumapp();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==button1){
            str1=field1.getText();
            str2=field2.getText();
            
            
           num1=Integer.parseInt(str1);
           num2=Integer.parseInt(str2);
           
           
           sum=num1+num2;
           str3=String.valueOf(sum);
            output.setText(str3);
        }
         if(e.getSource()==b2){
            str1=field1.getText();
            str2=field2.getText();
            
            
           num1=Integer.parseInt(str1);
           num2=Integer.parseInt(str2);
           
           
           sum=num1*num2;
           str3=String.valueOf(sum);
            output.setText(str3);
        }
    }
    
}
