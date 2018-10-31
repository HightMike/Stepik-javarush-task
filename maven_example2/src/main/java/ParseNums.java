import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ParseNums {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int integerVar = scanner.nextInt(); // 22
        //String str = scanner.next();;
        Double d=0.0;
        float f = 5;
        try {
            while (scanner.hasNext()) {
                if (scanner.hasNextDouble()) {
                    d+=Double.parseDouble(scanner.next());

                }
                else {
                    scanner.next();
                }
            }
        }
        catch (java.lang.NumberFormatException e) {

        }
        System.out.format("%.6f", d);

    }
}
