package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Spielfeld extends JFrame implements ActionListener{

    
    JButton[][] knoepfe = new JButton[3][3];
    String[] moeglicheEingaben= {"A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3"};
    String eingabe;
    boolean eingegeben;
    

    public Spielfeld(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 1000);
        this.setTitle("Tic Tac Toe");
        this.setVisible(true);
        this.setResizable(true);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(new GridLayout(3,3, 5, 5));
        


        for(int i=0; i<3;i++){
            for(int j=0; j<3; j++){
                int x=i;
                int y=j;
                x++;
                y++;
                knoepfe[i][j]=new JButton(""+x+y);
                knoepfe[i][j].setVisible(true);
                this.add(knoepfe[i][j]);
            }
            
           
            
             
        }
        
        

    }

    public void userIn (){   
        for (int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                knoepfe[i][j].addActionListener(this);  
            }         
        }  
    }



    
    @Override
    public void actionPerformed(ActionEvent e) {
      
        for (int i=0; i<knoepfe.length; i++){
            for(int j=0; j<3; j++){
                if(e.getSource()==knoepfe[i][j]){
                    eingabe=knoepfe[i][j].getText();
                    knoepfe[i][j].setText("0");
                    setEingabe(i);
                    
                }
                
            }   
        }
    }


     private void setEingabe(int index){
        eingabe= moeglicheEingaben[index];
        System.out.println("setEingabe");
     }   




    public String getEingabe(){
        System.out.println("getEingeabe"+ eingabe);
        return eingabe;

    }

    public JButton[][] getKnoepfe(){
        return knoepfe;
    }
    
    public void setTextKnoepfe(int x, int y, String text){
        knoepfe[x][y]. setText(text);
    }





}


