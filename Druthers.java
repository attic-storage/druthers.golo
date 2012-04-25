import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Romain Lespinasse (romain.lespinas.se)
 */
public class Druthers {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hey lazy,");
        Thread.sleep(1000);
        System.out.println("Give me your druthers that I can sort them ? Please (quit to ... quit)");
        List<String> druthers = new ArrayList<String>();

        String druther = null;
        while(!"quit".equals(druther)) {
            if(druther != null)
                druthers.add(druther.trim());
            System.out.print(" > ");
            druther = getKeyboardEntry();
        }

        dotPrintln("Thanks lazy, I can start to sort", "with you");
        System.out.println();
        Thread.sleep(1000);

        Collections.sort(druthers, new Comparator<String>() {
            @Override
            public int compare(String druther1, String druther2) {
                System.out.println("What do you prefer between these? (enter if this choice is not possible)");
                System.out.println("   Druther 1 : " + druther1);
                System.out.println("   Druther 2 : " + druther2);
                System.out.print("Make your choice 1 or 2 > ");
                String choice = getKeyboardEntry();
                System.out.println();
                if(choice.equals("1")) {
                    return -1;
                } else if(choice.equals("2")) {
                    return 1;
                }
                return 0;
            }
        });

        if(druthers.size() > 2) {
            System.out.println("It's about time, I'm bored since " + (((int) (Math.random() * druthers.size() - 1)) + 1) + " comparisons");
            Thread.sleep(2000);
        }
        System.out.println();
        System.out.println("Your preferred druthers");
        for(String _druther:druthers) {
            System.out.println("    " + _druther);
        }
        dotPrintln("Good bye, see you soon", "with better druthers, pleeeeeeeease for my sanity!!!");
    }

    private static String getKeyboardEntry() {
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        try {
            line = keyboard.readLine();
        } catch(IOException e) {
            System.out.println("oupps, I broke your keyboard ... or not");
        }
        return line;
    }

    private static void dotPrintln(String firstText, String lastText) throws InterruptedException {
        System.out.println();
        System.out.print(firstText);
        Thread.sleep(1000);
        System.out.print(" .");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(". ");
        Thread.sleep(1000);
        System.out.println(lastText);
    }
}
