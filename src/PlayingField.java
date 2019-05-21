import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import javax.swing.JPanel;

public class PlayingField extends JPanel
{
    String namePlayersTeamFirst[]= {"Sven Ulreich", "Lucas Hernández", "Niklas Süle", "Lucas Hernández", "Marco Friedl", "Javi Martínez", "Meritan Shabani", "Thiago", "Renato Sanches", "Robert Lewandowski", "Thomas Müller"};
    String namePlayersTeamSecond[]= {"Jasper Cillessen", "Samuel Umtiti", "Gerard Piqué", "Jeison Murillo", "Thomas Vermaelen", "Sergio Busquets", "Ivan Rakitic", "Carles Aleñà", "Philippe Coutinho", "Lionel Messi", "Luis Suárez"};
    TeamFirst teamFirst;
    TeamSecond teamSecond;
    GateFirst gateFirst;
    GateSecond gateSecond;
    Ball ball;
    int weight=105;//o metr więcej niż boisko
    int height=68;//o metr więcej niż boisko
    //BufferedImage playingField;
    Graphics g;
    public PlayingField()
    {
        super();
        setSizePlayingFields();
        teamFirst=new TeamFirst(namePlayersTeamFirst, "BayerMonachium");
        teamSecond= new TeamSecond(namePlayersTeamSecond, "FC Barcelona");
        gateFirst=new GateFirst();
        gateSecond=new GateSecond();
        ball=new Ball();

    }

    public void setSizePlayingFields()
    {
        //playingField=new BufferedImage(1050, 680, BufferedImage.TYPE_INT_RGB);
        //setPreferredSize(getPreferredSize());
        setPreferredSize(new Dimension(109*8,72*8));//powieżchnia o 2 m z każdej strony większa niz boisko 106 i 69 pomnożone o 8
        //większe boisko żeby było widać
        setMaximumSize(getMaximumSize());
        setBackground(Color.green);
    }
    
    //ustaw po szczeleniu gola pozycje startową
    void setStartingPosition()
    {
    	ball.startingPosition();
    	teamFirst.startingPosition();
    	teamSecond.startingPosition();
    	
    }
    @Override
    public void paintComponent(final Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.ORANGE);
        
        //rysuj pierwszą drużynę
        for(int i=0; i<11; i++)
        {
            Player p=teamFirst.teamFirst[i];
            g2d.draw3DRect((int) (p.getX()+2)*8, (int) (p.getY()+2)*8, 1*8 , (int) p.getZ()*8, true);
            //wypełnienie prostokąta
            g2d.fillRect((int) (p.getX()+2)*8,  (int) (p.getY()+2)*8, 1*8, (int) p.getZ()*8);
            int num=p.num;
            String name = p.name;
            char[] nameChar = name.toCharArray();
            String numChar = Integer.toString(num);
            g2d.drawChars(nameChar, 0, p.name.length(),(int) p.getX()*8,(int) (p.getY()+2)*8);
            // g2d.fillRect((int) p.getX(), (int) p.getY(), 2, 2);
            g2d.drawString(numChar, (int) (p.getX()+2)*8,(int) (p.getY()+0.5)*8);
          repaint();
        }
        
        //rysuj drugą drużynę
        g2d.setColor(Color.BLUE);
         for(int i=0; i<11; i++)
        {
             Player p2=teamSecond.teamSecond[i];
            g2d.draw3DRect((int)(p2.getX()+2)*8, (int) (p2.getY()+2)*8,1*8 , (int) (p2.getZ())*8, true);
            g2d.fillRect((int)(p2.getX()+2)*8, (int) (p2.getY()+2)*8,1*8 , (int) (p2.getZ())*8);
            int num=p2.num;
            String name = p2.name;
            char[] nameChar = name.toCharArray();
            String numChar = Integer.toString(num);
            g2d.drawChars(nameChar, 0, p2.name.length(),(int)(p2.getX())*8,(int) (p2.getY()+2)*8);
            g2d.drawString(numChar, (int)(p2.getX()+2)*8,(int) (p2.getY()+0.5)*8);
            repaint();
        }
        //rysuj piłkę
        g2d.setColor(Color.RED);
        g2d.draw3DRect((int) (ball.getX()+2)*8, (int) (ball.getY()+2)*8, 1*8 , (int) ball.getZ()*8, true);
        g2d.fillRect((int)(ball.getX()+2)*8, (int) (ball.getY()+2)*8, 1*8 , (int) ball.getZ()*8);
        
        //rysuj linie boczne boiska
        g2d.setColor(Color.WHITE);
        g2d.draw3DRect(2*8, 2*8, weight*8, height*8, true);
        //rysuj linię srodkową
        g2d.drawLine((int)(109/2)*8, 2*8, (int)(109/2)*8, (height+2)*8);
        
        //rysuj pole karne
       g2d.draw3DRect(2*8, (14+2)*8, 16*8, 40*8, true);
       g2d.draw3DRect((109-2-16)*8, (14+2)*8, 16*8, 40*8, true);
       //rysuj koło na srodku
       g2d.drawOval((43+2)*8, (25+2)*8, 18*8, 18*8);
       //rysuj półkoła na koło bramek
       g2d.drawArc((3+2)*8, (25+2)*8, 18*8, 18*8, 295, 130);
       g2d.drawArc(85*8, (25+2)*8, 18*8, 18*8, 110, 140);
       
       //rysuj pole blisko bramki
       g2d.draw3DRect(2*8, (25+2)*8, 5*8, 18*8, true);
       g2d.draw3DRect((109-2-5)*8, (25+2)*8, 5*8, 18*8, true);
       //rysuj bramki
       g2d.draw3DRect(1*8, (30+2)*8, 1*8, 8*8, true);
       g2d.draw3DRect((109-2)*8, (30+2)*8, 1*8, 8*8, true);
        
        
    }

}
