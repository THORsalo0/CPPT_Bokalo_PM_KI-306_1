import java.io.*;
import java.util.*;
/**
 * Ця програма виводить в консоль та у файл рисунок згідно до 2 варіанту 
 * @author Petro Bokalo KI-203
 * @version 1.0
 * @since version 1.0
 */

public class Lab1BokaloKI306 {

    public static void main(String[] args) throws FileNotFoundException {

        String symbol;
        int N;
        char[][] matrix;
        PrintWriter fout = new PrintWriter("Lab1.txt");

        Scanner input = new Scanner(System.in);
        System.out.print("Input number of elements : ");
        N = input.nextInt();
        System.out.print("Your matrix will have " + N + " rows and columns\n");

        if (N < -1) {
            N *= -1;
        } else if (N == 0) {
            System.out.print("Invalid number for N");
            System.exit(0);
        } else if (N % 2 != 0) {
            N += 1;
            System.out.print("Your number was odd, so your number is now : " + N + "\n");
        }

        System.out.print("\nInput your placeholder symbol : ");
        input.nextLine();

        symbol = input.nextLine();
        System.out.print("\nYour placeholder is : " + symbol + "\n");

        if (symbol.length() > 1) {
            System.out.print("You've entered too many symbols");
            System.exit(0);
        }

        // Ініціалізуємо зубчастий масив потрібною кількістю рядків
        int checker = 0;
        
        	
        
        matrix = new char[N][];

        for (int i = 0; i < N ; i++) {
        	if(checker < N/2)
            {
            matrix[i] = new char[i + 1];
            for (int j = 0; j <= i; j++) {
                matrix[i][j] = symbol.charAt(0);
                System.out.print(matrix[i][j] + "\t");
                fout.write(matrix[i][j] + "\t");
            }
            System.out.println();
            fout.write("\n");
            }
        	
        	else
        	{
        	matrix[i] = new char[i + 1];
        	
        		for(int j = N/2; j > 0; j--)
        		{
        			
        			System.out.print("\t");
        			fout.write("\t");
        		}
        		
        		 for (int j = N/2; j <= i; j++) {
                     matrix[i][j] = symbol.charAt(0);
                     System.out.print(matrix[i][j] + "\t");
                     fout.write(matrix[i][j] + "\t");
                 }
                 System.out.println();
                 fout.write("\n");
        	}
        	
        	checker++;
        }
        fout.close();
        input.close();
        System.out.close();
    }
}
