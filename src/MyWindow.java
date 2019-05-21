import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import java.awt.GridBagConstraints;
import java.awt.*;
import javax.swing.*;

public class MyWindow extends JFrame implements ActionListener
{
    PlayingField playingField=new PlayingField();
    MenuWindow menuWindow=new MenuWindow();
    Button butonsFirstTeam= new Button();
    Button buttonSecondTeam= new Button();
    //czy pi³ka zosta³a komus podana?
    boolean WasPassingBall=false;
    //number in first team
    int numberPlayerFirstTeam;
    int numberPlayerSecondTeam;
    //numery do jakiego przeciwnika podana pi³ka
    int playerPassingBallFirstTeam;
    int playerPassingBallSecondTeam;
    

    
    
    public MyWindow()
    {
        super("Project my match in football- Ewelina K³obut");
        

        //ustawienie akcji po naciœniêciu przycisku zamkniêcia
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //blokada zmiany rozmairu okna
        setResizable(true);
        
        setLayout(new GridBagLayout());
        //ustawia elementy jeden za druhgim i wyposrodkownie
        //setLayout(new FlowLayout(FlowLayout.CENTER, 4, 4));
        GridBagConstraints c = new GridBagConstraints();
        //ustawienie stworzonego baru
        setJMenuBar(menuWindow);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        add(butonsFirstTeam,c);

        c.gridx = 1;
        c.gridy = 0;
        add(playingField,c);
        
         c.gridx = 2;
        c.gridy = 0;
        add(buttonSecondTeam,c);

        setListenEvents();
        //dostosowanie okna do zawartoœci
        pack();   
        //wyœrodkowanie ramki
        setLocationRelativeTo(null);  
       
        setVisible(true);
        
    }

    private void setListenEvents() 
    {
        menuWindow.edit.addActionListener(this);
        menuWindow.exit.addActionListener(this);
        menuWindow.file.addActionListener(this);
        menuWindow.openFile.addActionListener(this);
       for(int i=0; i<butonsFirstTeam.button.length; i++)
       {
           butonsFirstTeam.button[i].addActionListener(this);
     
    }
    
        for(int i=0; i<buttonSecondTeam.button.length; i++)
       {
           buttonSecondTeam.button[i].addActionListener(this);
       }
        
    }
    
    void movePlayerFirstTeam(int x, int y)
	{
    	//spr czy zosat³ podany zawodnik
   	 if(butonsFirstTeam.textField[0].getText().equals(""))
   		 JOptionPane.showMessageDialog(null, "Podaj który zawodnik ma siê ruszyæ");
        else
        {
            numberPlayerFirstTeam=Integer.parseInt(butonsFirstTeam.textField[0].getText())-1;
        
           	
           //playingField.teamFirst.teamFirst[numberPlayerFirstTeam].move(x,y);
           //System.out.print("\n Zawodnik= "+playingField.teamFirst.teamFirst[numberPlayerFirstTeam].getName()+", "+playingField.teamFirst.teamFirst[numberPlayerFirstTeam].getX()+", "+playingField.teamFirst.teamFirst[numberPlayerFirstTeam].getY());
           
           //jesli zawodni jest blisko pili mo¿e j¹ wziaœc i z ni¹ biegn¹æ
           if(playingField.teamFirst.teamFirst[numberPlayerFirstTeam].near(playingField.ball)||playingField.teamFirst.teamFirst[numberPlayerFirstTeam].hasBall)
           { 
        	   playingField.teamFirst.teamFirst[numberPlayerFirstTeam].takeTheBall(playingField.ball, playingField.teamFirst.teamFirst[numberPlayerFirstTeam]);
        	   playingField.teamFirst.teamFirst[numberPlayerFirstTeam].moveWithBall(x, y, playingField.ball);
        	  // playingField.ball.setXYZ(playingField.teamFirst.teamFirst[numberPlayerFirstTeam].x+1.5, playingField.teamFirst.teamFirst[numberPlayerFirstTeam].y, 0);
        	   playingField.teamFirst.teamFirst[numberPlayerFirstTeam].hasBall=true;
           }
           else
           {
        	   playingField.teamFirst.teamFirst[numberPlayerFirstTeam].move(x,y);
           }
         //jesli pilkarz ma pilke to biegnie z pilka
          /* if(playingField.teamFirst.teamFirst[numberPlayerFirstTeam].hasBall)
           { 
        	   playingField.ball.setWithMove(x, y, 0);
        	   System.out.print("\n Pi³ka= "+playingField.ball.getX()+", "+playingField.ball.getY());
           }*/
           
           
        }
   	
    }
 
