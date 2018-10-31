import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        //byte[] bytes = {65, 66, 13, 13, 10, 10, 13, 67, 13, 13};
        byte[] arr = {65, 66, 13, 13, 10, 10, 13, 67, 13, 13};
        ByteArrayInputStream inputStream = new ByteArrayInputStream(arr);
        System.setIn(inputStream);
        int tyu = System.in.read();
        ArrayList myList = new ArrayList();
        //ArrayList myList1 = new ArrayList();

        while (tyu != 10) {
            tyu = System.in.read(); // читаем новый байт из потока
            if (tyu == 13) {
                //myList.add(tyu); // добавляем в переменную
                tyu = System.in.read();
                if (tyu ==10) {
                    myList.add(tyu); // добавляем в переменную
                }
            }
            else {
                myList.add(tyu);
            }
        }
        System.out.print(myList);
    }

}