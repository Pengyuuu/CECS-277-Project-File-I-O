/**@authors Erina Lara, Eric Truong
 *Date: March 16, 2020
 * Program: Creates a string of data containing the name, service, amount, and date to be written to a text file
 */
public class Data {

    /** Name of person */
    private String name;

    /** Service of purchase */
    private String service;

    /** Price paid */
    private double amount;

    /** Date of transaction */
    private String date;

    /** Default constructor for data, setting everything to empty or 0 */
    public Data(){

        name = "";
        service = "";
        amount = 0;
        date = "";

    }

    /**
     * Overloaded constructor
     * @param n name
     * @param s service
     * @param a amount
     * @param d date
     */
    public Data(String n, String s, double a, String d){

        name = n;
        service = s;
        amount = a;
        date = d;
    }

    /**
     * Gives name of person
     * @return  name of person
     */
    public String getName(){

        return name;
    }

    /**
     * Gives the category of purchase
     * @return  category of transaction
     */
    public String getService(){

        return service;
    }

    /**
     * Gives the amount paid
     * @return  amount of money
     */
    public double getAmount(){

        return amount;
    }

    /**
     * Gives the date of transaction
     * @return  date of transaction
     */
    public String getDate(){

        return date;
    }

    /**
     * Sets name to something else
     * @param n name to be changed to
     */
    public void setName(String n){

        name = n;
    }

    /**
     * Sets service to something else
     * @param s service to be changed to
     */
    public void setService(String s){

        service = s;
    }

    /**
     * Sets amount to another value
     * @param a amount to be changed to
     */
    public void setAmount(double a){

        amount = a;
    }

    /**
     * Sets date to another time
     * @param d date to be changed to
     */
    public void setDate(String d){

        date = d;
    }

    /**
     * Puts all variables in a nicely, formatted string
     * @return  formatted string to be written to text files
     */
    @Override
    public String toString(){

        return name + ";" + service + ";" + amount + ";" + date;
    }
}
