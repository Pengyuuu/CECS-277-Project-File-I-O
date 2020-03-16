public class Data {

    private String name;
    private String service;
    private double amount;
    private String date;

    public Data(){

        name = "";
        service = "";
        amount = 0;
        date = "";

    }

    public Data(String n, String s, double a, String d){

        name = n;
        service = s;
        amount = a;
        date = d;
    }

    public String getName(){

        return name;
    }

    public String getService(){

        return service;
    }

    public double getAmount(){

        return amount;
    }

    public String getDate(){

        return date;
    }

    public void setName(String n){

        name = n;
    }

    public void setService(String s){

        service = s;
    }

    public void setAmount(double a){

        amount = a;
    }

    public void setDate(String d){

        date = d;
    }

    public String toString(){

        return name + ";" + service + ";" + amount + ";" + date;
    }
}
