import java.util.Scanner;

public class ErrorChecking {
    // returns max value if you quit.
    public static int getInt(Scanner sc) {
        if (sc.hasNextInt()) {
            return sc.nextInt();
        } else if (sc.next().equals("q")) {
            return Integer.MAX_VALUE;
        } else {
            System.out.println("This is not a valid input. Discarding this input");
            return getInt(sc);
        }
    }
}