    void movePlayerSecondTeam(int x, int y)
	{
		//spr czy zosat³ podany zawodnik
   	 	if(buttonSecondTeam.textField[0].getText().equals(""))
   		 JOptionPane.showMessageDialog(null, "Podaj który zawodnik ma siê ruszyæ");
        else
        {
             numberPlayerSecondTeam=Integer.parseInt(buttonSecondTeam.textField[0].getText())-1;
             
             //jesli zawodnik znajduje siê 1.5 m od pi³ki przyjmuje pi³ke
             if(playingField.teamSecond.teamSecond[numberPlayerSecondTeam].near(playingField.ball)||playingField.teamSecond.teamSecond[numberPlayerSecondTeam].hasBall)
             {
             	playingField.teamSecond.teamSecond[numberPlayerSecondTeam].takeTheBall2(playingField.ball, playingField.teamSecond.teamSecond[numberPlayerSecondTeam]);
             	 playingField.teamSecond.teamSecond[numberPlayerSecondTeam].moveWithBall(x, y, playingField.ball);
             	//playingField.ball.setXYZ(playingField.teamSecond.teamSecond[numberPlayerSecondTeam].getX()+1.5, playingField.teamSecond.teamSecond[numberPlayerSecondTeam].getY(), 0);//to nie dzia³a :(
             	playingField.teamSecond.teamSecond[playerPassingBallSecondTeam].hasBall=true;
             	System.out.print("\n Pi³ka= "+playingField.ball.getX()+", "+playingField.ball.getY());
             }
             else
             {
             //rusz siê zawodnik
            playingField.teamSecond.teamSecond[numberPlayerSecondTeam].move(x,y);
            System.out.print("\n Zawodnik= "+playingField.teamSecond.teamSecond[numberPlayerSecondTeam].getName()+", "+playingField.teamSecond.teamSecond[numberPlayerSecondTeam].getX()+", "+playingField.teamSecond.teamSecond[numberPlayerSecondTeam].getY());
           
             }	
            //jesli pilkarz ma pilke to biegnie z pilka
            /*if(playingField.teamSecond.teamSecond[numberPlayerSecondTeam].hasBall)
            {
                    playingField.ball.setWithMove(x, y, 0);
                   // System.out.print("\n Pi³ka= "+playingField.ball.getX()+", "+playingField.ball.getY());
            }*/
        }  
   	
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String label=e.getActionCommand();
        Object zrodlo = e.getSource();

        if(label.equals("Open file"))
        {
            openFile();
        }
        if(label.equals("Exit"))
        {
            System.exit(0);
        }
        if(zrodlo ==butonsFirstTeam.button[0])//move ->/ first Team
        {
        	movePlayerFirstTeam(1,-1);
        }
        if(zrodlo ==butonsFirstTeam.button[1])//move ->first Team
        {
        	movePlayerFirstTeam(1,0);
        }
        if(zrodlo ==butonsFirstTeam.button[2])//move first ->\Team
        {
        	movePlayerFirstTeam(1,1);
        }
        if(zrodlo ==butonsFirstTeam.button[3])//move <- first Team
        {
        	movePlayerFirstTeam(0,-1);
        }
        if(zrodlo ==butonsFirstTeam.button[4])//move -> first Team
        {
        	movePlayerFirstTeam(0, 1);
        }
        if(zrodlo ==butonsFirstTeam.button[5])//move <-|first Team
        {
        	movePlayerFirstTeam(-1,-1);
        }
        if(zrodlo ==butonsFirstTeam.button[6])//move |v first Team
        {
        	movePlayerFirstTeam(-1, 0);
        }
        if(zrodlo ==butonsFirstTeam.button[7])//move ->|v first Team
        {
        	movePlayerFirstTeam(-1, 1);
        }
        
        
        if(zrodlo ==buttonSecondTeam.button[0])//move second team
        {
        	//metoda co oblicza czy zosta³ podany zawodnik i przesuwa zawodnika i ewentualnie pi³kê o zadan¹ liczbe oczek
        	movePlayerSecondTeam(-1,1);
        }
        if(zrodlo ==buttonSecondTeam.button[1])//move second team
        {
        	movePlayerSecondTeam(-1,0);
        }
        if(zrodlo ==buttonSecondTeam.button[2])//move second team
        {
        	movePlayerSecondTeam(-1,-1);
        }
        if(zrodlo ==buttonSecondTeam.button[3])//move second team
        {
        	movePlayerSecondTeam(0,1);
        }
        if(zrodlo ==buttonSecondTeam.button[4])//move second team
        {
        	movePlayerSecondTeam(0,-1);
        }
        if(zrodlo ==buttonSecondTeam.button[5])//move second team
        {
        	movePlayerSecondTeam(1,1);
        }
        if(zrodlo ==buttonSecondTeam.button[6])//move second team
        {
        	movePlayerSecondTeam(1, 0);
        }
        if(zrodlo ==buttonSecondTeam.button[7])//move second team
        {
        	movePlayerSecondTeam(1,-1);
        }
        	
        	
      //zle nazwy przycisków
        if(zrodlo ==butonsFirstTeam.button[8])
        {
            playingField.teamFirst.teamFirst[numberPlayerFirstTeam].moveResetLastStep();
            
        }
        if(zrodlo ==buttonSecondTeam.button[8])
        {
            playingField.teamSecond.teamSecond[numberPlayerSecondTeam].moveResetLastStep();
           
        }
        if(zrodlo ==butonsFirstTeam.button[9])
        {
           playingField.teamFirst.teamFirst[numberPlayerFirstTeam].moveResetInitial();
            
        }
        if(zrodlo ==buttonSecondTeam.button[9])
        {
            playingField.teamSecond.teamSecond[numberPlayerSecondTeam].moveResetInitial();
            
        }
        if(zrodlo ==butonsFirstTeam.button[10])
        {//niedopracowane
            playingField.teamFirst.teamFirst[numberPlayerFirstTeam].jump(1);
        }
        if(zrodlo ==buttonSecondTeam.button[10])
        {//niedopracowane
            playingField.teamSecond.teamSecond[numberPlayerSecondTeam].jump(1);
        }
        if(zrodlo ==butonsFirstTeam.button[12])//podanie
        {//niedopracowane
           
            //jesli nie podano nic w textField
            if(butonsFirstTeam.textField[1].getText().isEmpty())
                JOptionPane.showMessageDialog(null, "Podaj do jakiego zawodnika podaæ");
            else
            {
            	//wczytanie do zmiennej z pola tekstowego, do kogo podajemy
            	 playerPassingBallFirstTeam=Integer.parseInt(butonsFirstTeam.textField[1].getText())-1;
            	 
            //jesli pi³karz znjaduje siê odpowiednio blisko pi³ki to mo¿e podaæ
	            if(playingField.teamFirst.teamFirst[numberPlayerFirstTeam].near(playingField.ball))
	            {
	                playingField.teamFirst.teamFirst[numberPlayerFirstTeam].kick(playingField.ball, playingField.teamFirst.teamFirst[playerPassingBallFirstTeam]);
	                System.out.print("\n Pi³ka= "+playingField.ball.getX()+", "+playingField.ball.getY());
	                playingField.teamFirst.teamFirst[playerPassingBallFirstTeam].hasBall=true;
	                //ustaw ¿e po podaniu pi³ki domyœlnie ustawione pole textField pi³karza jest na tego do kogo by³o podanie pi³ki
	                //niedopracowane
	                //WasPassingBall=true;
	            }
            }
            butonsFirstTeam.textField[0]=butonsFirstTeam.textField[1];
            //jka zrobic automatyczne wpisanie do pola czegos
            //butonsFirstTeam.textField[0].setInputVerifier(butonsFirstTeam.textField[1]);
        }
        if(zrodlo ==buttonSecondTeam.button[12])//podanie druga dru¿yna
        {//niedopracowane
            
          //jesli nie podano nic w textField
            if(buttonSecondTeam.textField[1].getText().isEmpty())
                JOptionPane.showMessageDialog(null, "Podaj do jakiego zawodnika podaæ");
            else
            {
            	playerPassingBallSecondTeam=Integer.parseInt(buttonSecondTeam.textField[1].getText())-1;
            	
	            if(playingField.teamSecond.teamSecond[numberPlayerSecondTeam].near(playingField.ball))
	            {
	                playingField.teamSecond.teamSecond[numberPlayerSecondTeam].kick2(playingField.ball, playingField.teamSecond.teamSecond[playerPassingBallSecondTeam]);
	                System.out.print("\n Pi³ka po podaniu pi³ki= "+playingField.ball.getX()+", "+playingField.ball.getY());
	                playingField.teamSecond.teamSecond[playerPassingBallSecondTeam].hasBall=true;
	                //ustaw ¿e po podaniu pi³ki domyœlnie ustawione pole textField pi³karza jest na tego do kogo by³o podanie pi³ki
	                WasPassingBall=true;
	            }
	            
            }
            buttonSecondTeam.textField[0]=buttonSecondTeam.textField[1];
        }
        
        if(zrodlo==butonsFirstTeam.button[13])//strza³ pierwsza dru¿yna
        {
        	playingField.teamFirst.teamFirst[numberPlayerFirstTeam].shot(playingField.ball);
        	
        	if(playingField.teamFirst.teamFirst[numberPlayerFirstTeam].shot(playingField.ball))
        	{
        		JOptionPane.showMessageDialog(null, "You scored the goal!!");
        		playingField.setStartingPosition();
        	}
        	else
        		JOptionPane.showMessageDialog(null, "You don't scored the goal :( ");
        	
        	playingField.teamFirst.teamFirst[numberPlayerFirstTeam].hasBall=false;
        }
        
        if(zrodlo==buttonSecondTeam.button[13])//strza³ druga dru¿yna
        {
        	playingField.teamSecond.teamSecond[numberPlayerSecondTeam].shot2(playingField.ball);
        	if(playingField.teamSecond.teamSecond[numberPlayerSecondTeam].shot2(playingField.ball))
        	{
        		JOptionPane.showMessageDialog(null, "You scored the goal!!");
        		playingField.setStartingPosition();
        	}
        	else
        		JOptionPane.showMessageDialog(null, "You don't scored the goal :( ");
        	
        	playingField.teamSecond.teamSecond[numberPlayerSecondTeam].hasBall=false;
        }
    }
    
    private void openFile() 
    {
        // TODO Auto-generated method stub
        
    }
}
