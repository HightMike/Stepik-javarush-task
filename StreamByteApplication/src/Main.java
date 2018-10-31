import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        //byte[] bytes = {65, 66, 13, 13, 10, 10, 13, 67, 13, 13};
        //д.б. 65, 66, 13, 10, 10, 13, 67, 13, 13
        byte[] arr = { 65, 13, 10, 10, 13 }; //для проверки
        ByteArrayInputStream inputStream = new ByteArrayInputStream(arr);
        System.setIn(inputStream);
        int next = 0;
        int tyu = System.in.read(); // читаем новый байт из потока первый байт и запоминаем его за этой переменной

            if (tyu !=-1 ) {
                while (tyu != -1) {
                    next = System.in.read(); // прочитали след байт
                    //tyu = System.in.read(); // читаем новый байт из потока
                    //myList1.add(tyu);
                    if (tyu == 13 & next == 10) {
                        tyu = next; // если 13 и 10, то присваиваем tyu значение 10 и уже следующим шагом выводим в консоль
                    }
                    else {
                        System.out.println(tyu);
                        tyu=next;
                    }
                }
                System.out.flush();
            }
            else {
                System.out.flush();
            }
    }
    //д.б. 65, 66, 13, 10, 10, 13, 67, 13, 13

}