import java.util.Random;

public class Doohickey {
    String type;
    String name;
    long price;
    long salePrice;
    Random r = new Random();

    // Items sourced from https://www.spend-elon-fortune.com/
    Doohickey(String type, String name) {
        this.type = type;
        this.name = name;
        if (name.equals("Central American Island")) {
            this.price = 4950000;
        } else if (name.equals("Hollywood Mansion")) {
            this.price = 52000000;
        } else if (name.equals("AirBnBs around the world for 1 year")) {
            this.price = 1300000;
        } else if (name.equals("Bugatti")) {
            this.price = 11000000;
        } else if (name.equals("Private Jet")) {
            this.price = 17000000;
        } else if (name.equals("Mega Yacht")) {
            this.price = 4950000;
        } else if (name.equals("Startup Series A Funding")) {
            this.price = 300000000;
        } else if (name.equals("Mona Lisa")) {
            this.price = 869000000;
        } else if (name.equals("NBA Team")) {
            this.price = 2400000000l;
        } else if (name.equals("NFL Team")) {
            this.price = 3000000000l;
        } else if (name.equals("Twitter")) {
            this.price = 44000000000l;
        }

        this.salePrice = this.price;
    }

    long getPrice() {
        return salePrice;
    }

    // Now the subclasses can just deal with this!
    long setSalePrice() {
        return salePrice;
    }

    
    // print the good
    void printGood() {
        System.out.print("Good: " + name + ", Price: ");

        if (salePrice != price) {
            System.out.print("$" + salePrice + " (" + type + " Sale!)");
        } else {
            System.out.print("$" + price);
        }
    }
}
