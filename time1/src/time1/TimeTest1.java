/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package time1;


import javax.swing.JOptionPane;
public class TimeTest1 {
    public static void main(String[]args){
    Time1 time=new Time1();
    
    String output="Initial Universal time is: "
            +time.toUniversalString()+"\nInitial Standard time is; "
            + time.toStandardString();
    //change time and update
    time.setTime(17, 56, 6);
    
    output+=
            "\n\nUniversal time after Set time is: "+time.toUniversalString()+ 
            "\nStandard time after set time is: "+time.toStandardString();
    
    
    
    time.setTime(0, 00, 0);
      output+=
            "\n\nUniversal time after invalid Set time is: "+time.toUniversalString()+ 
            "\nStandard time after invalid set time is: "+time.toStandardString();
      
      JOptionPane.showMessageDialog(null, output,
              "Testing Class Time1",JOptionPane.INFORMATION_MESSAGE);
    System.exit(0);
}
}