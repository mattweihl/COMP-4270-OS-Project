
public class Barber 
{
	private boolean isAwake;
	
	public Barber()
	{
		isAwake = false;
	}
	
	public boolean isAwake()
	{
		return isAwake;
	}
	
	public void goToSleep()
	{
		isAwake = false;
	}
	
	public void wakeUp()
	{
		isAwake = true;
	}

}
