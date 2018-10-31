import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        byte[] bt1 = {'1',' ', '2', ' ', '8', ' ', '9', ' ', '5', ' ', '6', ' ', '7'};
        InputStream bt = new ByteArrayInputStream(bt1);
        System.setIn(bt);
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        ArrayDeque<Integer> deque1 = new ArrayDeque<Integer>();
        Integer ui =0;
        int rt = 0;
        try {
            while (scanner.hasNext()) {
                if (rt%2!=0) {
                    ui = Integer.parseInt(scanner.next()); // парсим в число
                    deque.add(ui);
                    rt++;
                }
                else {
                    scanner.next();
                    rt++;
                }
            }
        }
        catch (java.lang.NumberFormatException e) {

        }

        deque1.addLast(deque.getLast());
        System.out.println(deque);

        Iterator<Integer> it = deque.descendingIterator(); // переворачиваем Очередь наоборот. Iterator для обхода по элементам
        while (it.hasNext()) {
            System.out.print(it.next()+" ");
        }

    }
}
