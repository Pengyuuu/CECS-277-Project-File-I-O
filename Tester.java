import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Tester {
    public static void main (String[] args){

        ArrayList<Data> dataStrings = new ArrayList<>();

        readFile(dataStrings);

        for (int i = 0; i < dataStrings.size(); i++){

            System.out.println(dataStrings.get(i));
        }
    }

    public static void readFile(ArrayList<Data> dataStrings){

        try {

            Scanner read = new Scanner(new File("sales.txt"));

            do {

                String line = read.nextLine();
                String [] tokens = line.split(";");
                Data readLine = new Data(tokens[0], tokens[1], tokens[2], tokens[3]);
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

        while (write){

            System.out.print("Would you like to write data? Y/N: ");

            String decision = scan.nextLine();

            if (decision.equals("Y") || decision.equals("y")){

                System.out.print("Name: ");

                String name = scan.nextLine();

                System.out.print("\nService: ");

                String service = scan.nextLine();

                System.out.print("\nAmount: ");

                String amount = scan.nextLine();

                System.out.print("\nDate: ");

                String date = scan.nextLine();

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
