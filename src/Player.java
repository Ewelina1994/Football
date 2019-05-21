import java.util.Random;
/*
 * boisko powinno mieæ 105 metrów d³ugoœci i 68 metrów szerokoœci. 
 * */

import javax.swing.JOptionPane;

public class Player 
{
    String name;
    double x;
    double y;
    double z=1.60;//default hight player
    int num;
    boolean hasBall=false;
    double initialPlaceX=0;//poczatkowe miejsce pi³karza przy starie
    double initialPlaceY=0;
    double LastX;//ostatnie miejsce pi³karza przed ost ruchem
    double LastY;
    public Player(int number, String name, double x, double y) 
    {
        this.name=name;
        this.num=number;
        this.x=x;
        this.y=y;
        initialPlaceX=x;
        initialPlaceY=y;
    }
    public double getX() {return x;}
    public double getY() {return y;}
    public double getZ() {return z;}
    public String getName() {return name;}
    
    public void move(double xDisp, double yDisp) 
    {
        
        LastX=x;
        LastY=y;
        x=x+xDisp;
        if(x>105)
        x=105;
        if(x<0)
        x=0;
        y=y+yDisp;
        if(y>68)
        y=68;
        if(y<0)
        y=0;
        
       
       // System.out.print("\n Zawodnik o nazwie "+name+"o nr: "+num+", ruszy³ sê wzgl d³ugoœci boiska o: "+xDisp+", a wzgl szerokosci o: "+yDisp);
    }
    
    public void moveWithBall(double xDisp, double yDisp, Ball ball) 
    {
        
        LastX=x;
        LastY=y;
        x=x+xDisp;
        if(x>105)
        x=105;
        if(x<0)
        x=0;
        y=y+yDisp;
        if(y>68)
        y=68;
        if(y<0)
        y=0;
        ball.setWithMove(xDisp, yDisp, 0);
        
       
       // System.out.print("\n Zawodnik o nazwie "+name+"o nr: "+num+", ruszy³ sê wzgl d³ugoœci boiska o: "+xDisp+", a wzgl szerokosci o: "+yDisp);
    }

    public void moveResetLastStep()
    {
        x=LastX;
        y=LastY;
    }
    
    public void moveResetInitial()
    {
        x=initialPlaceX;
        y=initialPlaceY;
    }
    
    public void jump(double zDisp) {
        this.z=z+zDisp;
        System.out.print("\n Zawodnik o nazwie "+name+"o numerze: "+num+", skoczy³ o: "+zDisp);
    }

    public Boolean near(Ball ball) 
    {
        double distance =Math.sqrt(Math.pow(ball.x-x, 2)+Math.pow(ball.y-this.y, 2));
        if(distance<2)
            return true;
        else
            return false;
    }
    
    public Boolean playerHasBall(Ball ball) 
    {
        double distance =Math.sqrt(Math.pow(ball.x-x, 2)+Math.pow(ball.y-this.y, 2));
        if(distance<2)
            return true;
        else
            return false;
    }

    public void kick(Ball ball, Player player) 
    {
        ball.setXYZ(player.x+1, player.y, player.z);
        System.out.print("\n Zawodnik o nazwie "+name+"o numerze: "+num+", poda³ pi³kê do zawodnika : "+player.toString());
 
    }
    
    public void kick2(Ball ball, Player player) 
    {
        ball.setXYZ(player.x-1, player.y, player.z);
        System.out.print("\n Zawodnik o nazwie "+name+"o numerze: "+num+", poda³ pi³kê do zawodnika : "+player.toString());
 
    }
    
    public void takeTheBall(Ball ball, Player player) 
    {
        ball.setXYZ(player.x+1, player.y, player.z);
        System.out.print("\n Zawodnik o nazwie "+name+"o numerze: "+num+", przejo³ pi³kê: ");
 
    }
    
    public void takeTheBall2(Ball ball, Player player) 
    {
        ball.setXYZ(player.x-1, player.y, player.z);
        System.out.print("\n Zawodnik o nazwie "+name+"o numerze: "+num+", przejo³ pi³kê: ");
 
    }

