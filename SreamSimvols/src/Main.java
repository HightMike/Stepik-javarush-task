import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException{
//        OutputStream outputStream = new OutputStream() { // предпоследняя мини задача
//            @Override
//            public void write(int b) throws IOException {
//                System.out.printf("%d ", Byte.toUnsignedInt((byte) b));
//            }
//        };
//        PrintStream printStream = new PrintStream(outputStream, true, StandardCharsets.UTF_8.toString());
//        printStream.println('Ы'); //без последнего числа


        Writer writer = new OutputStreamWriter(System.out, StandardCharsets.US_ASCII);
        writer.write("ПриветH");
        writer.flush(); // последняя мини-задача
    }
}

