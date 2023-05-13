/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

class gsnake extends JPanel implements ActionListener
{
    
    final static int SCREEN_HEIGHT = 700;
    final static int SCREEN_WIDTH = 700;
    final static int UNITS = 25;
    final static int GAME_SIZE=((SCREEN_HEIGHT*SCREEN_WIDTH)/UNITS);
    int x[]=new int[GAME_SIZE];
    int y[]=new int[GAME_SIZE];
    int appleX;
    int appleY,applesEaten;
    int bodyparts=6;
    int GAME_DELAY=50;
    char direction= 'R';
    boolean isRunning=false;
    Random random;
    Timer timer;
    
   gsnake()
   {
       random=new Random();
       this.setPreferredSize(new Dimension(SCREEN_HEIGHT,SCREEN_WIDTH) );
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();       
   }
   
   public void paintComponent(Graphics g)
   {   super.paintComponent(g);
       draw(g);
   } 
   
   public void startGame()
   {
       newApple();
       isRunning=true;
       timer=new Timer(GAME_DELAY,this);
       timer.start();  
       
   }
   
   public void draw(Graphics g)
   {
       if(isRunning){
         /*  for(int i=0;i<SCREEN_HEIGHT/UNITS;i++)
          {
           g.drawLine(i*UNITS, 0, i*UNITS, SCREEN_HEIGHT);
           g.drawLine(0,  i*UNITS, SCREEN_WIDTH,  i*UNITS);
          }
       */
         g.setColor(Color.orange);
         g.fillOval(appleX,appleY,UNITS, UNITS);
       
          for(int i=0;i<bodyparts;i++)
         {
           if(i==0)
           {
               g.setColor(Color.red);
               g.fillRect(x[i], y[i], UNITS, UNITS);
           }
           else
           {
               g.setColor(Color.green);
               g.fillRect(x[i], y[i], UNITS, UNITS);
           }
          }
          g.setColor(Color.red);
         g.setFont(new Font("Ink Free",Font.BOLD,50));
         FontMetrics metrics =getFontMetrics(g.getFont());
         g.drawString("Score: "+applesEaten,(SCREEN_WIDTH - 
                 metrics.stringWidth("Score: "+applesEaten))/2,g.getFont().getSize());
       }
       else{
           gameOver(g);
       }
   }
   
   public void newApple(){
       appleX=random.nextInt((int)(SCREEN_WIDTH/UNITS))*UNITS;
       appleY=random.nextInt((int)(SCREEN_WIDTH/UNITS))*UNITS;
   }
   public void move(){
       for(int i=bodyparts;i>0;i--){
           x[i]=x[i-1];
           y[i]=y[i-1];
       }
       switch(direction){
           case 'U':
               y[0]=y[0]-UNITS;
               break;
           case 'D':
               y[0]=y[0]+UNITS;
               break;
           case 'L':
               x[0]=x[0]-UNITS;
               break;
           case 'R':
               x[0]=x[0]+UNITS;
               break;
       }
   }
   
   public void checkApple()
     {
         if((x[0]==appleX)&&(y[0]==appleY)){
             bodyparts++;
             applesEaten++;
             newApple();
         }
         
         
     }   
    public void checkCollisions()
    {
         for(int i = bodyparts; i > 0; i--)
         {
            if((x[0]==x[i]) && (y[0]==y[i]) ){
                 isRunning=false;
              }
          }
          if(x[0] > SCREEN_WIDTH){
               isRunning=false;
             }
           if(x[0] < 0){
               isRunning=false;
             }
           if(y[0]<0){
                isRunning=false;
             }
           if(y[0] > SCREEN_HEIGHT){
               isRunning=false;
             }
           if(!isRunning){
               timer.stop();
           }
        }
    public void gameOver(Graphics g){
          g.setColor(Color.red);
         g.setFont(new Font("Ink Free",Font.BOLD,40));
         FontMetrics metrics1 =getFontMetrics(g.getFont());
         g.drawString("Score: "+applesEaten,(SCREEN_WIDTH - 
                 metrics1.stringWidth("Score: "+applesEaten))/2,g.getFont().getSize());
         g.setColor(Color.red);
         g.setFont(new Font("Ink Free",Font.BOLD,75));
         FontMetrics metrics =getFontMetrics(g.getFont());
         g.drawString("Game Over",(SCREEN_WIDTH - metrics.stringWidth("Game Over"))/2,SCREEN_HEIGHT/2);
     }
     @Override
    public void actionPerformed(ActionEvent e){
        
        if(isRunning)
        {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
        
    }
    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e)
        {
            switch(e.getKeyCode())
            {
             case KeyEvent.VK_LEFT:               
              if(direction!='R') {
                  direction='L';
              }
             break;
                 
               case  KeyEvent.VK_RIGHT:
                   
                 if(direction!='L'){
                    direction='R';
                }
              break;
                   
               case  KeyEvent.VK_UP:
                if(direction!='D'){
                   direction='U';
                }
               break;
                   
                case  KeyEvent.VK_DOWN:
                    if(direction!='U'){
                        direction='D';
                    }
                break;
            }   
        } 
    }
}