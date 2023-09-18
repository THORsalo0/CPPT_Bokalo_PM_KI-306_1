package KI306.Bokalo.Lab3;

/**
 * Тут реалізовано підклас Multi_Starship, який є підкласом Starship, а також імплементує інтерфейс Ships
 * @author Petro Bokalo KI-203
 * @version 1.0
 * @since version 1.0
*/

public class Multi_Starship extends Starship implements Ships
{
	private int Life_points; 
	public Multi_Starship(String name, String c_name)
	{
		super(name, c_name);
		Life_points = 5;
	}
	public Multi_Starship()
	{
		super();
		Life_points = 5;
	}
	
	public void Star_jump() 
	{
		for(int i = 0; i < 5; i++)
		{
			move();
		}
	}
	
	public void repair()
	{
		if(s_health == 0)
		{
			Life_points = Life_points > 0 ? Life_points - 1 : Life_points;
			super.repair();
			
		} else if(Life_points == 0)
		{
			System.out.print("\n Out of life points!!! Get more \n");
		}else if(s_health < 100 && s_health > 0)
    	{
			super.repair();
    	}
	}
	
	public void stats()
	{
		super.stats();
		System.out.print("Life Points : " + Life_points + "\n\n");
	}
	
}
