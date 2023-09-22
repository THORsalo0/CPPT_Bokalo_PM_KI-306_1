package KI306.Bokalo.Lab5;

import java.util.Scanner;

import java.io.*;
/**
 * Тут реалізований клас Calco, який рахує Ctg введеного числа, дані беруться з файлів
 * @author Petro Bokalo KI-306
 * @version 1.0
 * @since version 1.0
 */
public class Calco {
    private double x,y;
    private double ctg = 0;
    private PrintWriter fout;
   

    public Calco(String in_file, String in_file_bin) throws IOException {

    	try (BufferedReader reader = new BufferedReader(new FileReader(in_file))) 
    	{
            String line = reader.readLine();
            x = Double.parseDouble(line);
            reader.close();
    	} 
    	try (DataInputStream fin_bin = new DataInputStream (new FileInputStream (in_file_bin)))
    	{
    		y = fin_bin.readDouble();
    		fin_bin.close();
    	}
        catch (IOException e) {
            System.err.println("Can't use the file!!!\n");
        }
    	
    }

    public double result(double num) throws ArithmeticException {
        if (Math.tan(num) == 0) {
            throw new ArithmeticException("Exception: Tan is equal to 0!!!\n");
        } else {
            ctg = 1 / Math.tan(num);
        }

        return ctg;
    }

    public void in_files(String out_file, String out_file_bin) {
        try 
        {
            fout = new PrintWriter(new BufferedWriter(new FileWriter(out_file)));
            fout.print("Ctg of x = " + result(x) + "\n");
            fout.close();
            DataOutputStream fout_bin = new DataOutputStream(new FileOutputStream(out_file_bin));
            fout_bin.writeChars("Ctg of x(binary file) = " + result(y) + "\n");
            fout_bin.close();

        }         
        catch (IOException e) {
            System.err.println("Can't use the file!!!\n");
        } 
        catch (ArithmeticException a) {
            System.out.print(a.getMessage());
        }
    }

}
