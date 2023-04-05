import java.util.ArrayList;
import java.util.Scanner;

public class Wallet {
    static Scanner sc = new Scanner(System.in);
    ArrayList<Doohickey> things = new ArrayList<>(); 
    long cash = 196500000000l; // 196.5 billion 

    public static void main(String[] args) {
        Wallet w = new Wallet();
        StoreFront store = new StoreFront();
        // store.setSalesValid(false); // UNCOMMENT if you wish to turn off sales
        System.out.print("It is 2025. Elon Musk tried to take off in his own rocket ship, and unfortunately he passed.");
        System.out.print("You have inherited his wealth as he stated in his will 'I bequeath my wealth to the person that is responsible for my death',");
        System.out.println("and you are the engineer that created the bug in the ship's oxygen regulation sensors.");
        System.out.println("Let's go to the store and spend all of his wealth!");
        System.out.println("You can always press 'q' if you want to give up.");
        int turn = 1;
        while (w.cash > 0) {
            System.out.println("Turn " + turn + ": Cash on hand: " + w.cash);
            store.printAvailableGoods();
            System.out.println("[q]: I want to give up.");
            int i = ErrorChecking.getInt(sc);
            if (i == Integer.MAX_VALUE) {
                break;
            }
            w.buy(i, store);
            store.update();
            turn++;
        }

        if (w.cash <= 0) {
            System.out.println("Wowwee! You spent all of Musk's wealth in cash! Great job."); 
        } else {
            System.out.println("Yeah, spending this much money's too hard, isn't it?"); 
        }
        System.out.println("You bought:"); 
        store.printReceipt();
    }

    void buy(int i, StoreFront store) {
        Doohickey thing = store.removeFromStore(i - 1); // counting user goods at 1
        if (thing != null) {
            cash -= thing.getPrice();
            things.add(thing);
        }
    }
}
