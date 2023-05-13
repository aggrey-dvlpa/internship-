import java.awt.*;
import javax.swing.*;
public class Main {
    //memory declararation to store my instruction;
    private String [] memory;

    //OpCodes
    final int READ;
    final int WRITE;
    final int STORE;
    final int LOAD;
    final int ADD;
    final int SUBTRACT;
    final int MULTIPLY;
    final int DIVIDE;
    final int BRANCH;
    final int BRANCHNEG;
    final int BRANCHZERO;
    final int HALT;

    //REGISTERS
    int accumulator;
    int instructionCounter;

    JTextField input,memStatus;

    //CONSTRUCOR TO INITIALIZE PROGRAM STATES
    public Main(){
        new
        input = new JTextField();
        memory = new String [100];

    }

    public void memoryHandler(){
            memory[instructionCounter] = input.getText();
            instructionCounter++;
    }
    //ENTRY POINT
    public static void main (String [] args){
     Main run = new Main();
    }
}
