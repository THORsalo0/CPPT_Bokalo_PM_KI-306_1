package KI306.Bokalo.Lab2;

import java.io.FileNotFoundException;
import java.io.*;
/**
 * Тут реалізовано класи Starship і Captain
 * @author Petro Bokalo KI-203
 * @version 1.0
 * @since version 1.0
*/

public class Starship 
{
    private int fuel;
    private String s_name;
    private int s_health;
    private int staff;
    private Captain captain;
    private boolean is_fighting = false;
    private PrintWriter fout;
    
    
    
    public int getFuel() {
    	fout.write("\n  public int getFuel()  : was used\n");
		return fuel;
	}

	public void setFuel(int fuel) {
		this.fuel = fuel;
		fout.write("\n  public void setFuel(int fuel)  : was used\n");
	}

	public String getS_name() {
		fout.write("\n  public String getS_name()  : was used\n");
		return s_name;
	}

	public void setS_name(String s_name) {
		fout.write("\n  public void setS_name()  : was used\n");
		this.s_name = s_name;
	}

	public int getS_health() {
		fout.write("\n  public int getS_health()  : was used\n");
		return s_health;
	}

	public void setS_health(int s_health) {
		fout.write("\n  public void setS_health(int s_health)  : was used\n");
		this.s_health = s_health;
	}

	public int getStaff() {
		fout.write("\n  public int getStaff()  : was used\n");
		return staff;
	}

	public void setStaff(int staff) {
		fout.write("\n  public void setStaff(int staff)()  : was used\n");
		this.staff = staff;
	}
	
	public Starship()
    {
    	fuel = 100;
    	s_name = "void";
    	s_health = 100;
    	staff = 10;
    	captain = new Captain();
    	try 
    	{
            fout = new PrintWriter(new BufferedWriter(new FileWriter("Starship_log.txt", true)));
        } catch (IOException e) 
    	{
            System.err.println("Помилка: файл Captain_log.txt не може бути створений або записаний.");
        }

        fout.write("\n  public Starship()  : was used\n");
    }
    
    public Starship(String name, String c_name)
    {
    	fuel = 100;
    	this.s_name = name;
    	s_health = 100; 
    	staff = 10;
    	captain = new Captain(c_name);
    	try 
    	{
            fout = new PrintWriter(new BufferedWriter(new FileWriter("Starship_log.txt", true)));
        } catch (IOException e) 
    	{
            System.err.println("Помилка: файл Captain_log.txt не може бути створений або записаний.");
        }

        fout.write("\n  public Starship(String name, String c_name)  : was used\n");
    }
    
    public void closer()
    {
    	fout.write("public void closer() : was used\n");
        if (fout != null) 
        {
            fout.close();
            captain.close();
        }
    }

    public void call_captain()
    {
    	captain.Captain_stats();
    }
    
    public void move()
    {
    	if(fuel > 10)
    	{
    		fuel -=10;
    	}
    	else
    	{
    		System.out.print("\n Can't move!!! \n");
    	}
    	fout.write("\n  public move()  : was used\n");
    }

    public void damage()
    {
    	if(s_health > 0 && staff > 0)
    	{
    		s_health -= 10;
    		staff -= 1;
    		
    	}else if (s_health == 0)
    	{
    		System.out.print("\n Starship is critically damaged !!! \n");
    	}
    	fout.write("\n  public damage()  : was used\n");
    }

    public void repair()
    {
    	if(s_health < 100)
    	{
    		staff += 5;
    		int coins = captain.getCoins(); 
    		coins -= 50;
    		captain.setCoins(coins);
    	}
    	else
    	{
    		System.out.print("Repaired\n");
    	}
    	fout.write("\n  public repair()  : was used\n");
    }

    public void fight ()
    {
    		is_fighting = true;
    		damage();
    		int coins = captain.getCoins();
    		captain.setCoins(coins + 25);    		
    	   	
    	fout.write("\n  public fight()  : was used\n");
    }

