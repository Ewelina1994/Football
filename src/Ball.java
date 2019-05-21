
public class Ball 
{
	double x, y, z;
	public Ball()
	{
		x=52.5;
		y=34;
		z=0;
	}
	public Ball(double x, double y, double z)
	{
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	public double getX() {return x;}
	public double getY() {return y;}
	public double getZ() {return z;}
	public void setWithMove(double x, double y, double z)
	{
		this.x+=x;
		this.y+=y;
		this.z+=z;
		
		if(x>105)
	        x=105;
	        if(x<0)
	        x=0;
	        if(y>68)
	        y=68;
	        if(y<0)
	        y=0;
	}
	public void setXYZ(double x, double y, double z)
	{
		this.x=x;
		this.y=y;
		this.z=z;
		if(x>105)
	        x=105;
	        if(x<0)
	        x=0;
	        if(y>68)
	        y=68;
	        if(y<0)
	        y=0;
	}
	
	void startingPosition()
	{
		x=52.5;
		y=34;
		z=0;
	}
	public String toString()
	{
		String s="";
		s+="Po³o¿enie pi³ki znajdujê siê w miejscu, x= "+x+", y= "+y+", z= "+z;
		return s;
	}
}
