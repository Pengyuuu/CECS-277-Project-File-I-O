import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Tester {
    public static void main (String[] args){

        // Create arraylist to hold all data
        ArrayList<Data> dataStrings = new ArrayList<>();

        // reads the file
        readFile(dataStrings);


        // makes sure it's read correctly
        for (int i = 0; i < dataStrings.size(); i++){

            System.out.println(dataStrings.get(i));
        }

        // if user wants to add data to the file, call the create function first and then the write function
    }

    public static void readFile(ArrayList<Data> dataStrings){

        try {

            Scanner read = new Scanner(new File("sales.txt"));

            do {

                // Reads each line and puts it in it's respective category
                String line = read.nextLine();
                String [] tokens = line.split(";");
                Data readLine = new Data(tokens[0], tokens[1], tokens[2], tokens[3]);

                // Adds it to the arraylist
                dataStrings.add(readLine);

            }

            while (read.hasNext());

            read.close();
        }

        catch (FileNotFoundException fnf){

            System.out.println("File not found");
        }

    }

    public static ArrayList<Data> createData(ArrayList<Data> dataStrings){

        Scanner scan = new Scanner(System.in);

        boolean write = true;

        // Allows person to write their own data
        while (write){

            System.out.print("Would you like to write data? Y/N: ");

            String decision = scan.nextLine();

            // Creates data from user input
            if (decision.equals("Y") || decision.equals("y")){

                System.out.print("Name: ");

                String name = scan.nextLine();

                System.out.print("\nService: ");

                String service = scan.nextLine();

                System.out.print("\nAmount: ");

                String amount = scan.nextLine();

                System.out.print("\nDate: ");

                String date = scan.nextLine();

                // Adds it to the existing arraylist
                dataStrings.add(new Data(name, service, amount, date));
            }

            else {

                write = false;
            }
        }

        return dataStrings;
    }

    public static void writeFile(ArrayList<Data> dataStrings){

        Scanner scan = new Scanner(System.in);

        try {

            // Writes all the data from the arraylist into the file
            PrintWriter write = new PrintWriter("sales.txt");

            for (int i = 0; i < dataStrings.size(); i++){

                write.println(dataStrings.get(i));
            }

            write.close();
        }

        catch (FileNotFoundException fnf){

            System.out.println("File not found");
        }
    }
}