    public void retreat ()
    {
    	is_fighting = false;
    	fout.write("\n  public retreat()  : was used\n");
    }

    public void stats ()
    {
    	System.out.print("Stats : \n");
    	System.out.print("Name : " + s_name + "\n");
    	System.out.print("Fuel : " + fuel + "\n");
    	System.out.print("Health : " + s_health + "\n");
    	System.out.print("Staff : " + staff + "\n");
    	System.out.print("Fighting : " + is_fighting + "\n\n");
    	fout.write("\n  public stats()  : was used\n");
    	
    }

    public void refuel()
    {
    	fuel = 100;
    	int coins = captain.getCoins();
		captain.setCoins(coins - 25); 
		fout.write("\n  public refuel()  : was used\n");
    }

    public void clearShip_logs()


    {
    	fout.write("public void clearShip_logs() : was used\n");
    	try 
    	{
           PrintWriter clearWriter = new PrintWriter("Starship_log.txt");
           clearWriter.close();           
        } catch (FileNotFoundException e) {
            System.err.println("Помилка: файл 'Starship_log.txt' не може бути очищений.");
        }
    }
    
}


class Captain {
    private String name;
	private int coins;
    private int health;
    private static int id = 0;
    private PrintWriter fout;
    
    public String getName() {
    	fout.write("\n public String getName() : was used\n");
		return name;
	}

	public void setName(String name) {
		fout.write("\n public void setName(String name) : was used\n");
		this.name = name;
	}

	public int getCoins() {
		fout.write("\n public int getCoins()  : was used\n");
		return coins;
	}

	public void setCoins(int coins) {
		fout.write("\n public void setCoins(int coins) : was used\n");
		this.coins = coins;
	}

	public int getHealth() {
		fout.write("\n public int getHealth() : was used\n");
		return health;
	}

	public void setHealth(int health) {
		fout.write("\n public void setHealth(int health) : was used\n");
		this.health = health;
	}

    public Captain() {
    	
        this.name = "Noname";
        this.coins = 100;
        this.health = 100;
        id++;

        try {
            fout = new PrintWriter(new BufferedWriter(new FileWriter("Captain_log.txt", true)));
        } catch (IOException e) {
            System.err.println("Помилка: файл Captain_log.txt не може бути створений або записаний.");
        }

        fout.write("\n  public Captain()  : was used\n");
        Captain_stats_file();
    }

    public Captain(String name) {
    	
        this.name = name;
        coins = 100;
        health = 100;
        id++;

        try {
            fout = new PrintWriter(new BufferedWriter(new FileWriter("Captain_log.txt", true)));
        } catch (IOException e) {
            System.err.println("Помилка: файл Captain_log.txt не може бути створений або записаний.");
        }

        fout.write("\n public Captain (String name) : was used\n");
        Captain_stats_file();
    }

    public void Captain_stats_file() {
    	fout.write("\n public void Captain_stats_file() : was used \n\n");
        fout.write("New Captain created :\n");
        fout.write("ID : " + id + "\n");
        fout.write("Name : " + name + "\n");
        fout.write("Coins : " + coins + "\n");
        fout.write("Health : " + health + "\n\n");
        fout.flush();  // Очистити буфер і записати дані в файл
    }

    public void Captain_stats() {
    	fout.write("public void Captain_stats : was used \n");
    	System.out.print("Your captain has : \n");
        System.out.print("Name : " + name + "\n");
        System.out.print("Coins : " + coins + "\n");
        System.out.print("Health : " + health + "\n\n");
    }

    public void close() 
    {
    	fout.write("public void close() : was used\n");
        if (fout != null) 
        {
            fout.close();
        }
    }
    
    public void clearCaptain_logs()
    {
    	fout.write("public void clearCaptain_logs() : was used\n");
    	try 
    	{
           PrintWriter clearWriter = new PrintWriter("Captain_log.txt");
           clearWriter.close();           
        } catch (FileNotFoundException e) {
            System.err.println("Помилка: файл 'Captain_log.txt' не може бути очищений.");
        }
    }

    
}

