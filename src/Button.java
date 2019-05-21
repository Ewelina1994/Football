import java.awt.*;
import javax.swing.*;

public class Button extends JPanel
{
    JButton []button =new JButton[14];
    JTextField []textField= new JTextField[6];
    JLabel []label=new JLabel[10];
    GridBagConstraints b = new GridBagConstraints();
    GridBagConstraints c = new GridBagConstraints();
    public Button() 
    {
        super();     
        setLayout(new GridBagLayout());
        
        Font font = new Font("Code2000", Font.PLAIN, 16);
        
        
        label[0]=new JLabel("Enter the player's number");
        textField[0]=new JTextField();
        button[0]=new JButton("\u2196");//przód lewo
        button[1]=new JButton("\u2191");//przód
        button[2]=new JButton("\u2197");//przód prawo
        button[3]=new JButton("\u2190");//lewo
        label[1]=new JLabel("");
        button[4]=new JButton("\u2192");//prawo
        button[5]=new JButton("\u2199");//ty³ lewo
        button[6]=new JButton("\u2193");//ty³
        button[7]=new JButton("\u2198");//ty³ prawo
        
        button[8]=new JButton("Move reset last step");
        button[9]=new JButton("Move reset for start");
        button[10]=new JButton("Jump");
        button[11]=new JButton("Near Ball");
        label[1]=new JLabel("Who to give to");
        textField[1]=new JTextField();
        button[12]=new JButton("Kick to Player");
        button[13]=new JButton("Shot");
        
        for(int i=0; i<8; i++)
            button[i].setFont(font);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        
        c.weightx = 0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 0;
        add(label[0], c);
        
        c.weightx = 0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        add(textField[0],c);
        
        b.gridx = 0;
        c.gridy = 0;
        add(button[0],b);
        
        b.gridx = 1;
        c.gridy = 0;
        add(button[1],b);
        
        b.gridx = 2;
        c.gridy = 0;
        add(button[2],b);
        
         b.gridx = 0;
        c.gridy = 1;
        add(button[3],b);
        
        b.gridx = 1;
        c.gridy = 1;
        add(label[1],b);
        
         b.gridx = 2;
        c.gridy = 1;
        add(button[4],b);
        
         b.gridx = 0;
        c.gridy = 2;
        add(button[5],b);
        
         b.gridx = 1;
        c.gridy = 2;
        add(button[6],b);
        
         b.gridx = 2;
        c.gridy = 2;
        add(button[7],b);
        /*
        //menu strza³ki
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 2;
        add(button[0],c);
      
       // c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 2;
        add(button[1],c);
        
        //c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 2;
        add(button[2],c);
        
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 3;
        add(button[3],c);
        
        //c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 3;
        add(button[4],c);
        
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 4;
        add(button[5],c);
        
        //c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 4;
        add(button[6],c);
        
        //c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 4;
        add(button[7],c);
        */
        //nastepne buttony
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 5;
        add(button[8],c);
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 6;
        add(button[9],c);
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 7;
        add(button[10],c);
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 8;
        add(button[11],c);
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 9;
        add(label[1],c);
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 10;
        add(textField[1],c);
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 11;
        add(button[12],c);
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 12;
        add(button[13],c);
        
        
/*
 *
 */
       
    }
}