import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {
    //Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.
    //
    //Пример
    //
    //InputStream последовательно возвращает четыре байта: 48 49 50 51.
    //
    //Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку "0123".
    public static void main (String args[]) {
        byte[] arr = {48, 49, 50, 51};
        ByteArrayInputStream inputStream = new ByteArrayInputStream(arr);


    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        int rd =0;
        StringBuilder str = new StringBuilder();
        charset = StandardCharsets.US_ASCII;
        Reader reader = new InputStreamReader(inputStream, charset);
        while ((reader.read())!=-1) {
            str.append((char) rd);
        }
        return str.toString();
    }
}
