package KI306.Bokalo.Lab5;

import java.io.*;
import java.util.Scanner;

/**
 * Дана програма є класом драйвером який тестує роботу класу Calco, а також записує дані у файли
 * @author Petro Bokalo KI-306
 * @version 1.0
 * @since version 1.0
*/

public class Lab5BokaloKI306 {
    public static void main(String[] args)throws IOException {
        double x;
        String in_file = "For_decimal.txt";
        String in_file_bin = "For_binary.dat";
        String out_file = "Out_decimal.txt";
        String out_file_bin = "Out_binary";
        Scanner input = new Scanner(System.in);
        PrintWriter fout = null;
        DataOutputStream fout_bin = null;
        
        try {
            fout = new PrintWriter(in_file);
            System.out.print("Enter a decimal number: ");
            x = input.nextDouble();
            fout.print(x);
            
            fout_bin = new DataOutputStream(new FileOutputStream(in_file_bin));
            fout_bin.writeDouble(x);          
            fout_bin.close();
            
        } catch (IOException e) {
            System.err.println("Error opening or writing to the file.");
        } finally {
            if (fout != null) {
                fout.close();
            }
        }

        Calco c = new Calco(in_file, in_file_bin);
        c.in_files(out_file, out_file_bin);
        
        BufferedReader reader = new BufferedReader(new FileReader(out_file));
        System.out.print(reader.readLine() + "\n");
        
        DataInputStream fin_bin = new DataInputStream (new FileInputStream (out_file_bin));
        System.out.print(fin_bin.readLine());
        
    }
}
