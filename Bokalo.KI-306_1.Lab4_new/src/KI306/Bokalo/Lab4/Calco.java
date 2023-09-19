package KI306.Bokalo.Lab4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Тут реалізований клас Calco який рахує Ctg введеного числа
 * @author Petro Bokalo KI-306
 * @version 1.0
 * @since version 1.0
*/

public class Calco 
{
	private double x;
	private double ctg = 0;
	PrintWriter fout;
	
	public Calco(double x)
	{
		this.x = x;
	}
	
	public double result() throws ArithmeticException
	{
		if(Math.tan(x) == 0)
		{
		throw new ArithmeticException("Exeption : Sin is equal to 0!!!\n");
		}
		else
		{
			ctg = 1 / Math.tan(x);
		}
		
		return ctg;
	}
	
	public void in_file()
	{
		try 
    	{
            fout = new PrintWriter(new BufferedWriter(new FileWriter("Lab4.txt")));
            fout.print("Ctg of x = " + result() + "\n");
            
        } catch (IOException e) 
    	{
            System.err.println("Can't use the file!!!\n");
        }
		catch (ArithmeticException a)
		{
			System.out.print(a.getMessage());
		}
	}
	public void close_file()
	{
		fout.close();
	}
}
