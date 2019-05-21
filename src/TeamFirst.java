
public class TeamFirst 
{
    String nameTeam;
    Player teamFirst[];
    public TeamFirst(String namePlayers[], String nameTeam)
    {
        teamFirst=new Player[11];
        this.nameTeam=nameTeam;
        if(namePlayers.length==11)
        {
            teamFirst[0]=new Player(1,namePlayers[0],0,34);
            teamFirst[1]=new Player(2,namePlayers[1],17,6);
            teamFirst[2]=new Player(3,namePlayers[2],17,24);
            teamFirst[3]=new Player(4,namePlayers[3],17,44);
            teamFirst[4]=new Player(5,namePlayers[4],17,60);
            teamFirst[5]=new Player(6,namePlayers[5],34,6);
            teamFirst[6]=new Player(7,namePlayers[6],34,24);
            teamFirst[7]=new Player(8,namePlayers[7],34,44);
            teamFirst[8]=new Player(9,namePlayers[8],34,60);
            teamFirst[9]=new Player(10,namePlayers[9],50,24);
            teamFirst[10]=new Player(11,namePlayers[10],50,44);
      
        }
    }
    
    void startingPosition()
	{
    	for(int i=0; i<teamFirst.length; i++)
    		teamFirst[i].moveResetInitial();
	}
}
