package KI306.Bokalo.Lab3;

import java.io.FileNotFoundException;

/**
 * Дана програма тестує підклас написаний згідно до 2 варіанту - Багаторазовий космічний корабель
 * @author Petro Bokalo KI-306
 * @version 1.0
 * @since version 1.0
*/

public class Lab3BokaloKI306 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		
		Multi_Starship ms = new Multi_Starship("Boss", "Soreman");
		
		ms.stats();
		
		for (int i = 0; i <10; i++)
		{
			ms.fight();
		}

		ms.stats();
		
		ms.repair();
		
		ms.stats();
		
		ms.call_captain();
		
		ms.closer();
	
	}
	
	
}
