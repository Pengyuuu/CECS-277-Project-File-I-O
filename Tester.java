/**@authors Erina Lara, Eric Truong
 * Date: March 16, 2020
 * Purpose: Reads in data from a sales file and allows the user to add more data or organize them into their
 * respective categories
 * Input: Information to create more data
 * Output: Sales, conference, dinners, or lodges file with data
 *
 */

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Tester {
    public static void main (String[] args){

        // Create arraylist to hold all data
        ArrayList<Data> dataStrings = new ArrayList<>();
        ArrayList<Data> conferences = new ArrayList<>();
        ArrayList<Data> dinners = new ArrayList<>();
        ArrayList<Data> lodges = new ArrayList<>();


        // reads the file
        readFile(dataStrings);


        // makes sure it's read correctly
        for (int i = 0; i < dataStrings.size(); i++){

            System.out.println(dataStrings.get(i));
        }

        for (int i = 0; i < dataStrings.size(); i++){
            try {
                if (dataStrings.get(i).getService().equals("Conference")) {
                    conferences.add(dataStrings.get(i));
                } else if (dataStrings.get(i).getService().equals("Dinner")) {
                    dinners.add(dataStrings.get(i));
                } else if (dataStrings.get(i).getService().equals("Lodging")) {
                    lodges.add(dataStrings.get(i));
                } else {
                    throw new UnknownServiceException();
                }
            }
            catch (UnknownServiceException e) {
                System.out.println(e);
            }

        }
        writeConference(conferences);
        writeDinner(dinners);
        writeLodge(lodges);

        // if user wants to add data to the file, call the create function first and then the write function
        try {
            createData(dataStrings);
        }
        catch (BadDataException b) {
            System.out.println(b.toString());
        }
        catch (UnknownServiceException e) {
            System.out.println(e.toString());
        }

        writeFile(dataStrings);

    }

    /**
     * Reads data from the sales file
     * @param dataStrings   arraylist to store data from file
     */
    public static void readFile(ArrayList<Data> dataStrings){

        try {

            Scanner read = new Scanner(new File("sales.txt"));

            do {

                // Reads each line and puts it in it's respective category
                String line = read.nextLine();
                String [] tokens = line.split(";");
                Data readLine = new Data(tokens[0], tokens[1], Double.parseDouble(tokens[2]), tokens[3]);

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

    /**
     * Creates data to be written
     * @param dataStrings   arraylist holding data
     * @return              arraylist holding data
     */
    public static ArrayList<Data> createData(ArrayList<Data> dataStrings){

        Scanner scan = new Scanner(System.in);

        boolean write = true;

        // Allows person to write their own data
        while (write){

            System.out.print("Would you like to write data? Y/N: ");

            String decision = scan.nextLine();

            // Creates data from user input

                if (decision.equals("Y") || decision.equals("y")) {

                    try {
                        System.out.print("Name: ");

                        String name = scan.nextLine();

                        System.out.print("\nService: ");

                        String service = scan.nextLine();
                        if (!service.equals("Conference") && !service.equals("Dinner") && !service.equals("Lodging")) {
                            throw new UnknownServiceException();
                        }

                        System.out.print("\nAmount: ");

                        double amount = Double.parseDouble(scan.nextLine());

                        System.out.print("\nDate: ");

                        String date = scan.nextLine();

                        // Adds it to the existing arraylist
                        dataStrings.add(new Data(name, service, amount, date));

                    }
                    catch (NumberFormatException b) {
                        b = new BadDataException();
                        System.out.println(b);
                    }
                    catch (UnknownServiceException e) {
                        System.out.println("Unknown service.");
                    }
                }
                else {
                    write = false;
                }

        }

        return dataStrings;
    }

    /**
     * Writes data to the sales file
     * @param dataStrings   arraylist of data
     */
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

    /**
     * Writes data categorized as conference
     * @param conferences   arraylist of data pertaining to conferences
     */
    public static void writeConference(ArrayList<Data> conferences){

        Scanner scan = new Scanner(System.in);

        try {

            // Writes all the data from the arraylist into the file
            PrintWriter write = new PrintWriter("conference.txt");

            for (int i = 0; i < conferences.size(); i++){

                write.println(conferences.get(i));

            }

            write.close();
        }

        catch (FileNotFoundException fnf){

            System.out.println("File not found");
        }
    }

    /**
     * Writes data categorized as dinner
     * @param dinners   arraylist of data pertaining to dinners
     */
    public static void writeDinner(ArrayList<Data> dinners){

        Scanner scan = new Scanner(System.in);

        try {

            // Writes all the data from the arraylist into the file
            PrintWriter write = new PrintWriter("dinner.txt");

            for (int i = 0; i < dinners.size(); i++){

                write.println(dinners.get(i));

            }

            write.close();
        }

        catch (FileNotFoundException fnf){

            System.out.println("File not found");
        }
    }

    /**
     * Writes data categorized as lodging
     * @param lodges    arraylist of data pertaining to lodging
     */
    public static void writeLodge(ArrayList<Data> lodges){

        Scanner scan = new Scanner(System.in);

        try {

            // Writes all the data from the arraylist into the file
            PrintWriter write = new PrintWriter("lodging.txt");

            for (int i = 0; i < lodges.size(); i++){

                write.println(lodges.get(i));

            }

            write.close();
        }

        catch (FileNotFoundException fnf){

            System.out.println("File not found");
        }
    }
}