    public boolean shot(Ball ball) //czy wys³aæ w argumencie gate???
    {
        Random r=new Random();
        //rozwazamy wieksze prawdopodobienstwa jesli pi³karz jest 11 m od lini na której jest bramkarza
        //i 17 metrów od linii bocznej z obydwuch stron
        System.out.print("\n Pi³ka= "+ball.getX()+", "+ball.getY());
             if(ball.getX()>90 && ball.getY()>14&& ball.getY()<54)//d³ugosc 105-16=90 szerokosc 68-17=51
              {
                  double randomNumberToShootY = (double)(r.nextInt(43-25+1)+25);//losowanie tak jak¹ szerokosc ma pole bramkowe
                  double randomNumberToShootZ=(double)r.nextInt(3);
                  ball.setXYZ(105, randomNumberToShootY, randomNumberToShootZ);//losujemy czy zawodnik strzelli do bramki czy nie
                  //ustawiamy y w zakresie 26 do 41, czyli 4 metry dalej od 2 s³upka i 4 km dalej od 1 s³upka
                  System.out.print("\n Pi³ka= "+ball.getX()+", "+ball.getY());
                  if(randomNumberToShootY>31 && randomNumberToShootY<37 &&randomNumberToShootZ<=2)
                  {
                	  System.out.print("\nYou scored the goal!! \n Pi³ka = "+ball.getX()+", "+ball.getY()+", "+ball.getZ());
                	  return true;
                  }
                  
                   else
                   {
                	   System.out.print("\nYou don't scored the goal :(, but it was close \n "
       	            		+ "Pi³ka = "+ball.getX()+", "+ball.getY()+", "+ball.getZ());
                	   return false;
                   }
              }
              else
              {
                 double randomNumberToShootY = (double)r.nextInt(50);//nie moge nextDouble ustawic zakresu losowania
                  double randomNumberToShootZ=(double)r.nextInt(3);
                  ball.setXYZ(105, randomNumberToShootY, randomNumberToShootZ);//losujemy przyk³adowo gdzie pi³ka poleci (po ca³ej szrokosci boiska
                  System.out.print("\n Pi³ka= "+ball.getX()+", "+ball.getY());
                    
                  System.out.print("\nYou don't scored the goal :( \n Pilka = "+ball.getX()+", "+ball.getY()+", "+ball.getZ());
                  return false;
                    
              }
            
        }
    boolean shot2(Ball ball)
    {
    	Random r=new Random();
	    if(ball.getX()<16 && ball.getY()>14 && ball.getY()<54)
	    {
	        double randomNumberToShootY = (double)(r.nextInt(43-25+1)+25);//nie moge nextDouble ustawic zakresu losowania
	        double randomNumberToShootZ=(double)r.nextInt(3);
	        ball.setXYZ(0, randomNumberToShootY, randomNumberToShootZ);//losujemy czy zawodnik strzelli do bramki czy nie
	    //ustawiamy y w zakresie 26 do 41, czyli 4 metry dalej od 2 s³upka i 4 km dalej od 1 s³upka
	        if(randomNumberToShootY>31&& randomNumberToShootY<37&&randomNumberToShootZ<=2)
	        {
	        	//JOptionPane.showMessageDialog(null, "You scored the goal!!");
	            System.out.print("\nYou scored the goal!! \n Pi³ka = "+ball.getX()+", "+ball.getY());
	            return true;
	        }
	        else
	        {
	        	//JOptionPane.showMessageDialog(null, "You don't scored the goal :( but it was close");
	            System.out.print("\nYou don't scored the goal :(, but it was close \n "
	            		+ "Pi³ka = "+ball.getX()+", "+ball.getY());
	            return false;
	        }
	
	    }
	    else
	    {
	        double randomNumberToShootY = (double)r.nextInt(50);//nie moge nextDouble ustawic zakresu losowania
	        double randomNumberToShootZ=(double)r.nextInt(3);
	        ball.setXYZ(0, randomNumberToShootY, randomNumberToShootZ);//losujemy przyk³adowo gdzie pi³ka poleci (po ca³ej szrokosci boiska
	        
	        //JOptionPane.showMessageDialog(null, "You don't scored the goal :( ");
	        System.out.print("\nYou don't scored the goal :( \n Pilka = "+ball.getX()+", "+ball.getY());
	        return false;
	        
	    }
	    
	  
        
    }

}
