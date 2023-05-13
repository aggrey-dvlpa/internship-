/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

import javax.swing.JFrame;
public class Snakegame  extends JFrame {
    Snakegame(){
        this.add(new gsnake());
        this.setVisible(true);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);   
        
    }
    public static void main(String[] args) {
      
        Snakegame snake= new Snakegame();
        snake.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
     
    }
}
