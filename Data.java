public class Data {

    private String name;
    private String service;
    private String amount;
    private String date;

    public Data(){

        name = "";
        service = "";
        amount = "";
        date = "";

    }

    public Data(String n, String s, String a, String d){

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

    public String getAmount(){

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

    public void setAmount(String a){

        amount = a;
    }

    public void setDate(String d){

        date = d;
    }

    public String toString(){

        return name + ";" + service + ";" + amount + ";" + date;
    }
}
