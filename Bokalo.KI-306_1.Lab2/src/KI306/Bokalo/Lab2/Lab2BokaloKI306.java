package KI306.Bokalo.Lab2;

import java.io.FileNotFoundException;

/**
 * Ця програма реалізовує симуляцію написаного класу згідно до 2 варіанту - Космічний корабель 
 * @author Petro Bokalo KI-203
 * @version 1.0
 * @since version 1.0
 * @throws FileNotFoundException - call when it is not a file available
 */

public class Lab2BokaloKI306 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		
		Starship ship = new Starship("King", "Sir Rodock");
		
		ship.stats();
		ship.move();
		ship.fight();
		ship.retreat();
		ship.call_captain();
		ship.stats();
		
		for(int i = 0; i < 10; i++)
		{
			ship.fight();
		}
		ship.stats();
		ship.repair();
		ship.call_captain();
		
		ship.move();
		ship.move();
		ship.stats();
		ship.refuel();
		ship.stats();
		
		ship.closer();
		
		
	}
	
}
