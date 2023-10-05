package KI306.Bokalo.Lab6;

import java.io.IOException;

/**
 * Дана програма є класом драйвером який тестує роботу класу My_list
 * @author Petro Bokalo KI-306
 * @version 1.0
 * @since version 1.0
*/

public class Lab6BokaloKI306 
{
	public static void main(String[] args)throws IOException
	{
		My_list<String> lst = new My_list();
		lst.add("zppleeeeeeeeee");
		lst.add("orange");
		System.out.print(lst.findMin() + "\n");
		lst.display();
		
		
		My_list<Integer> lst1 = new My_list();
		lst1.add(1);
		lst1.add(34);
		lst1.add(-100);
		System.out.print("\n" + lst1.findMin() + "\n");
		lst1.display();
		lst1.remove(34);
		lst1.display();
	}
}
