package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Spielfeld extends JFrame implements ActionListener{
    JButton[] knoepfe = new JButton[9];
    

    public Spielfeld(){
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 1000);
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


    public void userInput(){
        for (int i=0; i<knoepfe.length; i++){
            knoepfe[i].addActionListener(e ->System.out.println(knoepfe[i].getText()));
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }


}
