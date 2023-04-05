import java.util.ArrayList;

public class StoreFront {
    private static final int NUM_ITEMS = 10;
    ArrayList<Doohickey> inventory = new ArrayList<Doohickey>();
    ArrayList<Integer> counts = new ArrayList<Integer>();

    ArrayList<Integer> countSells = new ArrayList<Integer>();
    boolean isSales = true;

    StoreFront() {
        // populate tech
        inventory.add(new Doohickey("Tech", "Bugatti"));
        counts.add(100);
        inventory.add(new Doohickey("Tech", "Mega Yacht"));
        counts.add(50);
        inventory.add(new Doohickey("Tech", "Startup Series A Funding"));
        counts.add(20);
        inventory.add(new Doohickey("Tech", "Twitter"));
        counts.add(1);

        // populate real estate
        inventory.add(new RealEstateItem("Central American Island"));
        counts.add(10);
        inventory.add(new RealEstateItem("Hollywood Mansion"));
        counts.add(50);
        inventory.add(new RealEstateItem("AirBnBs around the world for 1 year"));
        counts.add(50);
        // populate misc expensive
        inventory.add(new Doohickey("Misc", "Mona Lisa"));
        counts.add(1);
        inventory.add(new Doohickey("Misc", "NBA Team"));
        counts.add(27);
        inventory.add(new Doohickey("Misc", "NFL Team"));
        counts.add(29);

        for (int i = 0; i < NUM_ITEMS; i++) {
            countSells.add(0);
        }

    }

    void setSalesValid(boolean isSales) {
        this.isSales = isSales;
    }

    void printAvailableGoods() {
        // aggregate common goods
        long sum = 0l;
        for (int i = 0; i < inventory.size(); i++) {
            System.out.print("[" + (i + 1) + "]");
            inventory.get(i).printGood();
            System.out.println(", Count: " + counts.get(i));
            sum += counts.get(i) * inventory.get(i).getPrice();
        }
        // System.out.println("Sum " +sum);
    }

    /*
     * removes a specific item based on its index in the inventory.
     * returns the Doohickey if it is successfully bought from the store, null if
     * not.
     */
    Doohickey removeFromStore(int index) {
        if (index > inventory.size() || index < 0) {
            System.out.println("Sorry we don't seem to have this item number.");
            return null;
        } else if (counts.get(index) <= 0) {
            System.out.println("Sorry we are sold out of this item.");
            return null;
        } else {
            // decrement count, increment sells
            counts.set(index, counts.get(index) - 1);
            countSells.set(index, countSells.get(index) + 1);
            return inventory.get(index);
        }
    }

    void printReceipt() {
        for (int i = 0; i < inventory.size(); i++) {
            if (countSells.get(i) == 0) {
                continue;
            }
            System.out.print(inventory.get(i).name);
            System.out.println(", x" + countSells.get(i));
        }
    }

    // called to maybe put a sale on things
    void update() {
        if (isSales) {
            for (int i = 0; i < inventory.size(); i++) {
                inventory.get(i).setSalePrice();
            }
        }
    }
}
