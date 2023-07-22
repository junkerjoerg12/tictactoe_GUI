package gui;

import javax.swing.*;
import java.awt.*;

public class Spielfeld extends JFrame{
    JButton[] knoepfe = new JButton[9];
    

    public Spielfeld(){
        //JFrame spielfeld= new JFrame("Tic Tac Toe");
        this.setSize(300, 300);
        this.setTitle("Tic Tac Toe");
        System.out.println("test");
        this.setVisible(true);
        this.setResizable(true);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(new GridLayout(3,3, 5, 5));
        


        for(int i=0; i<knoepfe.length;i++){

            if(i<3){
                knoepfe[i]=new JButton("A"+(i+1));
            }else if(i<6){
                knoepfe[i]=new JButton("B"+(i+1-3));
            }else if(i<9){
                knoepfe[i]=new JButton("C"+(i+1-6));
            }
            
            knoepfe[i].setVisible(true);
            this.add(knoepfe[i]);
            

            
        }

      



    }
}
