
public class TeamSecond 
{
    String nameTeam;
    Player teamSecond[];
    public TeamSecond(String namePlayers[], String nameTeam)
    {
        teamSecond=new Player[11];
        this.nameTeam=nameTeam;
        if(namePlayers.length==11)
        {
            teamSecond[0]=new Player(1,namePlayers[0],105,34);
            teamSecond[1]=new Player(2,namePlayers[1],88,6);
            teamSecond[2]=new Player(3,namePlayers[2],88,24);
            teamSecond[3]=new Player(4,namePlayers[3],88,44);
            teamSecond[4]=new Player(5,namePlayers[4],88,60);
            teamSecond[5]=new Player(6,namePlayers[5],71,6);
            teamSecond[6]=new Player(7,namePlayers[6],71,24);
            teamSecond[7]=new Player(8,namePlayers[7],71,44);
            teamSecond[8]=new Player(9,namePlayers[8],71,60);
            teamSecond[9]=new Player(10,namePlayers[9],55,24);
            teamSecond[10]=new Player(11,namePlayers[10],55,44);
 
        }
    }
      public void startingPosition()
    	{
        	for(int i=0; i<teamSecond.length; i++)
        		teamSecond[i].moveResetInitial();
    	}
        

}
